package com.gkonovalov.datastructures.arrays;

/**
 * Created by Georgiy Konovalov on 17/05/2023.
 * <p>
 * Array is a data structure used to store a fixed-size sequence of elements
 * of the same type. It is a container that allows efficient access to individual
 * elements based on their index.
 * </p>
 * Runtime Complexity: O(1) for {@code getElement}, {@code getLength}.
 * Space Complexity:   O(n).
 */
public class Array {

    private final int[] array;

    public Array(int size) {
        this.array = new int[size];
    }

    public int getElement(int index) {
        return array[index];
    }

    public int getLength() {
        return array.length;
    }

}
