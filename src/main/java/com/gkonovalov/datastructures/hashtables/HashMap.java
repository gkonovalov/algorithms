package com.gkonovalov.datastructures.hashtables;

import com.gkonovalov.datastructures.etc.MapNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Georgiy Konovalov on 15/06/2023.
 * <p>
 * HashMap data structure implementation, also known as a Hashtable.
 * This data structure provides efficient storage and retrieval of key-value pairs.
 * Current implementation support Separate Chaining collision resolution strategy.
 *
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
 *                              {@code contains}, {@code isEmpty}, {@code size},
 *                     O(n) for {@code containsValue}, {@code keys} and {@code values}.
 * Space Complexity:   O(n).
 */
public class HashMap<K, V> {

    private static final int DEFAULT_SIZE = 8;

    private MapNode<K, V>[] data;

    private int capacity;
    private int size;

    public HashMap() {
        this(DEFAULT_SIZE);
    }

    public HashMap(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.data = new MapNode[capacity];
    }

    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Parameter key can't be null!");
        }

        if (isEmpty()) {
            throw new IllegalStateException("Hash Map is empty!");
        }

        MapNode<K, V> node = data[getHash(key)];

        while (node != null) {
            if (node.key.equals(key)) {
                return node.val;
            }
            node = node.next;
        }

        return null;
    }

    public void put(K key, V val) {
        if (key == null) {
            throw new IllegalArgumentException("Parameter key can't be null!");
        }

        int hash = getHash(key);

        MapNode<K, V> node = data[hash];

        while (node != null) {
            if (node.key.equals(key)) {
                node.val = val;
                return;
            }
            node = node.next;
        }

        data[hash] = new MapNode<>(key, val, data[hash]);
        size++;
    }

    public boolean remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Parameter key can't be null!");
        }

        if (isEmpty()) {
            throw new IllegalStateException("Hash Map is empty!");
        }

        int hash = getHash(key);

        MapNode<K, V> node = data[hash];

        while (node != null) {
            if (node.next != null && node.next.key.equals(key)) {
                node.next = node.next.next;
                size--;

                return true;
            }
            node = node.next;
        }

        node = data[hash];

        if (node != null && node.key.equals(key)) {
            data[hash] = node.next;
            size--;
            return true;
        } else {
            return false;
        }
    }

    public boolean containsKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Parameter key can't be null!");
        }

        if (isEmpty()) {
            throw new IllegalStateException("Hash Map is empty!");
        }

        MapNode<K, V> node = data[getHash(key)];

        while (node != null) {
            if (node.key.equals(key)) {
                return true;
            }
            node = node.next;
        }

        return false;
    }

    public boolean containsValue(V val) {
        if (isEmpty()) {
            throw new IllegalStateException("Hash Map is empty!");
        }

        for (MapNode<K, V> item : data) {
            while (item != null) {
                if (item.val.equals(val)) {
                    return true;
                }
                item = item.next;
            }
        }

        return false;
    }

    public Iterable<K> keys() {
        Queue<K> queue = new ArrayDeque<>();

        for (int i = 0; i < capacity; i++) {
            MapNode<K, V> node = data[i];

            while (node != null) {
                queue.add(node.key);
                node = node.next;
            }
        }

        return queue;
    }


    public Iterable<V> values() {
        Queue<V> queue = new ArrayDeque<>();

        for (int i = 0; i < capacity; i++) {
            MapNode<K, V> node = data[i];

            while (node != null) {
                queue.add(node.val);
                node = node.next;
            }
        }

        return queue;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getHash(K element) {
        return (element.hashCode() & 0x7fffffff) % capacity;
    }
}
