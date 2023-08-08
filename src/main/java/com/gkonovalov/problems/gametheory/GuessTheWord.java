package com.gkonovalov.problems.gametheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Georgiy Konovalov on 8/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/guess-the-word/">
 *          [Hard][843] - Guess the Word
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code findSecretWord}.
 * Space Complexity:   O(n) for {@code findSecretWord}.
 */
public class GuessTheWord {

    public static void main(String[] args) {
        findSecretWord(new String[]{"acckzz", "ccbazz", "eiowzz", "abcczz"}, new Master() {
            @Override
            public int guess(String word) {
                return getMatches(word, "eiowzz");
            }
        });
    }

    public static void findSecretWord(String[] words, Master master) {
        List<String> candidates = new ArrayList<>(Arrays.asList(words));
        Random rnd = new Random();

        while (!candidates.isEmpty()) {
            String word = candidates.get(rnd.nextInt(candidates.size()));
            int matches = master.guess(word);

            if (matches == word.length()) {
                return;
            }
            candidates = filterCandidates(candidates, word, matches);
        }
    }

    private static List<String> filterCandidates(List<String> candidates, String word, int matches) {
        List<String> filtered = new ArrayList<>();
        for (String word2 : candidates) {
            if (word.equals(word2)) {
                continue;
            }

            if (getMatches(word, word2) == matches) {
                filtered.add(word2);
            }
        }
        return filtered;
    }

    private static int getMatches(String a, String b) {
        int count = 0;

        for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    interface Master {
        int guess(String word);
    }
}
