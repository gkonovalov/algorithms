package com.gkonovalov.datastructures.hashtables;

/**
 * Created by Georgiy Konovalov on 16/06/2023.
 * <p>
 * HashMap data structure implementation, also known as a Hashtable.
 * This data structure provides efficient storage and retrieval of key-value pairs.
 * Current implementation support Separate Chaining collision resolution strategy.
 * <p>
 * The core idea behind a Hashtable is to use a hash function to compute an index,
 * or a hash code, for each key. This hash code is used to determine the storage location,
 * or bucket, where the corresponding value will be stored. The number of buckets determines
 * the size and capacity of the hash table. Ideally, the number of buckets should be larger
 * than the expected number of elements to reduce collisions. The hash function is used to
 * compute the index in the array where an element should be inserted. When two different keys
 * produce the same hash code, the Hashtable needs to resolve this collision by storing multiple
 * values at the same index. This is typically done using a technique called Separate Chaining,
 * where a Linked Lists or another data structure is used to store the collided values. During lookup,
 * the Hashtable uses the hash function to calculate the index and then traverses the Linked List at
 * that index to find the desired element. Hashtable provides constant-time average case complexity for
 * insertion, deletion, and retrieval operations. The elements in a Hashtable are not stored in any
 * particular order. One of the advantages of Hashtable is their ability to handle a wide range of
 * key types, not just integers. They can be used with strings, objects, or custom types, as long as an
 * appropriate hash function is defined.
 * </p>
 * Runtime Complexity: O(1) for {@code put}, {@code get}, {@code remove},
 * {@code contains}, {@code isEmpty}, {@code size},
 * O(n) for {@code containsValue}, {@code keys} and {@code values}.
 * Space Complexity:   O(n).
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

    public double dot(double[] that) {
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
}
