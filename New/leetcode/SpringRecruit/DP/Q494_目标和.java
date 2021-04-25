package leetcode.SpringRecruit.DP;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/2 11:35
 */
// 1. 不 优化的DFS
class Solution {
    int ans = 0;
    public int findTargetSumWays(int[] nums, int S) {
        dfs(0, nums, S);
        return ans;
    }
    public void dfs(int idx, int[] nums, int cur) {
        // 所有数都要加上，所以在最后结算
        if(idx == nums.length) {
            if(cur == 0) {
                ans++;
            }
            return;
        }
        dfs(idx + 1, nums, cur + nums[idx]);
        dfs(idx + 1, nums, cur - nums[idx]);

    }
}
// 2.记忆化
class Solution2 {
    Map<Pair, Integer> map;
    public int findTargetSumWays(int[] nums, int S) {
        map = new HashMap<>();
        dfs(0, nums, S);
        System.out.println(map);
        return map.get(new Pair(S, 0));
    }
    public int dfs(int idx, int[] nums, int cur) {
        Pair p = new Pair(cur, idx);
        if(map.containsKey(p)) {
            return map.get(p);
        }
        if(idx == nums.length) {
            if(cur == 0) {
                return 1;
            }
            return 0;
        }
        int val = 0;
        val += dfs(idx + 1, nums, cur + nums[idx]);
        val += dfs(idx + 1, nums, cur - nums[idx]);
        map.put(p, val);
        return map.get(p);
    }
}
// 3. DP : 01背包
class Solution3 {
    public int findTargetSumWays(int[] nums, int S) {
        if(S > 1000) {
            return 0;
        }
        int n = nums.length;
        int diff = 1000;
        int[][] dp = new int[n][2001];
        dp[0][nums[0] + diff] = 1;
        dp[0][-nums[0] + diff] += 1;
        for(int i = 1; i < n; i++) {
            for(int j = -1000; j <= 1000; j++) {
                if(dp[i - 1][j + diff] > 0) {
                    dp[i][j + nums[i] + diff] += dp[i - 1][j + diff];
                    dp[i][j - nums[i] + diff] += dp[i - 1][j + diff];
                }
            }
        }
        return dp[n - 1][S + diff];
    }

    // 可以随便开大点
    public int findTargetSumWays1(int[] nums, int S) {
        if(S > 1000) {
            return 0;
        }
        int n = nums.length;
        int diff = 2000;
        int[][] dp = new int[n][9001];
        dp[0][nums[0] + diff] = 1;
        dp[0][-nums[0] + diff] += 1;
        for(int i = 1; i < n; i++) {
            for(int j = -1000; j <= 1000; j++) {
                dp[i][j + nums[i] + diff] += dp[i - 1][j + diff];
                dp[i][j - nums[i] + diff] += dp[i - 1][j + diff];
            }
        }
        return dp[n - 1][S + diff];
    }
}
public class Q494_目标和 {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] nums = new int[]{1,1,1,1,1};
        System.out.println(s.findTargetSumWays(nums, 3));
    }
}
