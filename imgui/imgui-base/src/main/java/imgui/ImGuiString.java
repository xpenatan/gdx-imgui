package imgui;

import idl.helper.IDLByteArray;

public class ImGuiString extends IDLByteArray {

    public final static ImGuiString NULL = createInstance();
    public static ImGuiString TMP_1 = new ImGuiString();

    private static byte[] tempBytes = new byte[1000];

    public static ImGuiString createInstance() {
        return new ImGuiString((byte) 0, (char) 0);
    }

    private ImGuiString(byte v, char c) {
        super(v, c);
    }

    public ImGuiString() {
        this(256);
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
    }

    public void setValue(CharSequence value) {
        int size = value.length();
        int sizeEndLine = size + 1;
        int dataSize = getSize();
        if(sizeEndLine > dataSize) {
            resize(sizeEndLine);
        }
        else {
            // setting value 0 to a bigger buffer makes imgui ignore junk characters
            byte val = 0;
            setValue(size, val);
        }
        for(int i = 0; i < size; i++) {
            char c = value.charAt(i);
            setValue(i, (byte)c);
        }
    }

    public String getValue() {
        int bufferSize = getSize();
        int size = 0;
        for(int i = 0; i < bufferSize; i++) {
            byte value = getValue(i);
            if(value == 0 || value == 3) {
                // 3 = End of text
                size = i;
                break;
            }
            tempBytes[i] = value;
        }
        return new String(tempBytes, 0, size);
    }

    @Override
    public String toString() {
        return getValue();
    }
}
