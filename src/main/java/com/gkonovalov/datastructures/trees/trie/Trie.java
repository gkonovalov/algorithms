package com.gkonovalov.datastructures.trees.trie;

import com.gkonovalov.datastructures.etc.TrieNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Georgiy Konovalov on 15/06/2023.
 * <p>
 * Trie data structure implementation, also known as a Prefix Tree, is a tree-based data structure
 * that is commonly used for efficient retrieval and storage of strings or sequences of characters.
 * It is particularly well-suited for problems involving dictionary search and prefix matching.
 * In a Trie, each node represents a character or a partial string. The edges of the tree represent
 * the links between characters. Starting from the root node, each path from the root to a leaf node
 * represents a complete string or a prefix of a string.
 * </p>
 * Runtime Complexity: O(n) for {@code insert}, {@code search}, {@code startWith}.
 * Space Complexity:   O(n).
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Input parameter word, can't be null!");
        }

        TrieNode currentNode = root;

        for (int i = 0; i < word.length(); i++) {
            Character letter = word.charAt(i);

            if (!currentNode.nodes.containsKey(letter)) {
                currentNode.nodes.put(letter, new TrieNode());
            }

            currentNode = currentNode.nodes.get(letter);
        }

        currentNode.isWordEnd = true;
    }

    public boolean search(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Input parameter word, can't be null!");
        }

        TrieNode foundWord = findNode(word);

        return foundWord != null && foundWord.isWordEnd;
    }

    public boolean startWith(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException("Input parameter prefix, can't be null!");
        }

        return findNode(prefix) != null;
    }

    public List<String> suggestions(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException("Input parameter prefix, can't be null!");
        }

        List<String> result = new ArrayList<>();
        TrieNode currentNode = findNode(prefix);

        if (currentNode != null && currentNode.nodes != null) {
            searchDfs(currentNode, new StringBuilder(prefix), result);
        }

        return result;
    }

    private void searchDfs(TrieNode node, StringBuilder prefix, List<String> result) {
        for (Character key : node.nodes.keySet()) {
            prefix.append(key);

            if (node.nodes.get(key).isWordEnd) {
                result.add(prefix.toString());
            }

            searchDfs(node.nodes.get(key), prefix, result);

            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    private TrieNode findNode(String str) {
        TrieNode currentNode = root;

        for (Character letter : str.toCharArray()) {
            if (!currentNode.nodes.containsKey(letter)) {
                return null;
            }

            currentNode = currentNode.nodes.get(letter);
        }

        return currentNode;
    }
}