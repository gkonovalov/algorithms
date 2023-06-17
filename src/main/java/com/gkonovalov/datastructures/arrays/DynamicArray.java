package com.gkonovalov.datastructures.arrays;


/**
 * Created by Georgiy Konovalov on 8/06/2023.
 * <p>
 * Dynamic Array implementation, also known as a resizable array or ArrayList, is a
 * data structure that allows for the efficient storage and retrieval of elements. It provides
 * the ability to dynamically resize its capacity as elements are added or removed.
 * </p>
 * Runtime Complexity: O(1) for {@code set}, {@code get}, {@code size}, {@code isEmpty},
 *                     O(1) amortized for {@code add}, {@code remove},
 *                     O(n) worst case for {@code add}, {@code contains}, {@code remove}.
 * Space Complexity:   O(n).
 */
public class DynamicArray<T> {

    private static final int DEFAULT_SIZE = 8;

    private Object[] arr;
    private int n;

    public DynamicArray() {
        arr = new Object[DEFAULT_SIZE];
    }

    public DynamicArray(int size) {
        arr = new Object[size];
    }

    public void add(T item) {
        expandArray();
        arr[n++] = item;
    }

    public T get(int position) {
        if (!isValid(position)) {
            throw new IndexOutOfBoundsException();
        }

        return (T) arr[position];
    }

    public boolean remove(int position) {
        if (!isValid(position)) {
            throw new IndexOutOfBoundsException("Invalid position!");
        }

        n--;
        arr[position] = null;

        shiftArray(position);
        shrinkArray();

        return true;
    }

    public boolean contains(T value) {
        for (Object item : arr) {
            if (item.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return n;
    }

    private boolean isValid(int position) {
        return position < n && position >= 0;
    }

    private void shiftArray(int position) {
        for (int i = position; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }

    private void expandArray() {
        if (n >= arr.length - 1) {
            resizeArray(arr.length * 2);
        }
    }

    private void shrinkArray() {
        if (n >= 0 && n == arr.length / 4) {
            resizeArray(arr.length / 2);
        }
    }

    private void resizeArray(int size) {
        Object[] newArr = new Object[size];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;
    }
}
