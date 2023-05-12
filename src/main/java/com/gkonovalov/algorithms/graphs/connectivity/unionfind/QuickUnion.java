package com.gkonovalov.algorithms.graphs.connectivity.unionfind;

/**
 * Created by Georgiy Konovalov on 11/05/2023.
 * <p>
 * Quick-Union implementation. This algorithm is not very efficient.
 * 'find' operation can be pretty slow, especially for situation where we have very skinny tree.
 * For m 'union' operations for n objects, it will take O(mn) time to execute.
 * </p>
 * Runtime Complexity: O(mn) - m 'union' operations for n objects;
 *                     O(n) for {@code QuickUnion}, {@code union},
 *                              {@code root}, {@code isConnected};
 *                     O(1) for {@code componentsCount}.
 * Space Complexity: O(n).
 */
public class QuickUnion {

    private int[] id;
    private int components;

    public QuickUnion(int size) {
        this.id = new int[size];
        this.components = size;

        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
    }

    private int root(int index) {
        while (id[index] != index) {
            index = id[index];
        }
        return index;
    }

    public boolean isConnected(int a, int b) {
        if (!isValid(a) || !isValid(b)) {
            return false;
        }

        return root(a) == root(b);
    }

    public void union(int a, int b) {
        if (!isValid(a) || !isValid(b)) {
            return;
        }

        components--;

        id[root(a)] = root(b);
    }

    public int componentsCount() {
        return components;
    }

    private boolean isValid(int p) {
        return p >= 0 && p < id.length;
    }
}
