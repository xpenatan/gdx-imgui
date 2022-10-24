package com.github.xpenatan.imgui.enums;

public class ImGuiTableFlags {
    private static ImGuiTableFlags Custom = new ImGuiTableFlags(0);

    // Features
    public static ImGuiTableFlags None = new ImGuiTableFlags(0);
    public static ImGuiTableFlags Resizable = new ImGuiTableFlags(1 << 0);
    public static ImGuiTableFlags Reorderable = new ImGuiTableFlags(1 << 1);
    public static ImGuiTableFlags Hideable = new ImGuiTableFlags(1 << 2);
    public static ImGuiTableFlags Sortable = new ImGuiTableFlags(1 << 3);
    public static ImGuiTableFlags NoSavedSettings = new ImGuiTableFlags(1 << 4);
    public static ImGuiTableFlags ContextMenuInBody = new ImGuiTableFlags(1 << 5);

    // Decoration
    public static ImGuiTableFlags RowBg = new ImGuiTableFlags(1 << 6);
    public static ImGuiTableFlags BordersInnerH = new ImGuiTableFlags(1 << 7);
    public static ImGuiTableFlags BordersOuterH = new ImGuiTableFlags(1 << 8);
    public static ImGuiTableFlags BordersInnerV = new ImGuiTableFlags(1 << 9);
    public static ImGuiTableFlags BordersOuterV = new ImGuiTableFlags(1 << 10);
    public static ImGuiTableFlags BordersH = new ImGuiTableFlags(BordersInnerH.getValue() | BordersOuterH.getValue());
    public static ImGuiTableFlags BordersV = new ImGuiTableFlags(BordersInnerV.getValue() | BordersOuterV.getValue());
    public static ImGuiTableFlags BordersInner = new ImGuiTableFlags(BordersInnerV.getValue() | BordersInnerH.getValue());
    public static ImGuiTableFlags BordersOuter = new ImGuiTableFlags(BordersOuterV.getValue() | BordersOuterH.getValue());
    public static ImGuiTableFlags Borders = new ImGuiTableFlags(BordersInner.getValue() | BordersOuter.getValue());
    public static ImGuiTableFlags NoBordersInBod = new ImGuiTableFlags(1 << 11);
    public static ImGuiTableFlags NoBordersInBodyUntilResize = new ImGuiTableFlags(1 << 12);

    // Sizing Policy
    public static ImGuiTableFlags SizingFixedFit = new ImGuiTableFlags(1 << 13);
    public static ImGuiTableFlags SizingFixedSame = new ImGuiTableFlags(2 << 13);
    public static ImGuiTableFlags SizingStretchProp = new ImGuiTableFlags(3 << 13);
    public static ImGuiTableFlags SizingStretchSame = new ImGuiTableFlags(4 << 13);

    // Sizing Extra Options
    public static ImGuiTableFlags NoHostExtendX = new ImGuiTableFlags(1 << 16);
    public static ImGuiTableFlags NoHostExtendY = new ImGuiTableFlags(1 << 17);
    public static ImGuiTableFlags NoKeepColumnsVisible = new ImGuiTableFlags(1 << 18);
    public static ImGuiTableFlags PreciseWidths = new ImGuiTableFlags(1 << 19);

    // Clipping
    public static ImGuiTableFlags NoClip = new ImGuiTableFlags(1 << 20);

    // Padding
    public static ImGuiTableFlags PadOuterX = new ImGuiTableFlags(1 << 21);
    public static ImGuiTableFlags NoPadOuterX = new ImGuiTableFlags(1 << 22);
    public static ImGuiTableFlags NoPadInnerX = new ImGuiTableFlags(1 << 23);

    // Scrolling
    public static ImGuiTableFlags ScrollX = new ImGuiTableFlags(1 << 24);
    public static ImGuiTableFlags ScrollY = new ImGuiTableFlags(1 << 25);
    // Sorting
    public static ImGuiTableFlags SortMulti = new ImGuiTableFlags(1 << 26);
    public static ImGuiTableFlags SortTristate = new ImGuiTableFlags(1 << 27);

    int value;

    private ImGuiTableFlags(int code) {
        value = code;
    }

    public ImGuiTableFlags or(ImGuiTableFlags otherEnum) {
        ImGuiTableFlags.Custom.value = value | otherEnum.value;
        return ImGuiTableFlags.Custom;
    }

    public int getValue() {
        return value;
    }
}
