package com.gkonovalov.algorithms.graphs.connectivity.unionfind.quickunion;

/**
 * Created by Georgiy Konovalov on 12/05/2023.
 * <p>
 * Weighted Quick-Union with path compression implementation.
 * The overall runtime complexity is considered to be nearly linear or O(m lg* n).
 * In practice, this is considered to be very close to O(n) and very efficient solution
 * for dynamic connectivity problems.
 * </p>
 * Runtime Complexity: O(m lg* n)) ~= O(n),
 *                     O(lg* n) for {@code union}, {@code isConnected}, {@code root},
 *                     O(n) for {@code QuickUnionWeighted},
 *                     O(1) {@code componentsCount}.
 * Space Complexity:   O(n).
 */
public class QuickUnionWeightedPathCompression {

    private int[] id;
    private int[] sz;
    private int components;

    public QuickUnionWeightedPathCompression(int size) {
        this.id = new int[size];
        this.sz = new int[size];
        this.components = size;

        for (int i = 0; i < size; i++) {
            id[i] = i;
            sz[i] = 1;
        }
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
            id[index] = id[id[index]]; // path compression
            index = id[index];
        }
        return index;
    }

    private boolean isValid(int p) {
        return p >= 0 && p < id.length;
    }
}
