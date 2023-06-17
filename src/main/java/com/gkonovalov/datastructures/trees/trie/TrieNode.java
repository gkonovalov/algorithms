package com.gkonovalov.datastructures.trees.trie;

import java.util.HashMap;

/**
 * Created by Georgiy Konovalov on 17/05/2023.
 * <p>
 * Base block for the Trie construction.
 * </p>
 */
public class TrieNode {

    public HashMap<Character, TrieNode> nodes;
    public boolean isWordEnd;

    public TrieNode() {
        this.nodes = new HashMap<>();
        this.isWordEnd = false;
    }
}

