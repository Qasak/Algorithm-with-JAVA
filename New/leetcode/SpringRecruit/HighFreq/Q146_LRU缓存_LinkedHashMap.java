package leetcode.HighFreq;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/24 21:49
 */
public class Q146_LRU缓存_LinkedHashMap {
    class LRUCache extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        // 这个可不写
        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }
}
