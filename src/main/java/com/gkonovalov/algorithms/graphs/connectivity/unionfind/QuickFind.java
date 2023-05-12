package com.gkonovalov.algorithms.graphs.connectivity.unionfind;

/**
 * Created by Georgiy Konovalov on 11/05/2023.
 * <p>
 * Quick-Find implementation. This algorithm have very efficient 'find' operation, but
 * 'union' operation can be slow, ex. if you have N 'union' operations for N objects,
 * it will take N^2 time to execute.
 * </p>
 * Runtime Complexity: O(n) for {@code QuickFind}, {@code union}
 *                     O(1) for {@code find}, {@code isConnected},
 *                              {@code componentsCount}
 * Space Complexity: O(n)
 */
public class QuickFind {

    private int[] id;
    private int components;

    public QuickFind(int size) {
        this.id = new int[size];
        this.components = size;

        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
    }

    public boolean isConnected(int a, int b) {
        if (isValid(a) && isValid(b)) {
            return id[a] == id[b];
        } else {
            return false;
        }
    }

    public void union(int a, int b) {
        if (!isValid(a) || !isValid(b)) {
            return;
        }

        components--;

        int valA = id[a];
        int valB = id[b];

        for (int i = 0; i < id.length; i++) {
            if (id[i] == valA) {
                id[i] = valB;
            }
        }
    }

    public int find(int p) {
        if (!isValid(p)) {
            return -1;
        }
        return id[p];
    }

    public int count() {
        return id.length;
    }

    public int componentsCount() {
        return components;
    }

    private boolean isValid(int p) {
        return p >= 0 && p < id.length;
    }
}
