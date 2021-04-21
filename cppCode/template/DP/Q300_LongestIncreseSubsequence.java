package leetcode.template.DP;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/10 11:56
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 */
public class Q300_LongestIncreseSubsequence {
    /**
     *
     * [0, ..., i] 的范围内，选择以数字 nums[i] 结尾可以获得的最长上升子序列的长度。
     * nums[i] 结尾，是子序列动态规划问题的经典设计状态思路
     *
     * */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 1;
        // dp[i] 表示以 nums[i] 结尾的最长上升子序列的长度
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        return ans;
    }
    // 贪心+二分
    //  [10,9,2,5,3,7,101,18]
    // d[i]：长度为i的最长上市子序列末尾元素的最小值
    /**
     * 0, d=[0]
     * 10, d=[0, 10]
     * 9, d=[0, 9]
     * 2, d = [0, 2]
     * 5, d = [0, 2, 5]
     * 3, d = [0, 2, 3]
     * 7, d = [0,2,3,7]
     * 101, d = [0,2,3,7,101]
     * 18, d=[0,2,3,7,18]
     * */
    public static int lengthOfLIS1(int[] nums) {
        int len = 1, n = nums.length;
        // 最多n个数是上升的
        int[] d = new int[n + 1];
        d[1] = nums[0];
        // O(nlogn)
        for(int i = 1; i < n; i++) {
            System.out.println(Arrays.toString(d));
            if(nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int l = 1, r = len + 1;
                while(l < r) {
                    int mid = l + ((r - l) >> 1);
                    if(d[mid] < nums[i]) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                d[l] = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS1(nums));
    }
}
