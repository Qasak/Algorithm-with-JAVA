package leetcode.SpringRecruit.Divide;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/30 9:20
 */
public class Q218_天际线问题 {
    // 1. 扫描线法
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        for(int[] t : buildings) {
            pq.offer(new int[]{t[0], -t[2]});
            pq.offer(new int[]{t[1], t[2]});
        }
        TreeMap<Integer, Integer> heights = new TreeMap<>((a, b) -> (b - a));
        heights.put(0, 1);
        int cur = 0;
        while(!pq.isEmpty()) {
            int[] t = pq.poll();
            if(t[1] < 0) {
                heights.put(-t[1], heights.getOrDefault(-t[1], 0) + 1);
            } else {
                heights.put(t[1], heights.get(t[1]) - 1);
                if(heights.get(t[1]) == 0) {
                    heights.remove(t[1]);
                }
            }
            int curMax = heights.keySet().iterator().next();
            if(curMax != cur) {
                cur = curMax;
                List<Integer> l = new ArrayList<>();
                l.add(t[0]);
                l.add(cur);
                ans.add(l);
            }
        }
        return ans;
    }
    // 2. 分治

    public static void main(String[] args) {
        TreeMap<Integer, Integer> heights = new TreeMap<>((a, b) -> (b - a));
        heights.keySet().iterator().next();
    }
}
