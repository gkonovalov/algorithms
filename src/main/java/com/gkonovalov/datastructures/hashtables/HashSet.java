package com.gkonovalov.datastructures.hashtables;

class HashSet<Key> {
    private Node<Key>[] set;

    private int capacity = 1000;
    private int size = 0;

    public HashSet() {
        this.set = new Node[capacity];
    }

    public HashSet(int capacity) {
        this.capacity = capacity;
        this.set = new Node[capacity];
    }

    public void add(Key data) {
        int hash = getHash(data);

        for (Node<Key> node = set[hash]; node != null; node = node.next) {
            if (node.data.equals(data)) {
                return;
            }
        }

        Node<Key> newNode = new Node<>(data);
        newNode.next = set[hash];
        set[hash] = newNode;
        size++;
    }

    public boolean remove(Key data) {
        int hash = getHash(data);

        for (Node<Key> node = set[hash]; node != null; node = node.next) {
            if (node.next != null && node.next.data.equals(data)) {
                node.next = node.next.next;
                size--;
                return true;
            }
        }

        Node<Key> firstNode = set[hash];
        if (firstNode != null && firstNode.data.equals(data)) {
            set[hash] = firstNode.next;
            size--;
            return true;
        } else {
            return false;
        }
    }

    public boolean contains(Key data) {
        int hash = getHash(data);

        for (Node<Key> node = set[hash]; node != null; node = node.next) {
            if (node.data.equals(data)) {
                return true;
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

    private class Node<Value> {

        private Value data;
        private Node<Value> next;

        public Node(Value data) {
            this.data = data;
        }
    }
}
