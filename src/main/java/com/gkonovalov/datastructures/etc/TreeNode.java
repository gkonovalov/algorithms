package com.gkonovalov.datastructures.etc;

/**
 * Created by Georgiy Konovalov on 17/05/2023.
 * <p>
 * Base block for the Binary Tree construction.
 * </p>
 */
public class TreeNode {
    public Integer value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(){}

    public TreeNode(Integer value) {
        this.value = value;
    }
}

