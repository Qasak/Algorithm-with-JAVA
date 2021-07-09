package leetcode.contest.Week_236;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/9 16:29
 */
public class Q1829_每个查询的最大异或值 {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] pre = new int[n];
        pre[0] = nums[0];
        for(int i = 0; i < n - 1; i++) {
            pre[i + 1] = pre[i] ^ nums[i + 1];
        }
        for(int i = 0; i < n; i++) {
            ans[i] = ((1 << maximumBit) - 1) ^(pre[n - i - 1]);
        }
        return ans;
    }
}
