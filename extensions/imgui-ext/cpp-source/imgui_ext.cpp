#include "imgui.h"
#include "imgui_internal.h"
#include "imgui_ext.h"
#include "imgui_layout.h"

// ##################################  ImGuiExt  ###############################################

ImGuiStorage* ImGuiExt::GetImGuiStorage(ImGuiID id) {
	ImGuiContext& g = *GImGui;
	ImGuiStorage* childLayout = NULL;
	childLayout = (ImGuiStorage*)g.WindowsById.GetVoidPtr(id);
	if (childLayout == NULL) {
		childLayout = IM_NEW(ImGuiStorage)();
		g.WindowsById.SetVoidPtr(id, childLayout);
	}
	return childLayout;
}

ImGuiStorage* ImGuiExt::GetImGuiStorage(const char* id_str) {
	return ImGuiExt::GetImGuiStorage(ImHashStr(id_str));
}

static int TABLE_HEIGHT_KEY = 15000;
static int TABLE_HEIGHT_KEY_AUX = 150;

float ImGuiExt::GetTableContentHeight() {
	ImGuiContext& g = *GImGui;
	ImGuiTable* table = g.CurrentTable;
	if (table != NULL) {
		ImGuiWindow* window = table->InnerWindow;
		float y = window->DC.CursorPos.y;
		float itemSpacingY = g.Style.ItemSpacing.y;

		float height = y - table->RowPosY1 - table->CellPaddingY - itemSpacingY;

		return height;
	}
	return 0;
}

void ImGuiExt::CalculateTableRowHeight() {
	ImGuiContext& g = *GImGui;
	ImGuiTable* table = g.CurrentTable;
	if (table != NULL) {
		float height = ImGuiExt::GetTableContentHeight();
		ImGuiStorage* storage = ImGuiExt::GetImGuiStorage(table->ID);
		int column = table->CurrentColumn;
		bool lastColumn = (column == table->ColumnsCount -1);
		int row = table->CurrentRow;
		float tempHeight = storage->GetFloat(TABLE_HEIGHT_KEY_AUX + row, 0.0F);
		if (column == 0)
			tempHeight = 0;
		if (height > tempHeight) {
			tempHeight = height;
			storage->SetFloat(TABLE_HEIGHT_KEY_AUX + row, tempHeight);
		}
		float curHeight = storage->GetFloat(TABLE_HEIGHT_KEY + row, 0.0F);
		float updateHeight = -1;
		if (height > curHeight)
			updateHeight = height;
		if (lastColumn && curHeight != tempHeight)
			updateHeight = tempHeight;  // if a view update its height it will update the new row height
		if(updateHeight >= 0 )
			storage->SetFloat(TABLE_HEIGHT_KEY + row, updateHeight);
	}
}

float ImGuiExt::GetTableRowHeight() {
	ImGuiContext& g = *GImGui;
	ImGuiTable* table = g.CurrentTable;
	if (table != NULL) {
		ImGuiStorage* storage = ImGuiExt::GetImGuiStorage(table->ID);
		float curHeight = storage->GetFloat(TABLE_HEIGHT_KEY + table->CurrentRow, 0.0F);
		return curHeight;
	}
	return 0;
}


template<typename TYPE>
static const char* ImAtoi(const char* src, TYPE* output)
{
	// TODO FIX EXTERN
	// Couldn't get extern to work so this code is duplicated from imgui.widgets.cpp

	int negative = 0;
	if (*src == '-') { negative = 1; src++; }
	if (*src == '+') { src++; }
	TYPE v = 0;
	while (*src >= '0' && *src <= '9')
		v = (v * 10) + (*src++ - '0');
	*output = negative ? -v : v;
	return src;
}

