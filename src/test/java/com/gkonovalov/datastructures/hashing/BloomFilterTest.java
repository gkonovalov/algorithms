package com.gkonovalov.datastructures.hashing;

import com.gkonovalov.datastructures.bloomfilter.BloomFilter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Georgiy Konovalov on 20/07/2023.
 * <p>
 * Tests for {@link BloomFilter}.
 * </p
 */
public class BloomFilterTest {

    private BloomFilter bloomFilter;

    @BeforeEach
    public void setUp() {
        this.bloomFilter = new BloomFilter(1000, 10);
    }

    @Test
    @DisplayName("Testing BloomFilter.mightContain")
    public void testMightContain() {
        bloomFilter.add("hello");
        bloomFilter.add("heppo");

        assertTrue(bloomFilter.mightContain("heppo"));
        assertTrue(bloomFilter.mightContain("hello"));

        assertFalse(bloomFilter.mightContain("helal"));
        assertFalse(bloomFilter.mightContain("cello"));

        assertFalse(bloomFilter.mightContain("I am testing this Bloom Filter!"));
    }
}
