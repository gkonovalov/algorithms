package com.gkonovalov.algorithms.math.primenumbers.factorization;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Georgiy Konovalov on 1/05/2024.
 * <p>
 * The Trial Division Prime Factorization algorithm implementation. There used Trial Division algorithm for
 * prime factorization. The algorithm iteratively divides the given number by prime numbers, starting
 * from 2, until the number becomes a prime itself.
 * For example, 3 × 5 is an integer factorization of 15.
 * </p>
 * Runtime Complexity: O(sqrt(n) for {@code factorize}.
 * Space Complexity:   O(log n) for {@code factorize}.
 */
public class TrialDivisionPrimeFactorization {

    public List<Integer> factorize(int num) {
        List<Integer> primeFactors = new ArrayList<>();

        for (int i = 2; i <= Math.sqrt(num); i++) {
            while (num % i == 0) {
                primeFactors.add(i);
                num /= i;
            }
        }

        if (num > 1) {//2
            primeFactors.add(num);
        }

        return primeFactors;
    }
}
