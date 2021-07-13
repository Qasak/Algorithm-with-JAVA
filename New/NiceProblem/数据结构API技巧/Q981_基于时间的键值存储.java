package leetcode.contest.NiceProblem.数据结构API技巧;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/10 16:47
 */
public class Q981_基于时间的键值存储 {
    // "love" :[10, 20]
    Map<String, TreeSet<Integer>> map1 = new HashMap<>();
    // 10 : "low"
    // 20 : "high"
    Map<Integer, String> map2 = new HashMap<>();

    /** Initialize your data structure here. */
    public Q981_基于时间的键值存储() {

    }

    public void set(String key, String value, int timestamp) {
        if(map1.get(key) == null) {
            map1.put(key, new TreeSet<>());
        }
        map1.get(key).add(timestamp);
        map2.put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if(!map1.containsKey(key)) {
            return "";
        }
        int id = bs(key, timestamp);
        if(id == -1) {
            return "";
        }
        return map2.get(id);
    }
    // timestamp_prev <= timestamp
    private int bs(String key, int timestamp) {
        Integer id = map1.get(key).floor(timestamp);
        if(id == null) {
            return -1;
        }
        return id;
    }
}
