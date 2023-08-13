package com.gkonovalov.problems.recursion.dp;


/**
 * Created by Georgiy Konovalov on 13/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/trapping-rain-water/">
 *          [Hard][42] - Trapping Rain Water
 *      </a>
 * </p>
 * Runtime Complexity: O(n).
 * Space Complexity:   O(1).
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public static int trap(int[] height) {
        int max = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int leftPos = 0;
        int rightPos = height.length - 1;

        while (leftPos <= rightPos) {
            maxLeft = Math.max(maxLeft, height[leftPos]);
            maxRight = Math.max(maxRight, height[rightPos]);

            if (maxLeft < maxRight) {
                max += maxLeft - height[leftPos];
                leftPos++;
            } else {
                max += maxRight - height[rightPos];
                rightPos--;
            }
        }

        return max;
    }
}
