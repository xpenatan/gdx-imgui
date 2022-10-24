package com.github.xpenatan.imgui.enums;

public class ImGuiTableColumnFlags {
    private static ImGuiTableColumnFlags Custom = new ImGuiTableColumnFlags(0);

    // Input configuration flags
    public static ImGuiTableColumnFlags None = new ImGuiTableColumnFlags(0);
    public static ImGuiTableColumnFlags Disabled = new ImGuiTableColumnFlags(1 << 0);   // Overriding/master disable flag: hide column, won't show in context menu (unlike calling TableSetColumnEnabled() which manipulates the user accessible state)
    public static ImGuiTableColumnFlags DefaultHide = new ImGuiTableColumnFlags(1 << 1);   // Default as a hidden/disabled column.
    public static ImGuiTableColumnFlags DefaultSort = new ImGuiTableColumnFlags(1 << 2);   // Default as a sorting column.
    public static ImGuiTableColumnFlags WidthStretch = new ImGuiTableColumnFlags(1 << 3);   // Column will stretch. Preferable with horizontal scrolling disabled (default if table sizing policy is _SizingStretchSame or _SizingStretchProp).
    public static ImGuiTableColumnFlags WidthFixed = new ImGuiTableColumnFlags(1 << 4);   // Column will not stretch. Preferable with horizontal scrolling enabled (default if table sizing policy is _SizingFixedFit and table is resizable).
    public static ImGuiTableColumnFlags NoResize = new ImGuiTableColumnFlags(1 << 5);   // Disable manual resizing.
    public static ImGuiTableColumnFlags NoReorder = new ImGuiTableColumnFlags(1 << 6);   // Disable manual reordering this column, this will also prevent other columns from crossing over this column.
    public static ImGuiTableColumnFlags NoHide = new ImGuiTableColumnFlags(1 << 7);   // Disable ability to hide/disable this column.
    public static ImGuiTableColumnFlags NoClip = new ImGuiTableColumnFlags(1 << 8);   // Disable clipping for this column (all NoClip columns will render in a same draw command).
    public static ImGuiTableColumnFlags NoSort = new ImGuiTableColumnFlags(1 << 9);   // Disable ability to sort on this field (even if ImGuiTableFlags_Sortable is set on the table).
    public static ImGuiTableColumnFlags NoSortAscending = new ImGuiTableColumnFlags(1 << 10);  // Disable ability to sort in the ascending direction.
    public static ImGuiTableColumnFlags NoSortDescending = new ImGuiTableColumnFlags(1 << 11);  // Disable ability to sort in the descending direction.
    public static ImGuiTableColumnFlags NoHeaderLabel = new ImGuiTableColumnFlags(1 << 12);  // TableHeadersRow() will not submit label for this column. Convenient for some small columns. Name will still appear in context menu.
    public static ImGuiTableColumnFlags NoHeaderWidth = new ImGuiTableColumnFlags(1 << 13);  // Disable header text width contribution to automatic column width.
    public static ImGuiTableColumnFlags PreferSortAscending = new ImGuiTableColumnFlags(1 << 14);  // Make the initial sort direction Ascending when first sorting on this column (default).
    public static ImGuiTableColumnFlags PreferSortDescending = new ImGuiTableColumnFlags(1 << 15);  // Make the initial sort direction Descending when first sorting on this column.
    public static ImGuiTableColumnFlags IndentEnable = new ImGuiTableColumnFlags(1 << 16);  // Use current Indent value when entering cell (default for column 0).
    public static ImGuiTableColumnFlags IndentDisable = new ImGuiTableColumnFlags(1 << 17);  // Ignore current Indent value when entering cell (default for columns > 0). Indentation changes _within_ the cell will still be honored.

    // Output status flags, read-only via TableGetColumnFlags()
    public static ImGuiTableColumnFlags IsEnabled = new ImGuiTableColumnFlags(1 << 24);  // Status: is enabled == not hidden by user/api (referred to as "Hide" in _DefaultHide and _NoHide) flags.
    public static ImGuiTableColumnFlags IsVisible = new ImGuiTableColumnFlags(1 << 25);  // Status: is visible == is enabled AND not clipped by scrolling.
    public static ImGuiTableColumnFlags IsSorted = new ImGuiTableColumnFlags(1 << 26);  // Status: is currently part of the sort specs
    public static ImGuiTableColumnFlags IsHovered = new ImGuiTableColumnFlags(1 << 27);  // Status: is hovered by mouse

    int value;

    private ImGuiTableColumnFlags(int code) {
        value = code;
    }

    public ImGuiTableColumnFlags or(ImGuiTableColumnFlags otherEnum) {
        ImGuiTableColumnFlags.Custom.value = value | otherEnum.value;
        return ImGuiTableColumnFlags.Custom;
    }

    public int getValue() {
        return value;
    }
}
