package com.gkonovalov.datastructures.hashtables;

/**
 * Created by Georgiy Konovalov on 16/06/2023.
 * <p>
 * Sparse Vector implementation. Sparse vectors are specifically optimized for efficient storage
 * and manipulation of vectors with a large number of elements, where the majority of elements
 * are zero. They achieve this by storing only the non-zero elements along with their corresponding
 * indices, rather than allocating memory for every element in the vector. This approach significantly
 * reduces memory usage and speeds up operations involving sparse vectors.
 * </p>
 * Runtime Complexity: O(1) for {@code get}, {@code put},
 *                     O(m) for {@code dotProduct}.
 * Space Complexity:   O(m).
 */
public class SparseVector {

    private final HashMap<Integer, Double> vector;

    public SparseVector() {
        this.vector = new HashMap<>();
    }

    public double get(Integer key) {
        if (key == null) {
            throw new IllegalArgumentException("Parameter key can't be null!");
        }

        if (vector.isEmpty()) {
            throw new IllegalStateException("Sparse Vector is empty!");
        }

        if (vector.containsKey(key)) {
            return vector.get(key);
        } else {
            return 0.0;
        }
    }

    public void put(Integer key, Double value) {
        if (key == null) {
            throw new IllegalArgumentException("Parameter key can't be null!");
        }

        if (value != 0.0) {
            vector.put(key, value);
        } else {
            vector.remove(key);
        }
    }

    public double dotProduct(double[] that) {
        if (that == null) {
            throw new IllegalArgumentException("Parameter that can't be null!");
        }

        if (vector.isEmpty()) {
            throw new IllegalStateException("Sparse Vector is empty!");
        }

        double sum = 0.0;
        for (int i : indices()) {
            sum += that[i] * this.get(i);
        }
        return sum;
    }

    public Iterable<Integer> indices() {
        return vector.keys();
    }

    public int size(){
        return vector.size();
    }
}
