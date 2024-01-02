package com.gkonovalov.algorithms.bits;

/**
 * Created by Georgiy Konovalov on 1/2/2024.
 * <p>
 * The Bits Operations class provides examples of bitwise operations in Java, including logical AND, OR, XOR,
 * bitwise NOT, left shift, right shift, right zero-fill shift, and various bit manipulation techniques.
 * Bitwise operations are performed on binary representations of integers and can be used for efficient
 * manipulation of individual bits within an integer.
 * Java primitive data types:
 *  boolean  - 1 bit
 *  byte     - 1 byte  - 8 bits
 *  char     - 2 bytes - 16 bits
 *  short    - 2 bytes - 16 bits
 *  int      - 4 bytes - 32 bits
 *  float    - 4 bytes - 32 bits
 *  long     - 8 bytes - 64 bits
 *  double   - 8 bytes - 64 bits
 *
 * Binary representation:
 *  0000 - 0
 *  0001 - 1
 *  0010 - 2
 *  0011 - 3
 *  0100 - 4
 *  0101 - 5
 *  0110 - 6
 *  0111 - 7
 *  1000 - 8
 *  1001 - 9
 * </p>
 */
public class BitsOperations {

    private void logicAnd() {
        System.out.println("0 & 0" + " = " + (0 & 0));
        System.out.println("0 & 1" + " = " + (0 & 1));
        System.out.println("1 & 0" + " = " + (1 & 0));
        System.out.println("1 & 1" + " = " + (1 & 1));
        System.out.println();
    }

    private void logicOr() {
        System.out.println("0 | 0" + " = " + (0 | 0));
        System.out.println("0 | 1" + " = " + (0 | 1));
        System.out.println("1 | 0" + " = " + (1 | 0));
        System.out.println("1 | 1" + " = " + (1 | 1));
        System.out.println();
    }

    private void logicXor() {
        System.out.println("0 ^ 0" + " = " + (0 ^ 0));
        System.out.println("0 ^ 1" + " = " + (0 ^ 1));
        System.out.println("1 ^ 0" + " = " + (1 ^ 0));
        System.out.println("1 ^ 1" + " = " + (1 ^ 1));
        System.out.println(0^2);
    }

    private void logicNot() {
        System.out.println("~7" + " -> " + (~7) + ", " + Integer.toBinaryString(7) + "->" + Integer.toString(~7));
        System.out.println("~5" + " -> " + (~5) + ", " + Integer.toBinaryString(5) + "->" + Integer.toString(~5));
        System.out.println();
    }

    private void leftShift() {
        System.out.println("Left shift <<");
        System.out.println((2) + " " + Integer.toBinaryString(2));
        System.out.println((2 << 1) + " " + Integer.toBinaryString(2 << 1));
        System.out.println((2 << 2) + " " + Integer.toBinaryString(2 << 2));
        System.out.println((2 << 3) + " " + Integer.toBinaryString(2 << 3));
        System.out.println();
        System.out.println((3) + " " + Integer.toBinaryString(3));
        System.out.println((3 << 1) + " " + Integer.toBinaryString(3 << 1));
        System.out.println((3 << 2) + " " + Integer.toBinaryString(3 << 2));
        System.out.println((3 << 3) + " " + Integer.toBinaryString(3 << 3));
        System.out.println();
    }

    private void rightShift() {
        System.out.println("Right shift >>");
        System.out.println((100) + " " + Integer.toBinaryString(100));
        System.out.println((100 >> 1) + " " + Integer.toBinaryString(100 >> 1));
        System.out.println((100 >> 2) + " " + Integer.toBinaryString(100 >> 2));
        System.out.println((100 >> 3) + " " + Integer.toBinaryString(100 >> 3));
        System.out.println();
        System.out.println((1000) + " " + Integer.toBinaryString(1000));
        System.out.println((1000 >> 1) + " " + Integer.toBinaryString(1000 >> 1));
        System.out.println((1000 >> 2) + " " + Integer.toBinaryString(1000 >> 2));
        System.out.println((1000 >> 3) + " " + Integer.toBinaryString(1000 >> 3));
        System.out.println();
    }

