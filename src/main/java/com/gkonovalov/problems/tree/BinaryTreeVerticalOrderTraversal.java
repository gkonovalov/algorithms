package com.gkonovalov.problems.tree;

import com.gkonovalov.problems.utils.Node;
import com.gkonovalov.problems.utils.TreeNode;

import java.util.*;

/**
 * Created by Georgiy Konovalov on 10/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/binary-tree-vertical-order-traversal/">
 *          [Medium][314] - Binary Tree Vertical Order Traversal
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code verticalOrder}.
 * Space Complexity:   O(n) for {@code verticalOrder}.
 */
public class BinaryTreeVerticalOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        verticalOrder(root);
    }

    public static List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();

            if (!map.containsKey(p.pos)) {
                map.put(p.pos, new ArrayList<>());
            }

            map.get(p.pos).add(p.node.val);

            if (p.node.left != null) {
                queue.add(new Pair(p.node.left, p.pos - 1));
            }

            if (p.node.right != null) {
                queue.add(new Pair(p.node.right, p.pos + 1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        for (Integer key : keys) {
            result.add(map.get(key));
        }

        return result;
    }

    static class Pair {
        public TreeNode node;
        public int pos = 0;

        public Pair(TreeNode node, int pos) {
            this.node = node;
            this.pos = pos;
        }
    }
}
