package com.gkonovalov.problems.arrays.twopointers;

/**
 * Created by Georgiy Konovalov on 31/07/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/container-with-most-water/">
 *          [Medium][11] - Container With Most Water
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code maxArea}.
 * Space Complexity:  O(1) for {@code maxArea}.
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};

        System.out.println("Max Area:" + maxArea(arr));
    }

    public static int maxArea(int[] height) {
        int maxArea = 0;

        int left = 0;
        int right = height.length - 1;

        while (left <= right) {
            maxArea = Math.max(Math.min(height[right], height[left]) * (right - left), maxArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
