package com.gkonovalov.problems.hastable;


import java.util.*;

/**
 * Created by Georgiy Konovalov on 2/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/group-anagrams/">
 *          [Medium][49] - Group Anagrams
 *      </a>
 * </p>
 * Runtime Complexity: O(n m log m) for {@code groupAnagrams}.
 * Space Complexity:   O(nm) for {@code groupAnagrams}.
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] arr = str.toCharArray();

            Arrays.sort(arr);

            String key = String.valueOf(arr);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }

        result.addAll(map.values());

        return result;
    }
}
