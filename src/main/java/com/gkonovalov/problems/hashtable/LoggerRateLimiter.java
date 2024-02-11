package com.gkonovalov.problems.hashtable;


import java.util.*;

/**
 * Created by Georgiy Konovalov on 24/07/2023.
 * <p>
 *
 * @see <a href="https://leetcode.com/problems/logger-rate-limiter/">
 *          [Easy][359] - Logger Rate Limiter
 *      </a>
 * </p>
 * Runtime Complexity: O(1) for {@code Logger}.
 * Space Complexity:   O(n) for {@code Logger}.
 */
public class LoggerRateLimiter {

    public static void main(String[] args){
        Logger logger = new Logger();

        System.out.println(logger.shouldPrintMessage(1, "key"));
        System.out.println(logger.shouldPrintMessage(2, "key"));
        System.out.println(logger.shouldPrintMessage(3, "key"));
        System.out.println(logger.shouldPrintMessage(11, "key"));
    }

    static class Logger {

        private Map<String, Integer> cache;

        public Logger() {
            this.cache = new HashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            if (cache.containsKey(message) && timestamp < cache.get(message)) {
                return false;
            } else {
                cache.put(message, timestamp + 10);
                return true;
            }
        }
    }

    class LoggerQueue {

        private Queue<String> queue;
        private LinkedHashMap<String, Integer> cache;

        public LoggerQueue() {
            this.queue = new LinkedList<>();
            this.cache = new LinkedHashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            while (!queue.isEmpty() && timestamp >= cache.get(queue.peek())) {
                cache.remove(queue.poll());
            }

            if (!cache.containsKey(message)) {
                queue.add(message);
                cache.put(message, timestamp  + 10);
                return true;
            } else {
                return false;
            }
        }
    }

    static class LoggerHashMapScale {

        private LinkedHashMap<String, Integer> cache;

        public LoggerHashMapScale() {
            this.cache = new LinkedHashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            cleanUpCache(timestamp);

            if (cache.containsKey(message) && timestamp < cache.get(message)) {
                return false;
            } else {
                cache.put(message, timestamp + 10);
                return true;
            }
        }

        private void cleanUpCache(int timestamp){
            Iterator<Map.Entry<String, Integer>> iterator = cache.entrySet().iterator();

            while (iterator.hasNext()) {
                if (timestamp >= iterator.next().getValue()) {
                    iterator.remove();
                } else {
                    break;
                }
            }
        }
    }
}
