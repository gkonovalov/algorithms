package com.gkonovalov.problems.math;


/**
 * Created by Georgiy Konovalov on 25/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/count-primes/">
 *          [Medium][204] - Count Primes
 *      </a>
 * </p>
 * Runtime Complexity: O(sqrt(n) log log n) for {@code countPrimes}.
 * Space Complexity:   O(n) for {@code countPrimes}.
 */
public class CountPrimes {

    public static void main(String[] args) {
        System.out.println("Count primes:" + countPrimes(10));
    }

    public static int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }

        boolean[] notPrimes = new boolean[n + 1];

        int count = 0;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!notPrimes[i]) {
                for (int k = i * i; k <= n; k += i) {
                    notPrimes[k] = true;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (!notPrimes[i]) {
                count++;
            }
        }
        return count;
    }

    public static int countPrimes2(int n) {
        if (n <= 1) {
            return 0;
        }

        int count = 0;

        for (int i = 2; i < n; i++) {
            int sqrt = (int) Math.sqrt(i);

            if (i < 4) {
                count++;
            }

            for (int k = 2; k <= sqrt; k++) {
                if (i % k == 0) {
                    break;
                }

                if (k == sqrt) {
                    count++;
                }
            }
        }
        return count;
    }
}
