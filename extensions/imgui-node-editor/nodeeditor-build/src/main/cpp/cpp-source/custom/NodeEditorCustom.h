#pragma once

#include <string>
#include "imgui_node_editor.h"

typedef ax::NodeEditor::CanvasSizeMode CanvasSizeMode;
typedef ax::NodeEditor::FlowDirection FlowDirection;
typedef ax::NodeEditor::PinKind PinKind;

namespace n = ax::NodeEditor;

using namespace ax::NodeEditor;

class NodeEditor {

private:

public:

    static void SetCurrentEditor(EditorContext* ctx) { n::SetCurrentEditor(ctx); }
    static EditorContext* GetCurrentEditor() { return n::GetCurrentEditor(); }
    static EditorContext* CreateEditor(const Config* config = nullptr) { return n::CreateEditor(config); }
    static void DestroyEditor(EditorContext* ctx) { n::DestroyEditor(ctx); }
    static const Config& GetConfig(EditorContext* ctx = nullptr) { return n::GetConfig(ctx); }

    static Style& GetStyle() { return n::GetStyle(); }
    static const std::string GetStyleColorName(StyleColor colorIndex) { return n::GetStyleColorName(colorIndex); }

    static void PushStyleColor(StyleColor colorIndex, const ImVec4& color) { n::PushStyleColor(colorIndex, color); }
    static void PopStyleColor(int count = 1) { n::PopStyleColor(count); }

    static void PushStyleVar_1(StyleVar varIndex, float value) { n::PushStyleVar(varIndex, value); }
    static void PushStyleVar_2(StyleVar varIndex, const ImVec2& value) { n::PushStyleVar(varIndex, value); }
    static void PushStyleVar_3(StyleVar varIndex, const ImVec4& value) { n::PushStyleVar(varIndex, value); }
    static void PopStyleVar(int count = 1) { n::PopStyleVar(count); }

    static void Begin(const char* id, const ImVec2& size = ImVec2(0, 0)) { n::Begin(id, size); }
    static void End() { n::End(); }

    static void BeginNode(NodeId id) { n::BeginNode(id); }
    static void BeginPin(PinId id, PinKind kind) { n::BeginPin(id, kind); }
    static void PinRect(const ImVec2& a, const ImVec2& b) { n::PinRect(a, b); }
    static void PinPivotRect(const ImVec2& a, const ImVec2& b) { n::PinPivotRect(a, b); }
    static void PinPivotSize(const ImVec2& size) { n::PinPivotSize(size); }
    static void PinPivotScale(const ImVec2& scale) { n::PinPivotScale(scale); }
    static void PinPivotAlignment(const ImVec2& alignment) { n::PinPivotAlignment(alignment); }
    static void EndPin() { n::EndPin(); }
    static void Group(const ImVec2& size) { n::Group(size); }
    static void EndNode() { n::EndNode(); }

    static bool BeginGroupHint(NodeId nodeId) { return n::BeginGroupHint(nodeId); }
    static ImVec2 GetGroupMin() { return n::GetGroupMin(); }
    static ImVec2 GetGroupMax() { return n::GetGroupMax(); }
    static ImDrawList* GetHintForegroundDrawList() { return n::GetHintForegroundDrawList(); }
    static ImDrawList* GetHintBackgroundDrawList() { return n::GetHintBackgroundDrawList(); }
    static void EndGroupHint() { n::EndGroupHint(); }

    static ImDrawList* GetNodeBackgroundDrawList(NodeId nodeId) { return n::GetNodeBackgroundDrawList(nodeId); }

    static bool Link(LinkId id, PinId startPinId, PinId endPinId, const ImVec4& color = ImVec4(1, 1, 1, 1), float thickness = 1.0f) { return n::Link(id, startPinId, endPinId, color, thickness); }

    static void Flow(LinkId linkId, FlowDirection direction = FlowDirection::Forward) { return n::Flow(linkId, direction); }

