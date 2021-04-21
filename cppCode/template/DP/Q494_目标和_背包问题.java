package leetcode.template.DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/11 9:42
 */
public class Q494_目标和_背包问题 {
    // dfs暴力 ：2 ^ 20
    int ans;
    public int findTargetSumWays(int[] nums, int S) {
        ans = 0;
        dfs(nums, 0, S);
        return ans;
    }
    public void dfs(int[] nums, int i, int cur) {
        if(i == nums.length) {
            if(cur == 0) {
                ans++;
            }
            return;
        }
        dfs(nums, i + 1, cur + nums[i]);
        dfs(nums, i + 1, cur - nums[i]);
    }
}
