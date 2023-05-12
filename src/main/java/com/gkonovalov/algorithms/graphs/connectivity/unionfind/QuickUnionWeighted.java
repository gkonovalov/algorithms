package com.gkonovalov.algorithms.graphs.connectivity.unionfind;

/**
 * Created by Georgiy Konovalov on 12/05/2023.
 * <p>
 * Weighted Quick-Union implementation. This algorithm have pretty efficient
 * 'union' and 'root' operations.
 * </p>
 * Runtime Complexity: O(log n) for {@code union}, {@code isConnected}, {@code root}
 *                     O(n) for {@code QuickUnionWeighted}
 *                     O(1) {@code componentsCount}
 * Space Complexity: O(n)
 */
public class QuickUnionWeighted {

    private int[] id;
    private int[] sz;
    private int components;

    public QuickUnionWeighted(int size) {
        this.id = new int[size];
        this.sz = new int[size];
        this.components = size;

        for (int i = 0; i < size; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int findLargerElement(int index) {
        if (!isValid(index)) {
            return -1;
        }

        int biggest = 0;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == id[index]) {
                biggest = i;
            }
        }
        return biggest;
    }

    public boolean isConnected(int a, int b) {
        if (!isValid(a) && !isValid(b)) {
            return false;
        }
        return root(a) == root(b);
    }

    public void union(int a, int b) {
        if (!isValid(a) && !isValid(b)) {
            return;
        }

        int i = root(a);
        int j = root(b);

        if (i == j) {
            return;
        }

        components--;

        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }

    public int componentsCount() {
        return components;
    }

    public int count() {
        return id.length;
    }

    private int root(int index) {
        while (id[index] != index) {
            index = id[index];
        }
        return index;
    }

    private boolean isValid(int p) {
        return p >= 0 && p < id.length;
    }
}
