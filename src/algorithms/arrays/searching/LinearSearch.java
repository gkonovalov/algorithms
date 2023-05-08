package algorithms.arrays.searching;

/**
 * Created by Georgiy Konovalov on 5/04/2023.
 * <p>
 * Linear search implementation.
 * </p>
 * Runtime Complexity: O(n)
 * Space Complexity: O(n)
 */
public class LinearSearch {

    public static void main(String[] args) {
        int[] arr = {40, -2, 4, 44, 5, 42, 13, 20, -555, 25, 3, -1, 53};

        System.out.println("Position:" + searchIteratively(arr, 42));
    }

    public static int searchIteratively(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (num == arr[i]) {
                return i;
            }
        }
        return -1;
    }
}
