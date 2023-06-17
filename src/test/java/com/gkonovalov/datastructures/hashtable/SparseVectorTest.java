package com.gkonovalov.datastructures.hashtable;

import com.gkonovalov.datastructures.hashtables.SparseVector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Georgiy Konovalov on 16/06/2023.
 * <p>
 * Tests for {@link SparseVector}.
 * </p
 */
public class SparseVectorTest {

    private SparseVector sparseVector;

    @BeforeEach
    public void setUp() {
        this.sparseVector = new SparseVector();
    }

    @Test
    @DisplayName("Testing SparseVector.put")
    public void testPut() {
        assertEquals(0, sparseVector.size());

        sparseVector.put(0, 0.5);
        sparseVector.put(1, 0.0);
        sparseVector.put(2, 0.2);

        assertEquals(0.5, sparseVector.get(0));
        assertEquals(0.0, sparseVector.get(1));
        assertEquals(0.2, sparseVector.get(2));

        assertEquals(2, sparseVector.size());
    }

    @Test
    @DisplayName("Testing SparseVector.get")
    public void testGet() {
        assertEquals(0, sparseVector.size());

        sparseVector.put(0, 0.5);
        sparseVector.put(1, 0.0);
        sparseVector.put(2, 0.2);

        assertEquals(0.5, sparseVector.get(0));
        assertEquals(0.0, sparseVector.get(1));
        assertEquals(0.2, sparseVector.get(2));

        assertEquals(2, sparseVector.size());
    }

    @Test
    @DisplayName("Testing SparseVector.dotProduct")
    public void testDotProduct() {
        double[] arr1 = new double[]{1, 0, 0, 2, 3};
        double[] arr2 = new double[]{0, 3, 0, 4, 0};

        for(int i=0; i < arr1.length; i++){
            sparseVector.put(i, arr1[i]);
        }

        assertEquals(8, sparseVector.dotProduct(arr2));
    }

    @Test
    @DisplayName("Testing SparseVector.indices")
    public void testIndices() {
        assertEquals(0, sparseVector.size());

        sparseVector.put(0, 0.5);
        sparseVector.put(1, 0.0);
        sparseVector.put(2, 0.2);

        assertEquals(2, sparseVector.size());
        assertIterableEquals(List.of(0, 2), sparseVector.indices());
    }
}
