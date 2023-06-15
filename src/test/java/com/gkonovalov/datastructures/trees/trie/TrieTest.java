package com.gkonovalov.datastructures.trees.trie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Georgiy Konovalov on 12/06/2023.
 * <p>
 * Tests for {@link Trie}.
 * </p
 */
public class TrieTest {

    private Trie trie;
    private List<String> expectedSuggestions;

    @BeforeEach
    public void setUp() {
        expectedSuggestions = new ArrayList<>() {{
            add("hacker");
            add("hamster");
            add("hammer");
            add("hammerhead");
        }};

        trie = new Trie();
        trie.insert("hello");
        trie.insert("help");
        trie.insert("hacker");
        trie.insert("hamster");
        trie.insert("hammer");
        trie.insert("hammerhead");
    }

    @Test
    @DisplayName("Testing Trie.search")
    public void testSearch() {
        assertTrue(trie.search("hamster"));
        assertFalse(trie.search("huge"));
    }

    @Test
    @DisplayName("Testing Trie.startWith")
    public void testStartWith() {
        assertTrue(trie.startWith("ha"));
        assertFalse(trie.startWith("op"));
    }

    @Test
    @DisplayName("Testing Trie.suggestions")
    public void testSuggestions() {
        assertIterableEquals(expectedSuggestions, trie.suggestions("ha"));
    }
}
