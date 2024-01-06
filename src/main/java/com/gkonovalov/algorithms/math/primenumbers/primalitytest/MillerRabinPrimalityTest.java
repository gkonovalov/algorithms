package com.gkonovalov.algorithms.math.primenumbers.primalitytest;

import java.util.Random;

/**
 * Created by Georgiy Konovalov on 1/5/2024.
 * <p>
 * The Miller-Rabin Primality Test algorithm implementation. The Miller-Rabin primality test is a
 * probabilistic algorithm used to determine if a given number is likely to be a prime number.
 * It is based on the properties of Fermat's Little Theorem and uses randomization to achieve
 * its probabilistic nature.
 *
 * It's important to note that the Miller-Rabin test is a probabilistic algorithm, meaning that
 * it can produce a false positive (declaring a composite number as prime) or a false negative
 * (declaring a prime number as composite) with a small probability.
 * The accuracy of the test depends on the number of iterations k. Increasing k increases the
 * accuracy but also increases the running time.  In practice, a commonly used value for k is 40,
 * which provides a very high level of confidence in the primality test.
 * </p>
 * Runtime Complexity: O(k log^3 n) for {@code isPrime}, where k number of iterations.
 * Space Complexity:   O(1) for {@code isPrime}.
 */
public class MillerRabinPrimalityTest {

    private Random rnd;

    public MillerRabinPrimalityTest() {
        this.rnd = new Random();
    }

    public boolean isPrimeNumber(int n, int k) {
        if (n <= 1 || n == 4) {
            return false;
        }
        if (n <= 3) {
            return true;
        }

        int d = n - 1;

        while (d % 2 == 0) {
            d /= 2;
        }

        for (int i = 0; i < k; i++) {
            if (!millerRabinTest(n, d)) {
                return false;
            }
        }

        return true;
    }

    private boolean millerRabinTest(int n, int d) {
        int a = 2 + rnd.nextInt(n - 3);
        int x = binPower(a, d, n);

        if (x == 1 || x == n - 1) {
            return true;
        }

        while (d != n - 1) {
            x = (x * x) % n;
            d *= 2;

            if (x == 1) {
                return false;
            }
            if (x == n - 1) {
                return true;
            }
        }

        return false;
    }

    private int binPower(int a, int n, int mod) {
        int result = 1;

        a %= mod;

        while (n > 0) {
            if (n % 2 == 1) {
                result = (result * a) % mod;
            }

            n /= 2;
            a = (a * a) % mod;
        }

        return result;
    }
}
