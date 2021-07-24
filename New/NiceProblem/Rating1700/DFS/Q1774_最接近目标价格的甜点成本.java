package leetcode.contest.Rating1700.DFS;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/24 15:31
 */
public class Q1774_最接近目标价格的甜点成本 {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        // 每种类型的配料 最多两份
        // 差值：成本
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
        for(int base : baseCosts) {
            int sum = base;
            int diff = Math.abs(sum - target);
            if(sum < target) {
                // [差值，成本]
                int[] tmp = dfs(toppingCosts, 0, sum, target);
                if(tmp[0] <= diff) {
                    if(tmp[0] == diff) {
                        sum = Math.min(sum, tmp[1]);
                    } else {
                        diff = tmp[0];
                        sum = tmp[1];
                    }
                }
            }
            TreeSet<Integer> set = map.getOrDefault(diff, new TreeSet<>());
            set.add(sum);
            map.put(diff, set);
        }
        // System.out.println(map.keySet());
        // System.out.println(map.firstEntry().getValue());
        return map.firstEntry().getValue().first();
    }

    // 加配料后的最小差值
    // [diff, sum]
    private int[] dfs(int[] toppingCosts, int idx, int sum, int target) {
        int diff = Math.abs(sum - target);
        int n = toppingCosts.length;
        if(idx == n || sum >= target) {
            return new int[]{diff, sum};
        }
        int[][] tmp = new int[3][2];
        tmp[0] = dfs(toppingCosts, idx + 1, sum, target);
        tmp[1] = dfs(toppingCosts, idx + 1, sum + toppingCosts[idx], target);
        tmp[2] = dfs(toppingCosts, idx + 1, sum + 2 * toppingCosts[idx], target);

        // 返回三种情况中diff最小的那个
        int[] res = new int[2];
        res[0] = 0x3f3f3f3f;
        res[1] = 0x3f3f3f3f;
        for(int i = 0; i < 3; i++) {
            if(tmp[i][0] <= res[0]) {
                if(tmp[i][0] == res[0]) {
                    if(tmp[i][1] < res[1]) {
                        res = tmp[i];
                    }
                } else {
                    res = tmp[i];
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
        map.firstEntry().getValue().first();
    }
}
