package leetcode.contest.NiceProblem.数据结构API技巧;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/13 10:29
 */
public class Q218_天际线问题 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        // 扫描线法
        // 当高度变化时加入答案列表
        // 按x顺序从小到大排序
        List<List<Integer>> ans = new ArrayList<>();
        // x相同时按height从小到大
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (
                a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
        ));

        // 高度 : 数量
        // 左端点加入，右端点出
        // 保留当前最大高度
        TreeMap<Integer, Integer> map = new TreeMap<>((a, b) -> b - a);
        map.put(0, 1);
        for(int[] t : buildings) {
            pq.offer(new int[]{t[0], -t[2]});
            pq.offer(new int[]{t[1], t[2]});
        }
        int cur = 0;
        while(!pq.isEmpty()) {
            int[] t = pq.poll();
            if(t[1] < 0) {
                map.put(-t[1], map.getOrDefault(-t[1], 0) + 1);
            } else {
                map.put(t[1], map.getOrDefault(t[1], 0) - 1);
                if(map.get(t[1]) == 0) {
                    map.remove(t[1]);
                }
            }
            int curMax = map.keySet().iterator().next();
            if(cur != curMax) {
                cur = curMax;
                List<Integer> list = new ArrayList<>();
                list.add(t[0]);
                list.add(curMax);
                ans.add(list);
            }
        }
        return ans;
    }
}
