package com.gkonovalov.problems.arrays.binarysearch.medium;


/**
 * Created by Georgiy Konovalov on 8/04/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/koko-eating-bananas/">
 *          [Medium][875] - Koko Eating Bananas
 *      </a>
 * </p>
 * Runtime Complexity: O(n log m)
 * Space Complexity: O(1)
 */
public class KokoEatingBananas {

    public static void main(String[] args) {
        int[] arr = {3, 6, 7, 11};

        System.out.println("Min Eating Speed:" + minEatingSpeed(arr, 8));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = getMax(piles);

        while (start < end) {
            int speed = (end - start) / 2 + start;

            if (countHours(piles, speed) <= h) {
                end = speed;
            } else {
                start = speed + 1;
            }
        }
        return end;
    }

    private static int countHours(int[] piles, int speed) {
        int hours = 0;

        for (int pile : piles) {
            hours += pile / speed;

            if (pile % speed != 0) {
                hours++;
            }
        }
        return hours;
    }

    private static int getMax(int[] piles) {
        int max = 0;

        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }


}
