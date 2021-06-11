package leetcode.contest.NiceProblem;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/10 17:44
 */
public class Q565_数组嵌套 {
    int[] memo;
    boolean[] vis;
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        vis = new boolean[n];
        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, dfs(nums, i, 0));
        }
        return max;
    }
    private int dfs(int[] nums, int i, int cur) {
        if(memo[i] != 0) {
            return memo[i];
        }
        if(vis[i]) {
            memo[i] = cur;
            return cur;
        }
        vis[i] = true;
        memo[i] = dfs(nums, nums[i], cur + 1);
        return memo[i];
    }
}
