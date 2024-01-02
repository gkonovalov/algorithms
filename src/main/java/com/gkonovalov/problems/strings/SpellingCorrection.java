package com.gkonovalov.problems.strings;

import java.util.*;

/**
 * Created by Georgiy Konovalov on 1/1/2024.
 *
 * The SpellingCorrection class provides a simple algorithm for correcting misspelled words
 * based on a given word count map. The algorithm suggests corrections by considering possible
 * edits such as deletions, transpositions, substitutions, and insertions to find valid words
 * from the provided word count map.
 *
 * The correction process involves analyzing the input word and generating a list of potential
 * corrections. The algorithm prioritizes corrections with the highest frequency in the word count map.
 * If the input word is already in the map, it is considered correct.
 *
 * The class can be instantiated with a pre-existing word count map, and the main method provides
 * an example of how to use the SpellingCorrection class to correct misspelled words.
 * </p>
 */

public class SpellingCorrection {

    private Map<String, Integer> dictionary;

    public SpellingCorrection(Map<String, Integer> dictionary) {
        this.dictionary = dictionary;
    }

    private String getCorrection(String word) {
        if (dictionary.containsKey(word)) {
            return word;
        }

        List<String> edits1 = edits1(word);
        List<String> knownEdits1 = known(edits1);

        if (!knownEdits1.isEmpty()) {
            return max(knownEdits1);
        }

        List<String> edits2 = edits2(word);
        List<String> knownEdits2 = known(edits2);

        if (!knownEdits2.isEmpty()) {
            return max(knownEdits2);
        }

        return word;
    }

    private List<String> edits1(String word) {
        List<String> results = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            // deletion
            String deletion = word.substring(0, i) + word.substring(i + 1);
            results.add(deletion);

            // transposition
            if (i < word.length() - 1) {
                String transposition = word.substring(0, i) + word.charAt(i + 1) + word.charAt(i) + word.substring(i + 2);
                results.add(transposition);
            }

            // substitution
            for (char c = 'a'; c <= 'z'; c++) {
                String substitution = word.substring(0, i) + c + word.substring(i + 1);
                results.add(substitution);
            }

            // insertion
            for (char c = 'a'; c <= 'z'; c++) {
                String insertion = word.substring(0, i) + c + word.substring(i);
                results.add(insertion);
            }
        }

        return results;
    }

    private List<String> known(List<String> words) {
        List<String> knownWords = new ArrayList<>();

        for (String word : words) {
            if (dictionary.containsKey(word)) {
                knownWords.add(word);
            }
        }

        return knownWords;
    }

    private List<String> edits2(String word) {
        List<String> edits1 = edits1(word);
        List<String> results = new ArrayList<>();

        for (String edit1 : edits1) {
            List<String> edits2 = edits1(edit1);
            results.addAll(edits2);
        }

        return results;
    }

    private String max(List<String> words) {
        return words.stream()
                .max(Comparator.comparing(a -> dictionary.get(a)))
                .orElse("");
    }

    public static void main(String[] args) {
        HashMap<String, Integer> dictionary = new HashMap<>() {{
            put("hello", 10);
            put("help", 6);
            put("hope", 2);
        }};

        SpellingCorrection sc = new SpellingCorrection(dictionary);

        System.out.println("Misspelled word:hell Corrected word:" + sc.getCorrection("hel"));
        System.out.println("Misspelled word:hel Corrected word:" + sc.getCorrection("hell"));
    }
}

