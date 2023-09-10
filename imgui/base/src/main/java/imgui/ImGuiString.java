package imgui;

import idl.helper.ByteArray;

public class ImGuiString extends ByteArray {
    public static ImGuiString TMP = new ImGuiString();

    boolean isDirty = false;

    private String text;

    int size;

    public ImGuiString() {
        this(10);
    }

    public ImGuiString(int bufferSize) {
        super(bufferSize);
    }

    public ImGuiString(String text) {
        this(text.length());
        setValue(text);
    }

    public void resizeBuffer(int newBufferSize) {
        resize(newBufferSize);
        isDirty = true;
    }

    public void setValue(CharSequence value) {
        size = value.length();
        int sizeEndLine = size+1;
        int dataSize = getSize();

        if(sizeEndLine > dataSize) {
            resize(sizeEndLine);
        }
        else {
            //setting value 0 to a bigger buffer makes imgui ignore junk characters
            byte val = 0;
            setValue(size, val);
        }
        for(int i = 0; i < size; i++) {
            char c = value.charAt(i);
            setValue(i, (byte)c);
        }
        isDirty = true;
    }

    public String getValue() {
        if(isDirty) {
            isDirty = false;
            byte[] charData = new byte[size];
            ByteArray.arraycopy(this, 0, charData, 0, size);
            text = new String(charData, 0, size);
        }
        return text;
    }

    public int getBufferSize() {
        return super.getSize();
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return getValue();
    }
}
