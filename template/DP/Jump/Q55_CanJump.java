package leetcode.template.DP.Jump;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/21 10:23
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class Q55_CanJump {
    // 贪心
    public boolean canJump(int[] nums) {
        int maxR = nums[0];
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int r = i + nums[i];
            maxR = Math.max(maxR, r);
            if(maxR >= n - 1) {
                return true;
            }
            // 跳不动了
            if(maxR == i) {
                break;
            }
        }
        return false;
    }
    // DP
    public boolean canJump1(int[] nums) {
        //dp[i] : 从0出发是否可到达下标i
        // dp[i] = dp[j] && j + nums[j] >= i ? (0 <= j < i)
        //
        // [2,3,1,1,4]
        // [3,2,1,0,4]
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for(int i = 1; i < n; i++) {
            for(int j = i - 1; j >= 0; j--) {
                dp[i] = dp[j] && j + nums[j] >= i;
                if(dp[i]) {
                    break;
                }
            }
        }
        return dp[n - 1];
    }
}
