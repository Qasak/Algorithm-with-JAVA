package leetcode.NiceProblem.滑动窗口技巧;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/19 9:33
 */
public class Q1838_最高频元素的频数 {
    // 排序 + 前缀和 + 滑动窗口
    // 把窗口内的元素全部改成右边界元素, 代价==右边界元素 * 窗口长度 - 当前窗口前缀和
    // 若k不能承受代价，则逐个去掉左边界元素

    // 总和10^10, long可以到10^15左右

    // 找最大频数元素t 贪心的问题在于 k可能很大，当前t可能是很小的
    // 如 1,1,1,1,1,2; k = 5
    // 贪心地修改比t小的元素是错误的
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0, r = 0;
        long sum = 0;
        int ans = 0;
        for(; r < n; r++) {
            sum += nums[r];
            while(k < (long)(nums[r] * (r - l + 1)) - sum) {
                sum -= nums[l++];
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
