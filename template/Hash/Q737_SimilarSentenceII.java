package leetcode.template.Hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/18 13:07
 */
public class Q737_SimilarSentenceII {
    int[] parant;
    private int find(int x) {
        if(x == parant[x]) {
            return x;
        }
        return parant[x] = find(parant[x]);
    }
    private void union(int x, int y) {
        parant[find(x)] = find(y);
    }

    public boolean areSentencesSimilarTwo(String[] s1, String[] s2, List<List<String>> p) {
        int n = s1.length;
        int m = s2.length;
        if(n != m) {
            return false;
        }
        Map<String, Integer> map = new HashMap<>();
        int idx = 0;
        for(int i = 0; i < p.size(); i++) {
            map.putIfAbsent(p.get(i).get(0), idx++);
            map.putIfAbsent(p.get(i).get(1), idx++);
        }
        parant = new int[idx];
        for(int i = 0; i < idx; i++) {
            parant[i] = i;
        }
        for(int i = 0; i < p.size(); i++) {
            union(map.get(p.get(i).get(0)), map.get(p.get(i).get(1)));
        }
        for(int i = 0; i < n; i++) {
            if(s1[i].equals(s2[i])) {
                continue;
            }
            if(!map.containsKey(s1[i]) || !map.containsKey(s2[i])) {
                return false;
            }
            if(find(map.get(s1[i])) != find(map.get(s2[i]))) {
                return false;
            }
        }
        return true;
    }
}
