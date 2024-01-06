package com.gkonovalov.algorithms.math.primenumbers.factorization;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Georgiy Konovalov on 1/05/2024.
 * <p>
 * The Wheel Prime Factorization algorithm implementation. Wheel Factorization is an optimization of
 * the Trial Division algorithm. The idea is the following. Once we know that the number is
 * not divisible by 2, we don't need to check every other even number. This leaves us with only 50% of
 * the numbers to check. After checking 2, we can simply start with 3 and skip every other number.
 * </p>
 * Runtime Complexity: O(sqrt(n) for {@code factorize}.
 * Space Complexity:   O(log n) for {@code factorize}.
 */
public class WheelPrimeFactorization {

    public List<Integer> factorize(int num) {
        List<Integer> primeFactors = new ArrayList<>();

        while (num % 2 == 0) {
            primeFactors.add(2);
            num /= 2;
        }

        for (int i = 3; i <= Math.sqrt(num); i += 2) {
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
