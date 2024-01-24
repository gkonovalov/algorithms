package com.gkonovalov.algorithms.math;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Georgiy Konovalov on 24/01/2024.
 * <p>
 * Pascal's Triangle algorithm implementation.
 * Pascal's Triangle is a triangular array of numbers where each number is the sum of the two numbers
 * directly above it. The triangle starts with the number 1 at the top. Each subsequent row is constructed
 * by adding the numbers diagonally above.
 * </p>
 * Runtime Complexity: O(n^2) for {@code generate}.
 * Space Complexity:   O(n^2) for {@code generate}.
 */
public class PascalTriangle {

    public List<List<Integer>> generate(int rows) {
        List<List<Integer>> result = new LinkedList<>() {{
            add(new LinkedList<>() {{
                add(1);
            }});
        }};

        for (int i = 1; i < rows; i++) {
            List<Integer> row = new LinkedList<>();
            row.add(1);

            List<Integer> prev = result.get(result.size() - 1);

            for (int k = 1; k < prev.size(); k++) {
                row.add(prev.get(k - 1) + prev.get(k));
            }

            row.add(1);
            result.add(row);
        }

        return result;
    }
}
