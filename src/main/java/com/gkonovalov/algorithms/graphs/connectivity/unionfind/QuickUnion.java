package com.gkonovalov.algorithms.graphs.connectivity.unionfind;

/**
 * Created by Georgiy Konovalov on 11/05/2023.
 * <p>
 * Quick-Union implementation. This algorithm is not very efficient.
 * 'find' operation can be pretty slow, especially for situation where
 * will have very skinny tree.
 * </p>
 * Runtime Complexity: O(n) for {@code QuickUnion}, {@code union}
 *                     O(n) for {@code find}, {@code isConnected},
 *                              {@code componentsCount}
 * Space Complexity: O(n)
 */
public class QuickUnion {

    private int[] id;

    public QuickUnion(int size) {
        this.id = new int[size];

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

        id[root(a)] = root(b);
    }

    private boolean isValid(int p) {
        return p >= 0 && p < id.length;
    }
}
