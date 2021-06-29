package leetcode.contest.Week_246;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/29 18:44
 */
public class Q1911_最大子序列交替和 {
    // 交替DP
    public long maxAlternatingSum(int[] nums) {
        long even = nums[0], odd = 0;
        int n = nums.length;
        for(int i = 1; i < n; i++) {
            even = Math.max(even, odd + nums[i]);
            odd = Math.max(odd, even - nums[i]);
        }
        return Math.max(odd, even);
    }
}
