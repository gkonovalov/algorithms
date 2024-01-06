package com.gkonovalov.algorithms.math.primenumbers.primalitytest;

import java.util.Random;

/**
 * Created by Georgiy Konovalov on 1/5/2024.
 * <p>
 * The Fermat Primality Test algorithm implementation. Fermat primality testing is a probabilistic
 * algorithm for determining whether a given number is a probable prime. The algorithm is based on
 * Fermat's Little Theorem.
 *
 * It's important to note that Fermat primality testing is probabilistic, meaning there is a chance of error.
 * There exist composite numbers (pseudoprimes) that pass the test for certain bases. To improve accuracy,
 * the test is often repeated with different random bases.
 * While Fermat primality testing is relatively fast, it is not foolproof. In practice, more sophisticated
 * primality tests, such as the Miller-Rabin test or deterministic algorithms like the AKS primality test,
 * are often used for more reliable results.
 * </p>
 * Runtime Complexity: O(k log^3 n) for {@code isPrimeNumber}, where k is the number of iterations and n is
 *                                                             the number being tested for primality.
 * Space Complexity:   O(1) for {@code isPrimeNumber}.
 */
public class FermatPrimalityTest {

    private Random rnd;

    public FermatPrimalityTest(){
        this.rnd = new Random();
    }

    public boolean isPrimeNumber(int n, int iterations) {
        if (n < 4) {
            return n == 2 || n == 3;
        }

        for (int i = 0; i < iterations; i++) {
            int a = 2 + rnd.nextInt(n - 3);

            if (binPower(a, n - 1, n) != 1) {
                return false;
            }
        }

        return true;
    }

    private int binPower(int a, int b, int mod) {
        int result = 1;

        a %= mod;

        while (b > 0) {
            if (b % 2 == 1) {
                result = (result * a) % mod;
            }

            b /= 2;
            a = (a * a) % mod;
        }

        return result;
    }
}
