package com.xpenatan.imgui.enums;
/**
 * Flags for ImGui::InputText()
 */
public enum ImGuiInputTextFlags_ {
	ImGuiInputTextFlags_None(0),
	/** Allow 0123456789.+-* */
	ImGuiInputTextFlags_CharsDecimal(1 << 0),
	/** Allow 0123456789ABCDEFabcdef */
	ImGuiInputTextFlags_CharsHexadecimal(1 << 1),
	/** Turn a..z into A..Z */
	ImGuiInputTextFlags_CharsUppercase(1 << 2),
	/** Filter out spaces, tabs */
	ImGuiInputTextFlags_CharsNoBlank(1 << 3),
	/** Select entire text when first taking mouse focus */
	ImGuiInputTextFlags_AutoSelectAll(1 << 4),
	/** Return 'true' when Enter is pressed (as opposed to every time the value was modified). Consider looking at the IsItemDeactivatedAfterEdit() function. */
	ImGuiInputTextFlags_EnterReturnsTrue(1 << 5),
	/** Callback on pressing TAB (for completion handling) */
	ImGuiInputTextFlags_CallbackCompletion(1 << 6),
	/** Callback on pressing Up/Down arrows (for history handling) */
	ImGuiInputTextFlags_CallbackHistory(1 << 7),
	/** Callback on each iteration. User code may query cursor position, modify text buffer. */
	ImGuiInputTextFlags_CallbackAlways(1 << 8),
	/** Callback on character inputs to replace or discard them. Modify 'EventChar' to replace or discard, or return 1 in callback to discard. */
	ImGuiInputTextFlags_CallbackCharFilter(1 << 9),
	/** Pressing TAB input a '\t' character into the text field */
	ImGuiInputTextFlags_AllowTabInput(1 << 10),
	/** In multi-line mode, unfocus with Enter, add new line with Ctrl+Enter (default is opposite: unfocus with Ctrl+Enter, add line with Enter). */
	ImGuiInputTextFlags_CtrlEnterForNewLine(1 << 11),
	/** Disable following the cursor horizontally */
	ImGuiInputTextFlags_NoHorizontalScroll(1 << 12),
	/** Insert mode */
	ImGuiInputTextFlags_AlwaysInsertMode(1 << 13),
	/** Read-only mode */
	ImGuiInputTextFlags_ReadOnly(1 << 14),
	/** Password mode, display all characters as '*' */
	ImGuiInputTextFlags_Password(1 << 15),
	/** Disable undo/redo. Note that input text owns the text data while active, if you want to provide your own undo/redo stack you need e.g. to call ClearActiveID(). */
	ImGuiInputTextFlags_NoUndoRedo(1 << 16),
	/** Allow 0123456789.+-*\\/eE (Scientific notation input) */
	ImGuiInputTextFlags_CharsScientific(1 << 17),
	/** Callback on buffer capacity changes request (beyond 'buf_size' parameter value), allowing the string to grow. Notify when the string wants to be resized (for string types which hold a cache of their Size). You will be provided a new BufSize in the callback and NEED to honor it. (see misc/cpp/imgui_stdlib.h for an example of using this) */
	ImGuiInputTextFlags_CallbackResize(1 << 18);

	public long [] data = new long[1];

	private ImGuiInputTextFlags_(int code) {
		data[0] = code;
	}

	public long getValue() {
		return data[0];
	}
}
