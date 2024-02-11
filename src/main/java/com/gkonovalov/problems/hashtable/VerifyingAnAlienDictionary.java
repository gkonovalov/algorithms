package com.gkonovalov.problems.hashtable;

import java.util.HashMap;

/**
 * Created by Georgiy Konovalov on 4/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/verifying-an-alien-dictionary/">
 *         [Easy][953] - Verifying an Alien Dictionary
 *      </a>
 * </p>
 * Runtime Complexity: O(ns) for {@code isAlienSorted}.
 * Space Complexity:   O(1) for {@code isAlienSorted}.
 */
public class VerifyingAnAlienDictionary {

    public static void main(String[] args) {
        System.out.println("Is ordered:" + isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }

    public static boolean isAlienSorted(String[] words, String order) {
        if (words == null || words.length == 0 || order == null) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for (int i = 1; i < words.length; i++) {
            if (!isValid(map, words[i - 1], words[i])) {
                return false;
            }
        }

        return true;
    }

    private static boolean isValid(HashMap<Character, Integer> map, String w1, String w2) {
        for (int i = 0; i < Math.min(w1.length(), w2.length()); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                return map.get(w1.charAt(i)) < map.get(w2.charAt(i));
            }
        }
        return w1.length() <= w2.length();
    }
}
