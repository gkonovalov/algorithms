package com.gkonovalov.problems.arrays.searching.binarysearch;


/**
 * Created by Georgiy Konovalov on 10/04/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/missing-number/">
 *          [Easy][268] - Missing Number
 *      </a>
 * </p>
 * Runtime Complexity: O(n).
 * Space Complexity:   O(1).
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


    /**
     * Created by Georgiy Konovalov on 8/04/2023.
     * <p>
     * @see <a href="https://leetcode.com/problems/first-bad-version/">
     *            [Easy][278] - First Bad Version
     *      </a>
     * </p>
     * Runtime Complexity: O(log n).
     * Space Complexity:   O(1).
     */
    public static class FirstBadVersion {

        public static void main(String[] args) {
            System.out.println("First Bad Version:" + firstBadVersion(5));
        }

        public static int firstBadVersion(int n) {
            int start = 1;
            int end = n;

            while (start < end) {
                int center = (end - start) / 2 + start;

                if (isBadVersion(center)) {
                    end = center;
                } else {
                    start = center + 1;
                }
            }
            return end;
        }

        public static int firstBadVersion2(int n) {
            int start = 1;
            int end = n;

            while (start <= end) {
                int center = (end - start) / 2 + start;

                if (!isBadVersion(center)) {
                    start = center + 1;
                } else {
                    end = center - 1;
                }
            }
            return start;
        }

        private static boolean isBadVersion(int version) {
            return version >= 4;
        }
    }
}
