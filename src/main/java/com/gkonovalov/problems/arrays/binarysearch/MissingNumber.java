package com.gkonovalov.problems.arrays.binarysearch;


/**
 * Created by Georgiy Konovalov on 10/04/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/missing-number/">
 *          [Easy][268] - Missing Number
 *      </a>
 * </p>
 * Runtime Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MissingNumber {

    public static void main(String[] args) {
        int[] arr = {3, 0, 1};

        System.out.println("First Bad Version:" + missingNumber(arr));
    }

    public static int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
            sum += i;
        }

        return sum + nums.length;
    }

    public static int missingNumber2(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= nums[i] ^ i;
        }

        return missing;
    }


}
