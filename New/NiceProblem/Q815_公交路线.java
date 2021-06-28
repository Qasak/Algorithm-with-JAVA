package leetcode.contest.NiceProblem;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/28 0:18
 */
public class Q815_公交路线 {
    // 朴素BFS
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // 访问过的车站
        Set<Integer> vis = new HashSet<>();
        // 公交车id
        Deque<Integer> q = new LinkedList<>();
        // map : 公交车id: 能到达的所有车站集合
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int idx = 0;
        int step = 0;
        for(int[] bus : routes) {
            Set<Integer> set = new HashSet<>();
            for(int b : bus) {
                set.add(b);
            }
            map.put(idx++, set);
        }
        for(int i = 0; i < routes.length; i++) {
            if(map.get(i).contains(source)) {
                if(target == source) {
                    return step;
                }
                q.offer(i);
            }
        }
        vis.add(source);
        while(!q.isEmpty()) {
            int n = q.size();
            for(int i = 0; i < n; i++) {
                int id = q.poll();
                if(!map.containsKey(id)) {
                    continue;
                }
                Set<Integer> set = map.get(id);
                map.remove(id);
                if(set.contains(target)) {
                    return step + 1;
                }
                for(int stop : set) {
                    if(vis.contains(stop)) {
                        continue;
                    }
                    vis.add(stop);
                    for(int k : map.keySet()) {
                        if(map.get(k).contains(stop)) {
                            q.offer(k);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
