package com.gkonovalov.problems.tree.nary;

import com.gkonovalov.problems.utils.Node;

/**
 * Created by Georgiy Konovalov on 10/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/clone-n-ary-tree/">
 *          [Medium][1490] - Clone N-ary Tree
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code cloneTree}.
 * Space Complexity:   O(n) for {@code cloneTree}.
 */
public class CloneNAryTree {

    public static void main(String[] args) {
        Node root = new Node(3);
        root.neighbors.add(new Node(2));
        root.neighbors.add(new Node(1));

        cloneTree(root);
    }

    public static Node cloneTree(Node root) {
        if (root == null) {
            return root;
        }

        Node newNode = new Node(root.val);

        for (Node nextNode : root.neighbors) {
            newNode.neighbors.add(cloneTree(nextNode));
        }

        return newNode;
    }
}