template<typename TYPE, typename SIGNEDTYPE>
TYPE RoundScalarWithFormatT(const char* format, ImGuiDataType data_type, TYPE v)
{
	// TODO FIX EXTERN
	// Couldn't get extern to work so this code is duplicated from imgui.widgets.cpp

	const char* fmt_start = ImParseFormatFindStart(format);
	if (fmt_start[0] != '%' || fmt_start[1] == '%') // Don't apply if the value is not visible in the format string
		return v;
	char v_str[64];
	ImFormatString(v_str, IM_ARRAYSIZE(v_str), fmt_start, v);
	const char* p = v_str;
	while (*p == ' ')
		p++;
	if (data_type == ImGuiDataType_Float || data_type == ImGuiDataType_Double)
		v = (TYPE)ImAtof(p);
	else
		ImAtoi(p, (SIGNEDTYPE*)&v);
	return v;
}

ImRect renderLeftLabel(ImU32 leftLabelColor, char* leftLabel) {
	ImGuiExt::BeginBoundingBox();
	ImGui::AlignTextToFramePadding();
	if (leftLabelColor != 0)
		ImGui::PushStyleColor(ImGuiCol_Text, leftLabelColor);
	ImGui::Text(leftLabel);
	if (leftLabelColor != 0)
		ImGui::PopStyleColor();
	return ImGuiExt::EndBoundingBox();
}

