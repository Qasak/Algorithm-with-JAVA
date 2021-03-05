package leetcode.template.DP;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/4 11:55
 */
public class Q354_Envelops_LIS {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, Comparator.comparingInt(a -> a[0]));
        int n = envelopes.length;
        if(n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 1; i < n; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    // 考虑一个简单的贪心，如果我们要使上升子序列尽可能的长，则我们需要让序列上升得尽可能慢，因此我们希望每次在上升子序列最后加上的那个数尽可能的小。
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] d = new int[n + 1];
        int len = 1;
        d[1] = nums[0];
        for(int i = 1; i < n; i++) {
            if(nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                d[lowerBound(d, nums[i], len)] = nums[i];
            }
        }
        return len;
    }
    public int lowerBound(int[] d, int target, int len) {
        int l = 1, r = len;
        while(l < r) {
            int m = (l + r) >>> 1;
            if(d[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

}
