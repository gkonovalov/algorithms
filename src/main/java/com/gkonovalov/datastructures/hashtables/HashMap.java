package com.gkonovalov.datastructures.hashtables;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Georgiy Konovalov on 15/06/2023.
 * <p>
 * HashMap arr structure implementation, also known as a Hashtable. This arr structure provides
 * efficient storage and retrieval of key-value pairs, it support's Separate Chaining collision
 * resolution strategy and dynamic resizing feature.
 * <p>
 * The core idea behind a Hashtable is to use a hash function to compute an index, or a hash code,
 * for each key. This hash code is used to determine the storage location, or bucket, where the
 * corresponding value will be stored. The number of buckets determines the size and capacity of
 * the hash table. Ideally, the number of buckets should be larger than the expected number of
 * elements to reduce collisions. The hash function is used to compute the index in the array where
 * an element should be inserted. When two different keys produce the same hash code, the Hashtable
 * needs to resolve this collision by storing multiple values at the same index. This is typically done
 * using a technique called Separate Chaining, where a Linked Lists or another arr structure is used to
 * store the collided values. During lookup, the Hashtable uses the hash function to calculate the index
 * and then traverses the Linked List at that index to find the desired element. Hashtable provides
 * constant-time average case complexity for insertion, deletion, and retrieval operations. The elements
 * in a Hashtable are not stored in any particular order. One of the advantages of Hashtable is their
 * ability to handle a wide range of key types, not just integers. They can be used with strings, objects,
 * or custom types, as long as an appropriate hash function is defined.
 * </p>
 * Runtime Complexity: O(1) for {@code put}, {@code get}, {@code remove},
 *                              {@code contains}, {@code isEmpty}, {@code size},
 *                     O(n) for {@code containsValue}, {@code keys} and {@code values}.
 * Space Complexity:   O(n).
 */
public class HashMap<K, V> {

    private static final int DEFAULT_SIZE = 8;

    private MapNode<K, V>[] arr;
    private int size;

    public HashMap() {
        this(DEFAULT_SIZE);
    }

    public HashMap(int capacity) {
        this.size = 0;
        this.arr = new MapNode[capacity];
    }

    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Parameter key can't be null!");
        }

        if (isEmpty()) {
            throw new IllegalStateException("Hash Map is empty!");
        }

        MapNode<K, V> node = arr[getHash(key)];
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

        expandArray();

        int hash = getHash(key);

        MapNode<K, V> node = arr[hash];
        while (node != null) {
            if (node.key.equals(key)) {
                node.val = val;
                return;
            }
            node = node.next;
        }

        arr[hash] = new MapNode<>(key, val, arr[hash]);
        size++;
    }

    public boolean remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Parameter key can't be null!");
        }

        if (isEmpty()) {
            throw new IllegalStateException("Hash Map is empty!");
        }

        shrinkArray();

        int hash = getHash(key);

        MapNode<K, V> node = arr[hash];
        while (node != null && node.next != null) {
            if (node.next.key.equals(key)) {
                node.next = node.next.next;
                size--;
                return true;
            }
            node = node.next;
        }

        MapNode<K, V> firstNode = arr[hash];
        if (firstNode != null && firstNode.key.equals(key)) {
            arr[hash] = firstNode.next;
            size--;
            return true;
        }
        return true;
    }

    public boolean containsKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Parameter key can't be null!");
        }

        if (isEmpty()) {
            throw new IllegalStateException("Hash Map is empty!");
        }

        MapNode<K, V> node = arr[getHash(key)];
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

        for (MapNode<K, V> node : arr) {
            while (node != null) {
                if (node.val.equals(val)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    public Iterable<K> keys() {
        Queue<K> queue = new ArrayDeque<>();

        for (MapNode<K, V> node : arr) {
            while (node != null) {
                queue.add(node.key);
                node = node.next;
            }
        }
        return queue;
    }

    public Iterable<V> values() {
        Queue<V> queue = new ArrayDeque<>();

        for (MapNode<K, V> node : arr) {
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
        return (element.hashCode() & 0x7fffffff) % arr.length;
    }

    private void resize(int capacity) {
        HashMap<K, V> newSet = new HashMap<>(capacity);

        for (MapNode<K, V> node : arr) {
            if (node != null) {
                newSet.put(node.key, node.val);
            }
        }
        arr = newSet.arr;
    }

    private void expandArray() {
        if (size >= arr.length / 2) {
            resize(arr.length * 2);
        }
    }

    private void shrinkArray() {
        if (size >= 0 && size == arr.length / 4) {
            resize(arr.length / 2);
        }
    }
}