template<typename TYPE, typename SIGNEDTYPE, typename FLOATTYPE>
bool renderEdittextLabel(const int uniqueId, ImGuiDataType data_type, TYPE* v, const EditTextData<TYPE> data) {

	ImGuiContext& g = *GImGui;
	ImGuiWindow* window = ImGui::GetCurrentWindow();
	static int SINGLE_EDITTEXT_DRAG = 0;
	ImU32 leftLabelColor = SINGLE_EDITTEXT_DRAG == uniqueId && data.leftLabelDragColor != 0 ? data.leftLabelDragColor : data.leftLabelColor;

	ImRect boundingBox = renderLeftLabel(leftLabelColor, data.leftLabel);

	bool isDisabled = (window->DC.ItemFlags & ImGuiItemFlags_Disabled) == ImGuiItemFlags_Disabled;
	bool hovered = ImGui::IsMouseHoveringRect(boundingBox.Min, boundingBox.Max);
	bool mouseDown = ImGui::IsMouseDown(ImGuiMouseButton_Left);
	const bool clicked = (hovered && g.IO.MouseClicked[0]) && data_type != -1;

	if (!isDisabled && clicked && hovered && SINGLE_EDITTEXT_DRAG == 0) {
		ImGui::SetActiveID(uniqueId, window);
		SINGLE_EDITTEXT_DRAG = uniqueId;
	}

	if (SINGLE_EDITTEXT_DRAG == uniqueId && mouseDown == false) {
		SINGLE_EDITTEXT_DRAG = 0;
	}

	if (SINGLE_EDITTEXT_DRAG == uniqueId) {
		float  adjust_delta = ImGui::GetMouseDragDelta(ImGuiMouseButton_Left, 0.0f).x;
		ImGui::ResetMouseDragDelta(ImGuiMouseButton_Left);

		if (adjust_delta != 0) {
			//NOTE: code in this block is using ImGui::DragBehaviorT implementation 

			TYPE v_min = data.v_min;
			TYPE v_max = data.v_max;
			float power = data.power;
			float v_speed = data.v_speed;
			const char* format = data.format;

			const bool is_decimal = (data_type == ImGuiDataType_Float) || (data_type == ImGuiDataType_Double);
			const bool is_clamped = (v_min < v_max);
			const bool is_power = (power != 1.0f && is_decimal && is_clamped && (v_max - v_min < FLT_MAX));
			const bool is_locked = (v_min > v_max);
			if (is_locked)
				return false;
			// Default tweak speed
			if (v_speed == 0.0f && is_clamped && (v_max - v_min < FLT_MAX))
				v_speed = (float)((v_max - v_min) * g.DragSpeedDefaultRatio);

			adjust_delta *= v_speed;

			// Clear current value on activation
			// Avoid altering values and clamping when we are _already_ past the limits and heading in the same direction, so e.g. if range is 0..255, current value is 300 and we are pushing to the right side, keep the 300.
			bool is_just_activated = g.ActiveIdIsJustActivated;
			bool is_already_past_limits_and_pushing_outward = is_clamped && ((*v >= v_max && adjust_delta > 0.0f) || (*v <= v_min && adjust_delta < 0.0f));
			bool is_drag_direction_change_with_power = is_power && ((adjust_delta < 0 && g.DragCurrentAccum > 0) || (adjust_delta > 0 && g.DragCurrentAccum < 0));
			if (is_just_activated || is_already_past_limits_and_pushing_outward || is_drag_direction_change_with_power)
			{
				g.DragCurrentAccum = 0.0f;
				g.DragCurrentAccumDirty = false;
			}
			else if (adjust_delta != 0.0f)
			{
				g.DragCurrentAccum += adjust_delta;
				g.DragCurrentAccumDirty = true;
			}

			if (!g.DragCurrentAccumDirty)
				return false;

			TYPE v_cur = *v;
			FLOATTYPE v_old_ref_for_accum_remainder = (FLOATTYPE)0.0f;
			if (is_power)
			{
				// Offset + round to user desired precision, with a curve on the v_min..v_max range to get more precision on one side of the range
				FLOATTYPE v_old_norm_curved = ImPow((FLOATTYPE)(v_cur - v_min) / (FLOATTYPE)(v_max - v_min), (FLOATTYPE)1.0f / power);
				FLOATTYPE v_new_norm_curved = v_old_norm_curved + (g.DragCurrentAccum / (v_max - v_min));
				v_cur = v_min + (SIGNEDTYPE)ImPow(ImSaturate((float)v_new_norm_curved), power) * (v_max - v_min);
				v_old_ref_for_accum_remainder = v_old_norm_curved;
			}
			else
			{
				v_cur += (SIGNEDTYPE)g.DragCurrentAccum;
			}

			// Round to user desired precision based on format string
			v_cur = RoundScalarWithFormatT<TYPE, SIGNEDTYPE>(format, data_type, v_cur);

			// Preserve remainder after rounding has been applied. This also allow slow tweaking of values.
			g.DragCurrentAccumDirty = false;
			if (is_power)
			{
				FLOATTYPE v_cur_norm_curved = ImPow((FLOATTYPE)(v_cur - v_min) / (FLOATTYPE)(v_max - v_min), (FLOATTYPE)1.0f / power);
				g.DragCurrentAccum -= (float)(v_cur_norm_curved - v_old_ref_for_accum_remainder);
			}
			else
			{
				g.DragCurrentAccum -= (float)((SIGNEDTYPE)v_cur - (SIGNEDTYPE)*v);
			}

			// Lose zero sign for float/double
			if (v_cur == (TYPE)-0)
				v_cur = (TYPE)0;

			// Clamp values (+ handle overflow/wrap-around for integer types)
			if (*v != v_cur && is_clamped)
			{
				if (v_cur < v_min || (v_cur > * v&& adjust_delta < 0.0f && !is_decimal))
					v_cur = v_min;
				if (v_cur > v_max || (v_cur < *v && adjust_delta > 0.0f && !is_decimal))
					v_cur = v_max;
			}
			// Apply result
			if (*v == v_cur)
				return false;
			else {
				*v = v_cur;
				return true;
			}
		}
	}
	return false;
}

static int InputTextCallback(ImGuiInputTextCallbackData* data)
{
	std::string* str = (std::string*)data->UserData;
	if (data->EventFlag == ImGuiInputTextFlags_CallbackResize)
	{
		// Resize string callback
		// If for some reason we refuse the new length (BufTextLen) and/or capacity (BufSize) we need to set them back to what we want.
		IM_ASSERT(data->Buf == str->c_str());
		str->resize(data->BufTextLen);
		data->Buf = (char*)str->c_str();
	}
	return 0;
}

