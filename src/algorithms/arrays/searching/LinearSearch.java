package algorithms.arrays.searching;

/**
 * Created by Georgiy Konovalov on 5/04/2023.
 * <p>
 * Linear search implementation.
 * </p>
 * Runtime Complexity: O(n)
 * Space Complexity: O(1)
 */
public class LinearSearch {

    private static final Integer[] sortedArray = {-555, -2, -1, 3, 4, 5, 13, 20, 25, 40, 42, 44, 53};

    public static void main(final String[] args) {
        System.out.println("Position:" + findNumber(53));
    }

    private static int findNumber(final int searchInt) {
        for (int i = 0; i < sortedArray.length; i++) {
            if (searchInt == sortedArray[i]) {
                return i;
            }
        }
        return -1;
    }
}
