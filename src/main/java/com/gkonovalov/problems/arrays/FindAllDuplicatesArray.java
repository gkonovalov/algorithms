package com.gkonovalov.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Georgiy Konovalov on 15/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/find-all-duplicates-in-an-array/">
 *          [Medium][442] - Find All Duplicates in an Array
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code findDuplicates}.
 * Space Complexity:  O(1) for {@code findDuplicates}.
 */
public class FindAllDuplicatesArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};

        System.out.println("Find duplicate:" + findDuplicates(arr));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            num = Math.abs(num);

            if (nums[num - 1] < 0) {
                result.add(num);
            } else {
                nums[num - 1] *= -1;
            }
        }

        return result;
    }

    public static List<Integer> findDuplicates2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            if (!set.add(num)) {
                result.add(num);
            }
        }
        return result;
    }
}
