package com.gkonovalov.problems.linkedlist.cache;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by Georgiy Konovalov on 12/06/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/lru-cache/">
 *         [Medium][146] - LRU Cache
 *      </a>
 * </p>
 * Runtime Complexity: O(1) for {@code put} and {@code get}.
 * Space Complexity:   O(n) for {@code LRUCacheHashMap} where n = capacity.
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCacheDLL cache = new LRUCacheDLL(2);
        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

    static class LRUCacheDLL {

        private HashMap<Integer, Node> map;
        private Node head;
        private Node tail;

        private int size;

        public LRUCacheDLL(int capacity) {
            this.map = new HashMap<>();
            this.size = capacity;

            this.head = new Node();
            this.tail = new Node();

            this.head.next = tail;
            this.tail.prev = head;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node != null) {
                update(node);
                return node.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            Node node = map.get(key);

            if (node != null) {
                node.val = value;
                update(node);
            } else {
                if (map.size() >= size) {
                    Node last = tail.prev;
                    map.remove(last.key);
                    remove(last);
                }

                Node newNode = new Node(key, value);
                map.put(key, newNode);
                addHead(newNode);
            }
        }

        private void update(Node node) {
            remove(node);
            addHead(node);
        }

        private void remove(Node node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }

        private void addHead(Node node) {
            head.next.prev = node;
            node.next = head.next;
            head.next = node;
            node.prev = head;
        }

        class Node {
            public int key;
            public int val;

            public Node next;
            public Node prev;

            public Node() {
                this.key = -1;
                this.val = -1;
            }

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }


    static class LRUCacheHashMap {

        private int size;
        private LinkedHashMap<Integer, Integer> cache;

        public LRUCacheHashMap(int capacity) {
            this.size = capacity;
            this.cache = new LinkedHashMap<>();
        }

        public int get(int key) {
            Integer val = cache.get(key);

            if (val != null) {
                update(key, val);
                return val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (!cache.containsKey(key) && cache.size() >= size) {
                cache.remove(cache.keySet().iterator().next());
            }
            update(key, value);
        }

        private void update(int key, int value) {
            if (cache.containsKey(key)) {
                cache.remove(key);
            }
            cache.put(key, value);
        }
    }
}
