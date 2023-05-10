package problems.leetcode.arrays.binarysearch.medium;


/**
 * Created by Georgiy Konovalov on 8/04/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/cutting-ribbons/">
 *          [Medium][1891] - Cutting Ribbons
 *      </a>
 * </p>
 * Runtime Complexity: O(n log n)
 * Space Complexity: O(1)
 */
public class CuttingRibbons {

    public static void main(String[] args) {
        int[] arr = {9,7,5};

        System.out.println("Max ribbon length:" + maxLength(arr, 3));
    }

    public static int maxLength(int[] ribbons, int k) {
        int start = 1;
        int end = getMax(ribbons);
        int result = 0;

        while (start <= end) {
            int length = (end - start) / 2 + start;

            if (countSegments(ribbons, length) >= k) {
                result = length;
                start = length + 1;
            } else {
                end = length - 1;
            }
        }
        return result;
    }

    private static int countSegments(int[] ribbons, int length) {
        int segments = 0;

        for (int ribbon : ribbons) {
            segments += ribbon / length;
        }

        return segments;
    }

    private static int getMax(int[] ribbons) {
        int max = 0;

        for (int ribbon : ribbons) {
            max = Math.max(max, ribbon);
        }

        return max;
    }

}
