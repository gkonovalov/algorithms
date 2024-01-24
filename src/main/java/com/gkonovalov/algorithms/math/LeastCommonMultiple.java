package com.gkonovalov.algorithms.math;


/**
 * Created by Georgiy Konovalov on 24/01/2024.
 * <p>
 * Least Common Multiple algorithm implementation.
 * The Least Common Multiple (LCM) of two or more integers is the smallest positive integer that
 * is divisible by each of the given integers without leaving a remainder. In other words, it is
 * the smallest common multiple of the numbers.
 * LCM = abs(a*b) / gcd(a,b).
 * </p>
 * Runtime Complexity: O(log min(a, b)) for {@code calculate}.
 * Space Complexity:   O(log min(a, b)) for {@code calculate}.
 */
public class LeastCommonMultiple {

    public int calculate(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