    private void rightShiftZeroFill() {
        System.out.println("Right zero fill shift >>>");
        System.out.println((100) + " " + Integer.toBinaryString(100));
        System.out.println((100 >>> 1) + " " + Integer.toBinaryString(100 >>> 1));
        System.out.println((100 >>> 2) + " " + Integer.toBinaryString(100 >>> 2));
        System.out.println((100 >>> 3) + " " + Integer.toBinaryString(100 >>> 3));
        System.out.println();
        System.out.println((1000) + " " + Integer.toBinaryString(1000));
        System.out.println((1000 >>> 1) + " " + Integer.toBinaryString(1000 >>> 1));
        System.out.println((1000 >>> 2) + " " + Integer.toBinaryString(1000 >>> 2));
        System.out.println((1000 >>> 3) + " " + Integer.toBinaryString(1000 >>> 3));
        System.out.println();
    }

    private void masksGetBit() {
        System.out.println();
        System.out.println("Get bit at position 1: " +
                (Integer.toBinaryString(7)) + " -> " +
                (Integer.toBinaryString(7 & (1 << 1))));
    }

    private void masksSetBit() {
        System.out.println();
        System.out.println("Set bit to 1 at position 1: " +
                (Integer.toBinaryString(5)) + " -> " +
                (Integer.toBinaryString(5 | (1 << 1))));
    }

    private void masksClearBit() {
        System.out.println();
        System.out.println("Set bit to 0 at position 1: " +
                (Integer.toBinaryString(7)) + " -> " +
                (Integer.toBinaryString(7 & ~(1 << 1))));
    }

    private void masksUpdateBit(boolean isBitOne) {
        System.out.println();
        int value = isBitOne ? 1 : 0;
        System.out.println("Update bit to " + value + " at position 1: " +
                (Integer.toBinaryString(7)) + " -> " +
                (Integer.toBinaryString(7 & ~(value << 1))));
    }

    private void masksInvertBit() {
        System.out.println();
        System.out.println("Invert bit at position 0: " +
                (Integer.toBinaryString(1)) + " -> " +
                (Integer.toBinaryString(1 ^ (1 << 0))));
    }

    private void masksChangeMinusSignToPlus() {
        System.out.println();
        System.out.println("Change minus to plus: " + (Integer.toBinaryString(-5)) + " -> " + (Integer.toBinaryString(((~-5) | (1)))));
        System.out.println("Mask with all bits set to 1: " + Integer.toBinaryString(0xFFFFFFFF));
        System.out.println("Set only first bit of Integer to 1: " + Integer.toBinaryString(1 << 31));
        System.out.println("Integer 5: " + Integer.toBinaryString(5));
        System.out.println("Integer -5: " + Integer.toBinaryString(-5));
        System.out.println("Not -5: " + Integer.toBinaryString(~-5));

        System.out.println("Apply mask and then set first bit to 1: " + ((-5 ^ 0xffffffff) | (1 << 0)));
        System.out.println("Apply mask and then set first bit to 1: " + ((~-5) | 1));
        System.out.println("Not -5: " + Integer.toBinaryString(~-5 | 1));
        System.out.println("Not -20 plus 1: " + ((~-20) + 1));
        System.out.println("5 to -5: " + ((~5) + 1));
    }

    public static void main(String[] args) {
        BitsOperations bits = new BitsOperations();

        bits.logicAnd();
        bits.logicOr();
        bits.logicXor();
        bits.logicNot();
        bits.leftShift();
        bits.rightShift();
        bits.rightShiftZeroFill();
        bits.masksGetBit();
        bits.masksSetBit();
        bits.masksClearBit();
        bits.masksInvertBit();
        bits.masksChangeMinusSignToPlus();
    }
}
