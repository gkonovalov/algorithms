package com.gkonovalov.problems.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Georgiy Konovalov on 24/07/2023.
 */
public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        this.val = 0;
        this.neighbors = new ArrayList<Node>();
    }
    public Node(int val) {
        this.val = val;
        this.neighbors = new ArrayList<Node>();
    }
    public Node(int val, ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}