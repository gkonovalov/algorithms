package com.gkonovalov.problems.tree.trie;

import java.util.HashMap;

/**
 * Created by Georgiy Konovalov on 1/08/2023.
 * <p>
 *
 * @see <a href="https://leetcode.com/problems/longest-common-prefix/">
 *          [Easy][14] - Longest Common Prefix
 *      </a>
 * </p>
 * Runtime Complexity: O(S) where S is all characters in strings, for {@code longestCommonPrefix}.
 * Space Complexity:   O(1) for {@code longestCommonPrefix}.
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }

        return prefix;
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        Node root = new Node();
        for (String str : strs) {
            insert(root, str);
        }

        return getPrefix(root, strs[0]);
    }

    private static String getPrefix(Node root, String str) {
        StringBuffer sb = new StringBuffer();

        for (Character letter : str.toCharArray()) {
            if (root.childs.size() != 1 || !root.childs.containsKey(letter) || root.isEnd) {
                return sb.toString();
            }

            sb.append(letter);
            root = root.childs.get(letter);
        }
        return sb.toString();
    }

    private static void insert(Node root, String str) {
        Node pointer = root;

        for (Character letter : str.toCharArray()) {
            if (!pointer.childs.containsKey(letter)) {
                pointer.childs.put(letter, new Node());
            }
            pointer = pointer.childs.get(letter);
        }
        pointer.isEnd = true;
    }

    static class Node {
        public boolean isEnd = false;
        public HashMap<Character, Node> childs = new HashMap<>();
    }
}
