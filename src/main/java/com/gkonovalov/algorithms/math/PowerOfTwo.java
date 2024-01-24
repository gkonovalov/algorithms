package com.gkonovalov.algorithms.math;

/**
 * Created by Georgiy Konovalov on 1/05/2024.
 * <p>
 * Power of Two algorithm implementation.
 * The "Power of Two" algorithm checks whether a given positive integer is a power of two.
 * A positive integer is considered a power of two if it can be expressed as 2^k for some
 * integer value of k. In binary representation, a power of two has exactly one bit set to 1.
 * </p>
 * Runtime Complexity: O(1) for {@code isPowerOfTwo},
 *                     O(log2 n) for {@code isPowerOfTwo2}.
 * Space Complexity:   O(1) for {@code isPowerOfTwo} and {@code isPowerOfTwo2}.
 */
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        return (n & (n - 1)) == 0;
    }

    public boolean isPowerOfTwo2(int n) {
        if (n <= 0) {
            return false;
        }

        while (n != 1) {
            if (n % 2 != 0) {
                return false;
            }
            n/= 2;
        }

        return true;
    }
}
