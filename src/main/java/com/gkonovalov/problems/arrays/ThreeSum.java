package com.gkonovalov.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Georgiy Konovalov on 15/04/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/3sum/">
 *          [Medium][15] - Three Sum
 *      </a>
 * </p>
 * Runtime Complexity: O(n^2) for {@code threeSum}.
 * Space Complexity:  O(n) for {@code threeSum}.
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};

        System.out.println("Find three sum:" + threeSum(arr));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            threeSumHelper(i, result, nums);
        }
        return new ArrayList<>(result);
    }

    private static void threeSumHelper(int first, HashSet<List<Integer>> result, int[] nums) {
        int second = first + 1;
        int third = nums.length - 1;

        while (second < third) {
            int sum = nums[first] + nums[second] + nums[third];

            if (sum > 0) {
                third--;
            } else if (sum < 0) {
                second++;
            } else {
                result.add(Arrays.asList(nums[first], nums[second++], nums[third--]));
            }
        }
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || (nums[i] != nums[i - 1])) {
                sumHelper2(nums, i, result);
            }
        }

        return result;
    }

    private static void sumHelper2(int[] nums, int secondP, List<List<Integer>> result) {
        int firstP = secondP + 1;
        int thirdP = nums.length - 1;

        while (firstP < thirdP) {
            int sum = nums[firstP] + nums[secondP] + nums[thirdP];

            if (sum < 0) {
                firstP++;
            } else if (sum > 0) {
                thirdP--;
            } else {
                result.add(Arrays.asList(nums[firstP], nums[secondP], nums[thirdP]));

                while (firstP < thirdP && nums[firstP] == nums[firstP + 1]) firstP++;
                while (firstP < thirdP && nums[thirdP] == nums[thirdP - 1]) thirdP--;

                firstP++;
                thirdP--;
            }
        }
    }

    public static List<List<Integer>> threeSum3(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> sum = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                threeSumHelper3(nums, i, sum);
            }
        }
        return new ArrayList<>(sum);
    }


    private static void threeSumHelper3(int[] nums, int k, HashSet<List<Integer>> sum) {
        HashSet<Integer> seen = new HashSet<>();

        for (int i = k + 1; i < nums.length; i++) {
            int compliment = -nums[i] - nums[k];

            if (seen.contains(compliment)) {
                sum.add(Arrays.asList(nums[i], nums[k], compliment));
            }

            seen.add(nums[i]);
        }
    }
}