    static bool BeginCreate(const ImVec4& color = ImVec4(1, 1, 1, 1), float thickness = 1.0f) { return n::BeginCreate(color, thickness); }
    static bool QueryNewLink(PinId* startId, PinId* endId) { return n::QueryNewLink(startId, endId); }
    static bool QueryNewLink(PinId* startId, PinId* endId, const ImVec4& color, float thickness = 1.0f) { return n::QueryNewLink(startId, endId, color, thickness); }
    static bool QueryNewNode(PinId* pinId) { return n::QueryNewNode(pinId); }
    static bool QueryNewNode(PinId* pinId, const ImVec4& color, float thickness = 1.0f) { return n::QueryNewNode(pinId, color, thickness); }
    static bool AcceptNewItem() { return n::AcceptNewItem(); }
    static bool AcceptNewItem(const ImVec4& color, float thickness = 1.0f) { return n::AcceptNewItem(color, thickness); }
    static void RejectNewItem() { n::RejectNewItem(); }
    static void RejectNewItem(const ImVec4& color, float thickness = 1.0f) { n::RejectNewItem(color, thickness); }
    static void EndCreate() { n::EndCreate(); }

    static bool BeginDelete() { return n::BeginDelete(); }
    static bool QueryDeletedLink(LinkId* linkId, PinId* startId = nullptr, PinId* endId = nullptr) { return n::QueryDeletedLink(linkId, startId, endId); }
    static bool QueryDeletedNode(NodeId* nodeId) { return n::QueryDeletedNode(nodeId); }
    static bool AcceptDeletedItem(bool deleteDependencies = true) { return n::AcceptDeletedItem(deleteDependencies); }
    static void RejectDeletedItem() { n::RejectDeletedItem(); }
    static void EndDelete() { n::EndDelete(); }

    static void SetNodePosition(NodeId nodeId, const ImVec2& editorPosition) { n::SetNodePosition(nodeId, editorPosition); }
    static void SetGroupSize(NodeId nodeId, const ImVec2& size) { n::SetGroupSize(nodeId, size); }
    static ImVec2 GetNodePosition(NodeId nodeId) { return n::GetNodePosition(nodeId); }
    static ImVec2 GetNodeSize(NodeId nodeId) { return n::GetNodeSize(nodeId); }
    static void CenterNodeOnScreen(NodeId nodeId) { n::CenterNodeOnScreen(nodeId); }
    static void SetNodeZPosition(NodeId nodeId, float z) { n::SetNodeZPosition(nodeId, z); }
    static float GetNodeZPosition(NodeId nodeId) { return n::GetNodeZPosition(nodeId); }

    static void RestoreNodeState(NodeId nodeId) { n::RestoreNodeState(nodeId); }

    static void Suspend() { n::Suspend(); }
    static void Resume() { n::Resume(); }
    static bool IsSuspended() { return n::IsSuspended(); }

    static bool IsActive() { return n::IsActive(); }

    static bool HasSelectionChanged() { return n::HasSelectionChanged(); }
    static int  GetSelectedObjectCount() { return n::GetSelectedObjectCount(); }
    static int  GetSelectedNodes(NodeId* nodes, int size) { return n::GetSelectedNodes(nodes, size); }
    static int  GetSelectedLinks(LinkId* links, int size) { return n::GetSelectedLinks(links, size); }
    static bool IsNodeSelected(NodeId nodeId) { return n::IsNodeSelected(nodeId); }
    static bool IsLinkSelected(LinkId linkId) { return n::IsLinkSelected(linkId); }
    static void ClearSelection() { n::ClearSelection(); }
    static void SelectNode(NodeId nodeId, bool append = false) { n::SelectNode(nodeId, append); }
    static void SelectLink(LinkId linkId, bool append = false) { n::SelectLink(linkId, append); }
    static void DeselectNode(NodeId nodeId) { n::DeselectNode(nodeId); }
    static void DeselectLink(LinkId linkId) { n::DeselectLink(linkId); }

