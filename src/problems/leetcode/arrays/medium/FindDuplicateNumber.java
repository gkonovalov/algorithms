package problems.leetcode.arrays.medium;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Georgiy Konovalov on 10/04/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/find-the-duplicate-number/">
 *          [Medium][287] - Find the Duplicate Number
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code findDuplicate}, {@code findDuplicate1},
 *                              {@code findDuplicate2} ,{@code findDuplicate4}
 *                     O(n log n) for {@code findDuplicate3}
 *
 * Space Complexity:  O(1) for {@code findDuplicate}, {@code findDuplicate1}
 *                             {@code findDuplicate2}, {@code findDuplicate3}
 *                    O(n) for {@code findDuplicate4}
 */
public class FindDuplicateNumber {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 2};

        System.out.println("Find duplicate:" + findDuplicate(arr));
    }

    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static int findDuplicate1(int[] nums) {
        for (int num : nums) {
            int index = Math.abs(num);
            if (nums[index] < 0) {
                return index;
            }
            nums[index] *= -1;
        }
        return -1;
    }

    public static int findDuplicate2(int[] nums) {
        while (nums[0] != nums[nums[0]]) {
            int next = nums[nums[0]];
            nums[nums[0]] = nums[0];
            nums[0] = next;
        }

        return nums[0];
    }


    public static int findDuplicate3(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return nums[i];
            }
        }
        return -1;
    }

    public static int findDuplicate4(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }
}
