package com.gkonovalov.problems.graph;

import com.gkonovalov.problems.utils.Node;

import java.util.HashMap;

/**
 * Created by Georgiy Konovalov on 7/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/clone-graph/">
 *          [Medium][133] - Clone Graph
 *      </a>
 * </p>
 * Runtime Complexity: O(|E|+|V|) for {@code cloneGraph}.
 * Space Complexity:  O(|V|) for {@code cloneGraph}.
 */
public class CloneGraph {

    public static void main(String[] args) {
        cloneGraph(new Node(4));
    }

    private static HashMap<Integer, Node> map = new HashMap<>();

    public static Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }

        Node newNode = new Node(node.val);
        map.put(newNode.val, newNode);

        for (Node nextNode : node.neighbors) {
            newNode.neighbors.add(cloneGraph(nextNode));
        }

        return newNode;
    }

}
