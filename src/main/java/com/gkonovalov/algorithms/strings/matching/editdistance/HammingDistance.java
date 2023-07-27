package com.gkonovalov.algorithms.strings.matching.editdistance;

/**
 * Created by Georgiy Konovalov on 27/07/2023.
 * <p>
 * Hamming Distance implementation. Hamming Distance is a measure of similarity between two strings
 * of equal length. It calculates the number of positions at which the corresponding characters in
 * the two strings are different. In other words, it measures the minimum number of substitutions
 * required to change one string into the other.
 * The Hamming Distance is mainly used in fields like coding theory, information theory, and
 * cryptography. It is particularly useful for detecting errors in data transmission or storage,
 * as well as for measuring the dissimilarity between binary strings.
 *
 * It's important to note that the Hamming Distance is only defined for strings of equal length.
 * If the strings have different lengths, the Hamming Distance cannot be computed directly. In such
 * cases, additional preprocessing or padding may be required to make the strings of equal length
 * before calculating the Hamming Distance.
 * </p>
 * Runtime Complexity: O(n) for the {@code calculateDistance}.
 * Space Complexity:   O(n) for {@code calculateDistance}.
 */
public class HammingDistance {

    public int calculateDistance(String s1, String s2) {
        if (s1.length() != s2.length()) {
            throw new IllegalArgumentException("Input strings must have equal length!");
        }

        int distance = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                distance++;
            }
        }

        return distance;
    }
}
