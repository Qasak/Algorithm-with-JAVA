package leetcode.template.Greedy;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/8 23:30
 */
public class Q55_跳跃游戏 {
    // 1. dp : n ^ 2
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n - 1] = true;
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i; j < n && j <= i + nums[i]; j++) {
                if(dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
    // 2. 贪心 n
    public boolean canJump1(int[] nums) {
        int n = nums.length;
        int r = nums[0];
        for(int i = 0; i < n; i++) {
            if(i > r) {
                return false;
            }
            r = Math.max(r, i + nums[i]);
            if(r >= n - 1) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.deleteCharAt(1);
    }
}
