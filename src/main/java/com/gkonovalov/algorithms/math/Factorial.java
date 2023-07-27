package com.gkonovalov.algorithms.math;

import java.math.BigInteger;

/**
 * Created by Georgiy Konovalov on 26/07/2023.
 * <p>
 * Factorial algorithm implementation. Factorial is a mathematical operation that is defined for a non-negative
 * integer n. The factorial of a non-negative integer n, denoted as n!, is the product of all positive
 * integers from 1 to n. In other words, it is the result of multiplying all the integers together from 1 to n.
 * Mathematically, the factorial of n is defined as:
 * n! = 1 * 2 * 3 * ... * (n - 2) * (n - 1) * n
 * <p>
 * For example:
 * 0! = 1 (by convention)
 * 1! = 1
 * 2! = 1 * 2 = 2
 * 3! = 1 * 2 * 3 = 6
 * 4! = 1 * 2 * 3 * 4 = 24
 * 5! = 1 * 2 * 3 * 4 * 5 = 120
 * and so on.
 * For large values of n, the factorial can become very large, and computing it directly may lead to overflow
 * in certain data types. There are efficient algorithms, like the recursive approach mentioned earlier, to
 * calculate factorials, but for practical purposes, it is often calculated using iterative methods or by
 * using math libraries that support large number arithmetic.
 *
 * Factorial algorithm can be implemented recursively and iteratively.
 *
 * Recursion is a programming technique in which a function calls itself to solve a problem or perform a task.
 * Instead of using iterative loops to repeatedly execute a block of code, recursive functions break a problem
 * down into smaller subproblems and solve each subproblem by calling the same function again. This process
 * continues until the problem reaches a base case, where the function does not make any further recursive
 * calls and returns a result.
 *
 * The idea behind recursion is to solve complex problems by dividing them into smaller, more manageable parts
 * and using the same approach to solve each smaller part. This can lead to elegant and concise code for
 * certain types of problems.
 *
 * A recursive function typically consists of two parts:
 * 1. Base Case: A condition that checks whether the problem has reached a simple and straightforward solution.
 * When the base case is met, the recursive function stops calling itself and returns a value.
 * 2. Recursive Case: The part of the function where it calls itself with a modified version of the original
 * problem. This recursive call breaks the problem down into smaller subproblems.
 * To use recursion effectively, it is essential to ensure that the base case is properly defined and that
 * each recursive call brings the problem closer to the base case. If the base case is not met, the recursion
 * may lead to infinite recursion, causing a stack overflow and an error.
 *
 * Recursion is widely used in various programming tasks, such as tree and graph traversals, searching and
 * sorting algorithms, dynamic programming, backtracking, and more. While recursion can lead to concise and
 * elegant code, it is important to be mindful of the stack usage, as deep recursion may consume a lot of
 * memory and lead to performance issues. In some cases, iterative solutions may be more efficient, and choosing
 * the appropriate approach depends on the problem at hand.
 *
 * </p>
 * Runtime Complexity: O(n!) for {@code recursiveFactorial}.
 * Space Complexity:   O(n) for {@code recursiveFactorial}.
 */
public class Factorial {

    public int recursiveFactorial(int n) {
        if (n == 1) {
            return n;
        }
        return n * recursiveFactorial(n - 1);
    }

    public String iterativeFactorialBig(int number) {
        BigInteger result = BigInteger.ONE;

        for (int i = 1; i <= number; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result.toString();
    }

    public BigInteger recursiveFactorialBig(int num) {
        if (num <= 1) {
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(num).multiply(recursiveFactorialBig(num - 1));
    }
}
