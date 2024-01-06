package com.gkonovalov.algorithms.math;


/**
 * Created by Georgiy Konovalov on 5/01/2024.
 * <p>
 * Fast/Binary Exponentiation algorithm implementation. Also known as exponentiation by squaring, is an
 * algorithm for efficiently calculating the power of a number to integer exponent. The key idea behind
 * binary exponentiation is to use the binary representation of the exponent to reduce the number of
 * multiplications needed.
 * </p>
 * Runtime Complexity: O(log n) for {@code powerIterative} and {@code powerRecursive}.
 * Space Complexity:   O(1) for {@code powerIterative},
 *                     O(log n) for {@code powerRecursive}.
 */
public class FastExponentiation {

    public double powerIterative(long a, long n) {
        double result = 1;

        while (n > 0) {
            if (n % 2 == 1) {
                result = result * a;
            }
            a = a * a;
            n /= 2;
        }

        return result;
    }

    public double powerRecursive(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return powerRecursiveHelper(x, n);
    }

    private double powerRecursiveHelper(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        double half = powerRecursiveHelper(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
