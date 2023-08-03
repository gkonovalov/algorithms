package com.gkonovalov.datastructures.strings;

/**
 * Created by Georgiy Konovalov on 3/08/2023.
 * <p>
 * String implementation. String is a sequence of characters. It is a data type used to represent text or
 * a sequence of symbols, numbers, or other characters. Strings are commonly used to store and manipulate
 * textual data in programming languages.
 * </p>
 * Runtime Complexity: O(1) for {@code length}, {@code charAt},
 *                     O(n) for {@code concat}, {@code substring}.
 * Space Complexity:   O(n).
 */
public class String {

    private char[] data;

    public String() {
        this.data = new char[0];
    }

    public String(char[] data) {
        this.data = data.clone();
    }

    public String(String str) {
        this.data = str.toCharArray();
    }

    public int length() {
        return data.length;
    }

    public char charAt(int index) {
        if (index < 0 || index >= data.length) {
            throw new IndexOutOfBoundsException("Invalid index!");
        }
        return data[index];
    }

    public String substring(int beginIndex, int endIndex) {
        if (beginIndex < 0 || endIndex > data.length || beginIndex > endIndex) {
            throw new IndexOutOfBoundsException("Invalid index!");
        }

        char[] substringData = new char[endIndex - beginIndex];
        System.arraycopy(data, beginIndex, substringData, 0, endIndex - beginIndex);
        return new String(substringData);
    }

    public String concat(String str) {
        char[] newData = new char[data.length + str.length()];
        System.arraycopy(data, 0, newData, 0, data.length);
        System.arraycopy(str.data, 0, newData, data.length, str.length());
        return new String(newData);
    }

    public char[] toCharArray(){
        return data.clone();
    }
}