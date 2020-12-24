package com.github.xpenatan.imgui.util;

public class CharSequenceHelper {

	private static byte[] char01 = new byte[1000];
	private static byte[] char02 = new byte[1000];

	public static byte[] getTempChar(CharSequence charSequence, int index) {
		byte[] charArray = null;
		if(index == 0)
			charArray = getChar(index);
		return getChar(charSequence, charArray);
	}

	public static byte[] getChar(CharSequence charSequence, byte[] charArray) {
		if(charArray == null)
			return null;
		int length = charSequence.length();
		charArray[length+1] = 0;
		for(int i = 0; i < length; i++) {
			charArray[i] = (byte)charSequence.charAt(i);
		}
		return charArray;
	}

	private static byte[] getChar(int index) {
		if(index == 0)
			return char01;
		else if(index == 1)
			return char02;
		return null;
	}
}