template<typename TYPE>
static bool singleEdittext(const int id, ImGuiDataType data_type, EditTextData<TYPE> * data, int flags) {
	ImGuiWindow* window = ImGui::GetCurrentWindow();
	if (window->SkipItems)
		return false;
	ImGuiContext& g = *GImGui;

	// Make tooltip time work with disabled widget
	int backupFlags = window->DC.ItemFlags;
	window->DC.ItemFlags = window->DC.ItemFlags & ~ImGuiItemFlags_Disabled;

	ImGui::PushID(id);
	ImGui::BeginGroup();
	bool ret = false;
	
	if (data->leftLabel != NULL) {
		unsigned int uniqueId = window->GetIDNoKeepAlive(id);
		float power = 1.0f;

		switch (data_type)
		{
			case ImGuiDataType_Float: { 
				float* val = (float*)&data->value;
				ret = renderEdittextLabel<float, float, float >(uniqueId, ImGuiDataType_Float, val, *(EditTextData<float>*)data);
				ImGui::SameLine(0, 0);
				break;
			}
			case ImGuiDataType_S32: { 
				ret = renderEdittextLabel<ImS32, ImS32, float >(uniqueId, ImGuiDataType_S32, (ImS32*)&data->value, *(EditTextData<ImS32>*)data);
				ImGui::SameLine(0, 0);
				break;
			}
			case -1: {
				ImU32 leftLabelColor = data->leftLabelColor;
				renderLeftLabel(leftLabelColor, data->leftLabel);
				ImGui::SameLine(0, 0);
				break;
			}
			case ImGuiDataType_COUNT: break;
		}
	}

	flags |= ImGuiInputTextFlags_EnterReturnsTrue;

	ImGui::SetNextItemWidth(-1);

	ImGuiExt::BeginBoundingBox();

	TYPE value = data->value; // Copy the value
	void* voidValue = static_cast<void*>(&value);

	if (data_type == -1) { // String
		std::string* stringPtr = static_cast<std::string*>(voidValue);
		std::string str = *stringPtr;
		flags |= ImGuiInputTextFlags_CallbackResize;
		if (ImGui::InputText("##input text", (char*)str.c_str(), str.capacity(), flags, InputTextCallback, &str)) {
			int newSize = str.size();
			bool updateChar = data->maxChar >= 0 && newSize < data->maxChar || data->maxChar == -1;
			if (updateChar) {
				// update string data pointer
				void* voidValue = static_cast<void*>(&data->value);
				std::string* newStr = static_cast<std::string*>(voidValue);
				*newStr = str;
				ret = true;
			}
		}
	}
	else {
		if (ImGui::InputScalar("", data_type, voidValue, NULL, NULL, data->format, flags)) {
			bool updateValue = false;

			void* voidMax = static_cast<void*>(&data->v_max);
			void* voidMin = static_cast<void*>(&data->v_min);

			switch (data_type) {
				case ImGuiDataType_S16: // short
				{
					ImS16* maxPtr = static_cast<ImS16*>(voidMax);
					ImS16 max = *maxPtr;
					ImS16* minPtr = static_cast<ImS16*>(voidMin);
					ImS16 min = *minPtr;
					if ((min == 0 && max == 0)) {
						updateValue = true;
					}
				}
				break;
				case ImGuiDataType_S32: // int
				{
					ImS32* maxPtr = static_cast<ImS32*>(voidMax);
					ImS32 max = *maxPtr;
					ImS32* minPtr = static_cast<ImS32*>(voidMin);
					ImS32 min = *minPtr;
					if ((min == 0 && max == 0)) {
						updateValue = true;
					}
			
				}
				break;
				case ImGuiDataType_S64: // long long / __int64
				{
					ImS64* maxPtr = static_cast<ImS64*>(voidMax);
					ImS64 max = *maxPtr;
					ImS64* minPtr = static_cast<ImS64*>(voidMin);
					ImS64 min = *minPtr;
					if ((min == 0 && max == 0)) {
						updateValue = true;
					}
				}
				break;
				case ImGuiDataType_Float:  // float
				{
					float* maxPtr = static_cast<float*>(voidMax);
					float max = *maxPtr;
					float* minPtr = static_cast<float*>(voidMin);
					float min = *minPtr;
					if ((min == 0 && max == 0)) {
						updateValue = true;
					}
				}
				break;
				case ImGuiDataType_Double: // double
				{
					double* maxPtr = static_cast<double*>(voidMax);
					double max = *maxPtr;
					double* minPtr = static_cast<double*>(voidMin);
					double min = *minPtr;
					if ((min == 0 && max == 0)) {
						updateValue = true;
					}
				}
				break;
			}
				
			if (updateValue || value >= data->v_min && value <= data->v_max) {
				data->value = value;
				ret = true;
			}
		}
	}
	ImRect rect = ImGuiExt::EndBoundingBox();
	ImGui::EndGroup();

	bool isHoverable = ImGui::IsMouseHoveringRect(rect.Min, rect.Max);
	window->DC.ItemFlags = backupFlags;

	//ImGuiExt::DrawBoundingBox(rect.Min, rect.Max, 255, 0, 0, 255); // Debug houverable bounding box

	if (isHoverable && data->tooltip != NULL && g.HoveredIdTimer > data->tooltipDelay) {
		ImGui::BeginTooltip();
		ImGui::SetTooltip(data->tooltip);
		ImGui::EndTooltip();
	}
	ImGui::PopID();
	return ret;
}

