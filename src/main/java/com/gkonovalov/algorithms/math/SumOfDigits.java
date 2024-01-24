package com.gkonovalov.algorithms.math;

/**
 * Created by Georgiy Konovalov on 24/2/2024.
 * <p>
 * Sum of digit numbers algorithm implementation.
 * The sum of digits algorithm calculates the sum of the individual digits of a given number.
 * This algorithm is commonly used in various applications, such as checking divisibility by 9,
 * creating checksums, and solving problems related to digital roots.
 * </p>
 * Runtime Complexity: O(log10(n)) for {@code sum}.
 * Space Complexity:   O(1) for {@code sum}.
 */
public class SumOfDigits {

    public int sum(int number) {
        int sum = 0;

        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
}
