package problems.leetcode.arrays.binarysearch.easy;


/**
 * Created by Georgiy Konovalov on 8/04/2023.
 * <p>
 *
 * @see <a href="https://leetcode.com/problems/binary-search/">[Easy][704] - Binary Search</a>
 * </p>
 * Runtime Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {40, -2, 4, 44, 5, 42, 13, 20, -555, 25, 3, -1, 53};

        System.out.println("Position:" + search(arr, 42));
    }

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int center = (end - start) / 2 + start;

            if (target < nums[center]) {
                end = center - 1;
            } else if (target > nums[center]) {
                start = center + 1;
            } else {
                return center;
            }
        }

        return -1;
    }
}
