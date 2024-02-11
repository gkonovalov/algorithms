package com.gkonovalov.problems.tree.nary;

import com.gkonovalov.problems.utils.Node;

/**
 * Created by Georgiy Konovalov on 10/08/2023.
 * <p>
 *
 * @see <a href="https://leetcode.com/problems/diameter-of-n-ary-tree/">
 *              [Medium][1522] - Diameter of N-Ary Tree
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code diameter}.
 * Space Complexity:   O(n) for {@code diameter}.
 */
public class DiameterNAryTree {

    public static void main(String[] args) {
        Node root = new Node(3);
        root.neighbors.add(new Node(2));
        root.neighbors.add(new Node(1));

        diameter(root);
    }

    private static int max = 0;

    public static int diameter(Node root) {
        dfs(root);
        return max;
    }

    private static int dfs(Node root) {
        if (root == null || root.neighbors.isEmpty()) {
            return 0;
        }

        int h1 = 0;
        int h2 = 0;

        for (Node child : root.neighbors) {
            int height = dfs(child) + 1;

            if (height > h1) {
                h1 = h2;
                h2 = height;
            } else if (height > h2) {
                h2 = height;
            }

            max = Math.max(h1 + h2, max);
        }

        return Math.max(h1, h2);
    }
}
