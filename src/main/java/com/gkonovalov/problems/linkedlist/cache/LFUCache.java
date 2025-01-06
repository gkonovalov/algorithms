package com.gkonovalov.problems.linkedlist.cache;

import java.util.LinkedHashMap;
import java.util.PriorityQueue;

/**
 * Created by Georgiy Konovalov on 5/01/2024.
 * <p>
 * @see <a href="https://leetcode.com/problems/lfu-cache/">
 *         [Hard][460] - LFU Cache
 *      </a>
 * </p>
 * Runtime Complexity: O(1) for {@code put} and {@code get}.
 * Space Complexity:   O(n) for {@code LFUCacheHashMap} where n = capacity.
 */
public class LFUCache {

    public static void main(String[] args) {
        LFUCachePQ cache = new LFUCachePQ(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    static class LFUCachePQ {
        private int capacity = 0;
        private int time = 0;

        private LinkedHashMap<Integer, QueueItem> keyToItem;
        private PriorityQueue<QueueItem> frequency;

        public LFUCachePQ(int capacity) {
            this.capacity = capacity;
            this.keyToItem = new LinkedHashMap<>();
            this.frequency = new PriorityQueue<>((o1, o2) -> {
                if (o1.count == o2.count) {
                    return o1.time - o2.time;
                } else {
                    return o1.count - o2.count;
                }
            });
        }

        public int get(int key) {
            time++;
            QueueItem item = keyToItem.get(key);

            if (item != null) {
                updateFrequency(item.key, item.value);
                return item.value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (capacity <= 0) {
                return;
            }

            time++;
            if (!keyToItem.containsKey(key) && keyToItem.size() >= capacity) {
                QueueItem item = frequency.poll();
                if (item != null) {
                    keyToItem.remove(item.key);
                }
            }

            updateFrequency(key, value);
        }

        private void updateFrequency(int key, int value) {
            if (keyToItem.containsKey(key)) {
                QueueItem old = keyToItem.get(key);
                QueueItem newItem = new QueueItem(key, value, old.count + 1, time);

                frequency.remove(old);
                frequency.add(newItem);
                keyToItem.put(key, newItem);
            } else {
                QueueItem item = new QueueItem(key, value, 1, time);
                keyToItem.put(key, item);
                frequency.add(item);
            }
        }

        class QueueItem {
            private final int key;
            private final int value;
            private final int count;
            private final int time;

            public QueueItem(int key, int value, int count, int time) {
                this.key = key;
                this.count = count;
                this.value = value;
                this.time = time;
            }

            @Override
            public boolean equals(Object o) {
                return key == ((QueueItem) o).key;
            }

            @Override
            public int hashCode() {
                return key;
            }
        }
    }

}
