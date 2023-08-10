package com.gkonovalov.problems.tree;

import com.gkonovalov.problems.utils.Node;

/**
 * Created by Georgiy Konovalov on 10/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/maximum-depth-of-n-ary-tree/">
 *              [Easy][559] - Maximum Depth of N-ary Tree
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code maxDepth}.
 * Space Complexity:   O(n) for {@code maxDepth}.
 */
public class MaximumDepthOfNAryTree {

    public static void main(String[] args) {
        Node root = new Node(3);
        root.neighbors.add(new Node(2));
        root.neighbors.add(new Node(1));

        System.out.println("Max depth:" + maxDepth(root));
    }

    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int max = 0;

        for (Node child : root.neighbors) {
            max = Math.max(maxDepth(child), max);
        }

        return max + 1;
    }
}
