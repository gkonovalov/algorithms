package com.gkonovalov.algorithms.math;

/**
 * Created by Georgiy Konovalov on 1/05/2024.
 * <p>
 * The Greatest Common Divisor algorithm implementation. This algorithm based on Euclid's method,
 * commonly known as the Euclidean Algorithm, is an efficient algorithm for finding the GCD of two integers.
 * The Euclidean Algorithm repeatedly applies the division remainder operation until a remainder of 0 is obtained.
 * The last non-zero remainder is the GCD. The Extended Euclidean Algorithm extends the Euclidean Algorithm by
 * maintaining extra variables to keep track of coefficients x and y for the
 * linear Diophantine equation: ax + by = GCD(a,b).
 * </p>
 * Runtime Complexity: O(log min(a, b)) for {@code gcdRecursive}, {@code gcdIterative} and {@code gcdExtended}.
 * Space Complexity:   O(log min(a, b)) for {@code gcdRecursive} and {@code gcdExtended},
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

    public int gcdExtended(int a, int b) {
        return extendedEuclidean(a, b)[0];
    }

    public int[] extendedEuclidean(int a, int b) {
        if (b == 0) {
            return new int[]{a, 1, 0};
        }

        int[] result = extendedEuclidean(b, a % b);

        int gcd = result[0];
        int x = result[2];
        int y = result[1] - (a / b) * result[2];

        return new int[]{gcd, x, y};
    }

}
