package leetcode.contest.Rating1500;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/25 15:57
 */
public class Q1743_从相邻元素还原数组 {
    public int[] restoreArray(int[][] adjacentPairs) {
        // -2 4 // 1 4 // -3 1
        int n = adjacentPairs.length + 1;
        int[] ans = new int[n];
        // -2 4 1 -3

        // 元素： 邻接元素
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] pair: adjacentPairs) {
            int a = pair[0], b = pair[1];
            map.putIfAbsent(a, new ArrayList<>());
            map.putIfAbsent(b, new ArrayList<>());
            map.get(a).add(b);
            map.get(b).add(a);
        }
        // 起点，终点
        int[] bound = new int[2];
        int idx = 0;
        for(int k : map.keySet()) {
            if(map.get(k).size() == 1) {
                bound[idx++] = k;
            }
        }
        int i = 0;
        ans[i++] = bound[0];
        Deque<Integer> q = new LinkedList<>();
        q.offer(bound[0]);
        Set<Integer> set = new HashSet<>();
        set.add(bound[0]);
        while(!q.isEmpty()) {
            int cur = q.poll();
            List<Integer> list = map.get(cur);
            if(!set.contains(list.get(0))) {
                ans[i++] = list.get(0);
                q.offer(list.get(0));
                set.add(list.get(0));
            }

            if(list.size() > 1 && !set.contains(list.get(1))) {
                ans[i++] = list.get(1);
                q.offer(list.get(1));
                set.add(list.get(1));

            }
        }
        return ans;
    }
}
