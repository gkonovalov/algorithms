package com.gkonovalov.algorithms.math.primenumbers.primalitytest;

/**
 * Created by Georgiy Konovalov on 1/5/2024.
 * <p>
 * The Trial Division Primality Test algorithm implementation. Trial division is one of the simplest
 * and most straightforward primality testing algorithms. It involves dividing the given number n
 * by each integer i from 2 to sqrt(n) to check for divisibility. If n is divisible by any i, then n is
 * compromise. If no divisors are found then n is prime.
 * </p>
 * Runtime Complexity: O(log n) for {@code isPrimeNumber}.
 * Space Complexity:   O(1) for {@code isPrimeNumber}.
 */
public class TrialDivisionPrimalityTest {

    public boolean isPrimeNumber(int n) {
        if (n == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return n >= 2;
    }
}