template<typename TYPE>
int ImGuiExt::EditText(const char* id, int size, ImGuiDataType data_type, intptr_t* dataArray, int flags) {
	IM_ASSERT(id);
	IM_ASSERT(size > 0);
	IM_ASSERT(dataArray);

	int retFlags = -1;
	int tableFlags = ImGuiTableFlags_Resizable | ImGuiTableFlags_Reorderable;
	int inputFlags = flags;

	if (size == 1 && data_type == ImGuiDataType_Float) 
		inputFlags |= ImGuiInputTextFlags_CharsScientific;

	if (ImGui::BeginTable(id, size, tableFlags)) {
		for (int i = 0; i < size; i++) {
			ImGui::TableNextColumn();
			EditTextData<TYPE>* data = (EditTextData<TYPE> *)dataArray[i];
			if (singleEdittext(i + 1, data_type, data, inputFlags))
				retFlags = i;	
		}
		ImGui::EndTable();
	}
	return retFlags;
}

template<typename TYPE>
int prepareEditText(const char* id, ImGuiDataType data_type, void* data01, void* data02, void* data03, void* data04, int flags) {
	IM_ASSERT(data01);
	const int maxSize = 4;
	int size = 1;
	if (data02 != NULL)
		size++;
	if (data03 != NULL)
		size++;
	if (data04 != NULL)
		size++;
	intptr_t datas[maxSize];
	datas[0] = (intptr_t)data01;
	datas[1] = (intptr_t)data02;
	datas[2] = (intptr_t)data03;
	datas[3] = (intptr_t)data04;
	return ImGuiExt::EditText<TYPE>(id, size, data_type, datas, flags);
}

int ImGuiExt::EditTextI(const char* id, EditTextData<int>* data01, EditTextData<int>* data02, EditTextData<int>* data03, EditTextData<int>* data04, int flags) {
	return prepareEditText<ImS32>(id, ImGuiDataType_S32, data01, data02, data03, data04, flags);
}

int ImGuiExt::EditTextF(const char* id, EditTextData<float>* data01, EditTextData<float>* data02, EditTextData<float>* data03, EditTextData<float>* data04, int flags) {
	return prepareEditText<float>(id, ImGuiDataType_Float, data01, data02, data03, data04, flags);
}

int ImGuiExt::EditTextS(const char* id, EditTextData<std::string>* data01, EditTextData<std::string>* data02, int flags) {
	return prepareEditText<std::string>(id, -1, data01, data02, NULL, NULL, flags);
}