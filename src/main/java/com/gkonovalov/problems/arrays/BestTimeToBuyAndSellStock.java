package com.gkonovalov.problems.arrays;

/**
 * Created by Georgiy Konovalov on 7/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">
 *              [Easy][121] - Best Time to Buy and Sell Stock
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code maxProfit}.
 * Space Complexity:   O(1) for {@code maxProfit}.
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        System.out.println("Max profit:" + maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minNum = Integer.MAX_VALUE;

        for (int price : prices) {
            minNum = Math.min(price, minNum);
            maxProfit = Math.max(price - minNum, maxProfit);
        }

        return maxProfit;
    }
}
