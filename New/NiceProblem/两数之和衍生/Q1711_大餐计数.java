package leetcode.contest.NiceProblem.两数之和衍生;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/7 8:53
 */
public class Q1711_大餐计数 {
    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = deliciousness.length;
        int ans = 0;
        int mod = (int) 1e9 + 7;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 22; j++) {
                if(map.containsKey((1 << j) - deliciousness[i])) {
                    ans += map.get((1 << j) - deliciousness[i]);
                    if(ans >= mod) {
                        ans -= mod;
                    }
                }

            }
            map.put(deliciousness[i], map.getOrDefault(deliciousness[i], 0) + 1);
        }
        return ans;
    }
}