    static bool DeleteNode(NodeId nodeId) { return n::DeleteNode(nodeId); }
    static bool DeleteLink(LinkId linkId) { return n::DeleteLink(linkId); }

    static bool HasAnyLinks(NodeId nodeId) { return n::HasAnyLinks(nodeId); }
    static bool HasAnyLinks(PinId pinId) { return n::HasAnyLinks(pinId); }
    static int BreakLinks(NodeId nodeId) { return n::BreakLinks(nodeId); }
    static int BreakLinks(PinId pinId) { return n::BreakLinks(pinId); }

    static void NavigateToContent(float duration = -1) { n::NavigateToContent(duration); }
    static void NavigateToSelection(bool zoomIn = false, float duration = -1) { n::NavigateToSelection(zoomIn, duration); }

    static bool ShowNodeContextMenu(NodeId* nodeId) { return n::ShowNodeContextMenu(nodeId); }
    static bool ShowPinContextMenu(PinId* pinId) { return n::ShowPinContextMenu(pinId); }
    static bool ShowLinkContextMenu(LinkId* linkId) { return n::ShowLinkContextMenu(linkId); }
    static bool ShowBackgroundContextMenu() { return n::ShowBackgroundContextMenu(); }

    static void EnableShortcuts(bool enable) { n::EnableShortcuts(enable); }
    static bool AreShortcutsEnabled() { return n::AreShortcutsEnabled(); }

    static bool BeginShortcut() { return n::BeginShortcut(); }
    static bool AcceptCut() { return n::AcceptCut(); }
    static bool AcceptCopy() { return n::AcceptCopy(); }
    static bool AcceptPaste() { return n::AcceptPaste(); }
    static bool AcceptDuplicate() { return n::AcceptDuplicate(); }
    static bool AcceptCreateNode() { return n::AcceptCreateNode(); }
    static int  GetActionContextSize() { return n::GetActionContextSize(); }
    static int  GetActionContextNodes(NodeId* nodes, int size) { return n::GetActionContextNodes(nodes, size); }
    static int  GetActionContextLinks(LinkId* links, int size) { return n::GetActionContextLinks(links, size); }
    static void EndShortcut() { n::EndShortcut(); }

    static float GetCurrentZoom() { return n::GetCurrentZoom(); }

    static NodeId GetHoveredNode() { return n::GetHoveredNode(); }
    static PinId GetHoveredPin() { return n::GetHoveredPin(); }
    static LinkId GetHoveredLink() { return n::GetHoveredLink(); }
    static NodeId GetDoubleClickedNode() { return n::GetDoubleClickedNode(); }
    static PinId GetDoubleClickedPin() { return n::GetDoubleClickedPin(); }
    static LinkId GetDoubleClickedLink() { return n::GetDoubleClickedLink(); }
    static bool IsBackgroundClicked() { return n::IsBackgroundClicked(); }
    static bool IsBackgroundDoubleClicked() { return n::IsBackgroundDoubleClicked(); }
    static ImGuiMouseButton GetBackgroundClickButtonIndex() { return n::GetBackgroundClickButtonIndex(); }
    static ImGuiMouseButton GetBackgroundDoubleClickButtonIndex() { return n::GetBackgroundDoubleClickButtonIndex(); }

    static bool GetLinkPins(LinkId linkId, PinId* startPinId, PinId* endPinId) { return n::GetLinkPins(linkId, startPinId, endPinId); }

    static bool PinHadAnyLinks(PinId pinId) { return n::PinHadAnyLinks(pinId); }

    static ImVec2 GetScreenSize() { return n::GetScreenSize(); }
    static ImVec2 ScreenToCanvas(const ImVec2& pos) { return n::ScreenToCanvas(pos); }
    static ImVec2 CanvasToScreen(const ImVec2& pos) { return n::CanvasToScreen(pos); }

    static int GetNodeCount() { return n::GetNodeCount(); }
    static int GetOrderedNodeIds(NodeId* nodes, int size) { return n::GetOrderedNodeIds(nodes, size); }
};