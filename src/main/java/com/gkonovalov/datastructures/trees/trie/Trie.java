package com.gkonovalov.datastructures.trees.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {

    private Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node currentNode = root;

        for (int i = 0; i < word.length(); i++) {
            Character letter = word.charAt(i);

            if (!currentNode.nodes.containsKey(letter)) {
                currentNode.nodes.put(letter, new Node());
            }
            currentNode = currentNode.nodes.get(letter);
        }
        currentNode.isWordEnd = true;
    }

    public boolean search(String word) {
        Node foundWord = findNode(word);

        if (foundWord != null && foundWord.isWordEnd) {
            return true;
        } else {
            return false;
        }
    }

    public boolean startWith(String prefix) {
        if (findNode(prefix) != null) {
            return true;
        } else {
            return false;
        }
    }

    public List<String> suggestions(String prefix) {
        List<String> result = new ArrayList<>();

        Node currentNode = findNode(prefix);

        if (currentNode != null && currentNode.nodes != null) {
            searchStringsDfs(currentNode, new StringBuilder(prefix), result);
        }

        return result;
    }

    private void searchStringsDfs(Node node, StringBuilder prefix, List<String> result) {
        for (Character key : node.nodes.keySet()) {
            prefix.append(key);

            if (node.nodes.get(key).isWordEnd) {
                result.add(prefix.toString());
            }

            searchStringsDfs(node.nodes.get(key), prefix, result);

            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    private Node findNode(String str) {
        Node currentNode = root;

        for (Character letter : str.toCharArray()) {
            if (!currentNode.nodes.containsKey(letter)) {
                return null;
            }
            currentNode = currentNode.nodes.get(letter);
        }
        return currentNode;
    }

    private class Node {

        private HashMap<Character, Node> nodes;
        private boolean isWordEnd;

        public Node() {
            this.nodes = new HashMap<>();
            this.isWordEnd = false;
        }
    }
}