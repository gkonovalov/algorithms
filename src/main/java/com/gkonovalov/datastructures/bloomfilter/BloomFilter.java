package com.gkonovalov.datastructures.bloomfilter;

import java.util.BitSet;
import java.util.function.Function;

/**
 * Created by Georgiy Konovalov on 20/07/2023.
 * <p>
 * Bloom Filter implementation. Bloom filter is a probabilistic data structure used for efficient
 * set membership tests. It is designed to determine whether an element is likely to be a member
 * of a set or not. However, they may produce false positives (indicating that an element is in the
 * set when it's not), but they will never produce false negatives (indicating that an element is
 * not in the set when it is). Bloom filters are particularly useful when dealing with large datasets
 * and require less memory compared to other data structures like hash tables or sets.
 *
 * Bloom Filter cheat sheet:
 *  m: total bits, size of BitSet
 *  n: expected insertions
 *  b: m/n, bits per insertion
 *  p: expected false positive probability
 *  k: number of hashFunctions
 *
 *  1) Optimal k = b * ln2
 *  2) p = (1 - e ^ (-kn/m))^k
 *  3) For optimal k: p = 2 ^ (-k) ~= 0.6185^b
 *  4) For optimal k: m = -nlnp / ((ln2) ^ 2)
 * </p>
 * Runtime Complexity: O(n * k) for {@code add} where k number of hashFunctions,
 *                     O(k) for {@code mightContain} where k number of hashFunctions.
 * Space Complexity:   O(m) - where m size of BitSet.
 */
public class BloomFilter {

    private BitSet bitSet;
    private Function<String, Integer>[] hashFunctions;
    private int[] hashSeeds;
    private int size;

    public BloomFilter(int size, int numHashFunctions) {
        this.size = size;
        this.bitSet = new BitSet(size);
        this.hashSeeds = generateHashSeeds(numHashFunctions);
        this.hashFunctions = generateHashFunctions(numHashFunctions);
    }

    private int[] generateHashSeeds(int numHashFunctions) {
        int[] seeds = new int[numHashFunctions];

        for (int i = 0; i < numHashFunctions; i++) {
            seeds[i] = 31 * i + 17;
        }

        return seeds;
    }

    private Function<String, Integer>[] generateHashFunctions(int numHashFunctions) {
        Function<String, Integer>[] hashFunctions = new Function[numHashFunctions];

        for (int i = 0; i < numHashFunctions; i++) {
            int seed = hashSeeds[i];

            hashFunctions[i] = str -> {
                int hash = 0;
                for (char c : str.toCharArray()) {
                    hash = (hash * seed + c) % size;
                }
                return hash;
            };
        }

        return hashFunctions;
    }

    public void add(String item) {
        for (Function<String, Integer> hashFunction : hashFunctions) {
            int hash = hashFunction.apply(item);

            bitSet.set(hash);
        }
    }

    public boolean mightContain(String item) {
        for (Function<String, Integer> hashFunction : hashFunctions) {
            int hash = hashFunction.apply(item);

            if (!bitSet.get(hash)) {
                return false;
            }
        }
        return true;
    }
}
