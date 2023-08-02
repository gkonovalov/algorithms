package com.gkonovalov.problems.tree;


import com.gkonovalov.problems.utils.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Georgiy Konovalov on 2/08/2023.
 * <p>
 *
 * @see <a href="https://leetcode.com/problems/binary-tree-right-side-view/">
 *             [Medium][199] - Binary Tree Right Side View
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code rightSideView}, {@code rightSideView2}.
 * Space Complexity:   O(D) for {@code rightSideView}, O(H) for {@code rightSideView2}.
 */
public class BinaryTreeRightSideView {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(rightSideView(root));
    }

    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (i == size - 1) {
                    result.add(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return result;
    }

    public static List<Integer> rightSideView2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        dfs(root, result, 0);
        return result;
    }

    private static void dfs(TreeNode root, ArrayList<Integer> result, int index) {
        if (root == null) {
            return;
        }

        if (index == result.size()) {
            result.add(root.val);
        }

        dfs(root.right, result, index + 1);
        dfs(root.left, result, index + 1);
    }
}
