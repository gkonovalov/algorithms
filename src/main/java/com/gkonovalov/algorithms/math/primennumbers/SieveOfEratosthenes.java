package com.gkonovalov.algorithms.math.primennumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Georgiy Konovalov on 24/08/2023.
 * <p>
 * The Sieve of Eratosthenes algorithm implementation. The Sieve of Eratosthenes is an
 * ancient and efficient algorithm for finding all prime numbers up to a given limit.
 * The basic idea of the Sieve of Eratosthenes is to iteratively mark the multiples of
 * each prime number starting from 2 (the smallest prime). As the algorithm progresses,
 * it eliminates the composite numbers (non-prime numbers) and leaves only the prime numbers.
 * </p>
 * Runtime Complexity: O(n log log n) for {@code findPrimeNumbers}.
 * Space Complexity:   O(n) for {@code findPrimeNumbers}.
 */
public class SieveOfEratosthenes {

    public static List<Integer> findPrimeNumbers(int n) {
        if (n <= 1) {
            return List.of(0);
        }

        boolean[] notPrime = new boolean[n + 1];

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!notPrime[i]) {
                for (int k = i * i; k <= n; k += i) {
                    notPrime[k] = true;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                result.add(i);
            }
        }

        return result;
    }
}
