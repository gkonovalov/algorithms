package com.gkonovalov.algorithms.strings.matching.regularexpressions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Georgiy Konovalov on 1/30/2024.
 * <p>
 * Tests for {@link RegularExpressionMatching}.
 * </p
 */
public class RegularExpressionMatchingTest {

    private RegularExpressionMatching regexp;

    @BeforeEach
    public void setUp() {
        this.regexp = new RegularExpressionMatching();
    }

    @Test
    @DisplayName("Testing RegularExpressionMatching.isMatch")
    public void testIsMatch() {
        assertTrue(regexp.isMatch("aaaaa","a*"));
        assertTrue(regexp.isMatch("aa", "a."));
        assertFalse(regexp.isMatch("aa", "b."));
    }

    @Test
    @DisplayName("Testing RegularExpressionMatching.isMatchDP")
    public void testIsMatchDP() {
        assertTrue(regexp.isMatchDP("aaaaa","a*"));
        assertTrue(regexp.isMatchDP("aa", "a."));
        assertFalse(regexp.isMatchDP("aa", "b."));
    }

    @Test
    @DisplayName("Testing RegularExpressionMatching.isMatchDP2")
    public void testIsMatchDP2() {
        assertTrue(regexp.isMatchDP2("aaaaa","a*"));
        assertTrue(regexp.isMatchDP2("aa", "a."));
        assertFalse(regexp.isMatchDP2("aa", "b."));
    }
}
