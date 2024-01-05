package com.gkonovalov.algorithms.math.gcd;

/**
 * Created by Georgiy Konovalov on 1/05/2024.
 * <p>
 * The Greatest Common Divisor algorithm implementation. This algorithm based on Euclid's method,
 * commonly known as the Euclidean Algorithm, is an efficient algorithm for finding the GCD of two integers.
 * It is one of the oldest and most fundamental algorithms in mathematics.
 * </p>
 * Runtime Complexity: O(log min(a, b)) for {@code gcdRecursive} and {@code gcdIterative}.
 * Space Complexity:   O(log min(a, b)) for {@code gcdRecursive},
 *                     O(1) for {@code gcdIterative}.
 */
public class GreatestCommonDivisorEuclidean {

    public int gcdRecursive(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcdRecursive(b, a % b);
    }

    public int gcdIterative(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
