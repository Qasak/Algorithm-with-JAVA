package leetcode.template.LinkList;

import java.util.LinkedHashMap;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/24 0:27
 */
public class Q146_LinkedHashMap {
    class LRUCache {
        LinkedHashMap<Integer,Integer> map;
        int capacity;
        public LRUCache(int capacity) {
            map = new LinkedHashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if(map.containsKey(key)){
                int value = map.get(key);
                map.remove(key);
                map.put(key,value);
                return value;
            }else{
                return -1;
            }
        }

        public void put(int key, int value) {
            if(map.containsKey(key)){
                map.remove(key);
            }
            while(map.size()>=capacity){
                map.remove(map.entrySet().iterator().next().getKey());
            }
            map.put(key,value);
        }
    }
}
