package org.hac.core;

import java.util.HashMap;
import java.util.Map;

public class Threads {
    private static final Map<String, Thread> threadMap = new HashMap<>();

    public static void add(String key, Thread t) {
        threadMap.put(key, t);
    }

    public static void start(String key) {
        threadMap.get(key).start();
    }

    public static void stopAll() {
        System.exit(0);
    }
}
