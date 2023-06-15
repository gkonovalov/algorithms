package com.gkonovalov.datastructures.hashtables;


class HashTable<Key, Value> {

    private int capacity = 1000;
    private Node<Key, Value>[] data;

    private int size = 0;

    public HashTable() {
        this.data = new Node[capacity];
    }

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.data = new Node[capacity];
    }

    public void put(Key key, Value val) {
        int hash = getHash(key);
        for (Node<Key, Value> node = data[hash]; node != null; node = node.next) {
            if (node.key.equals(key)) {
                node.val = val;
                return;
            }
        }

        Node<Key, Value> newNode = new Node<>(key, val);
        newNode.next = data[hash];
        data[hash] = newNode;
        size++;
    }

    public Value get(Key key) {
        int hash = getHash(key);
        for (Node<Key, Value> node = data[hash]; node != null; node = node.next) {
            if (node.key.equals(key)) {
                return node.val;
            }
        }
        return null;
    }

    public boolean remove(Key key) {
        int hash = getHash(key);

        for (Node<Key, Value> node = data[hash]; node != null; node = node.next) {
            if (node.next != null && node.next.key.equals(key)) {
                node.next = node.next.next;
                size--;
                return true;
            }
        }

        Node<Key, Value> firstNode = data[hash];
        if (firstNode != null && firstNode.key.equals(key)) {
            data[hash] = firstNode.next;
            size--;
            return true;
        } else {
            return false;
        }
    }

    public boolean containsKey(Key key) {
        int hash = getHash(key);

        for (Node<Key, Value> node = data[hash]; node != null; node = node.next) {
            if (node.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Value val) {
        for (Node item : data) {
            for (Node<Key, Value> node = item; node != null; node = node.next) {
                if (node.val.equals(val)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getHash(Key element) {
        return (element.hashCode() & 0x7fffffff) % capacity;
    }

    private class Node<Key, Value> {

        private Key key;
        private Value val;

        private Node<Key, Value> next;

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }
}
