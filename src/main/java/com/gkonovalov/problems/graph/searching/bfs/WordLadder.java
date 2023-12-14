package com.gkonovalov.problems.graph.searching.bfs;

import java.util.*;

/**
 * Created by Georgiy Konovalov on 13/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/word-ladder/">
 *          [Hard][127] - Word Ladder
 *      </a>
 * </p>
 * Runtime Complexity: O(m^2 n) for {@code ladderLength}, where M is size of word & N is size of our word list.
 * Space Complexity:  O(m n) for {@code ladderLength}, where M is size of word & N is size of our word list.
 */
public class WordLadder {

    public static void main(String[] args) {
        System.out.println("Ladder length:" +
                ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        int count = 1;

        while (!queue.isEmpty()) {
            count++;
            for (int k = queue.size(); k > 0; k--) {
                char[] word = queue.poll().toCharArray();

                for (int i = 0; i < word.length; i++) {
                    char temp = word[i];

                    for (char letter = 'a'; letter <= 'z'; letter++) {
                        word[i] = letter;

                        String newWord = String.valueOf(word);
                        if (set.contains(newWord)) {
                            queue.add(newWord);
                            set.remove(newWord);

                            if (newWord.equals(endWord)) {
                                return count;
                            }
                        }
                    }
                    word[i] = temp;
                }
            }
        }

        return 0;
    }
}
