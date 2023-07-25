package com.gkonovalov.problems.hastable;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Georgiy Konovalov on 24/07/2023.
 * <p>
 *
 * @see <a href="https://leetcode.com/problems/logger-rate-limiter/">
 *          [Easy][359] - Logger Rate Limiter
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code Logger}.
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

        private Map<String, Integer> logs;

        public Logger() {
            this.logs = new HashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            if (logs.containsKey(message) && timestamp < logs.get(message)) {
                return false;
            } else {
                logs.put(message, timestamp + 10);
                return true;
            }
        }
    }
}
