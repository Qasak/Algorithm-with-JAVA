package leetcode.template.BinSearch;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/4 17:22
 */

// 给定一个含有 n 个正整数的数组: 这种数组的性质：前缀和单调递增
    // 可以用滑动窗口/二分解决
public class Q209_MinSubArrayLen {
    // 窗口
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        int ans = 0x3f3f3f3f;
        int i = 0, j = 0;
        int sum = 0;
        while(j < n) {
            sum += nums[j];
            while(sum >= s) {
                ans = Math.min(ans, j - i + 1);
                sum -= nums[i++];
            }
            j++;
        }
        // 2,3,1,2,4,3
        // 正整数
        // 1,9,1,1 s = 9

        return ans == 0x3f3f3f3f ? 0 : ans;
    }
    // 窗口2
    public int minSubArrayLen1(int s, int[] nums) {
        //
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int l = 0, sum = 0;
        int ans = Integer.MAX_VALUE;
        for(int r = 0; r < n; r++) {
            sum += nums[r];
            while(sum >= s) {
                ans = Math.min(ans, r - l + 1);
                sum -= nums[l++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    // 二分
    public int minSubArrayLen2(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        // 为了方便计算，令 size = n + 1
        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
        // 以此类推
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

}
