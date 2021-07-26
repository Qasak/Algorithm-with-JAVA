package leetcode.contest.Rating2300.贪心;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/26 11:06
 */
public class Q300_最长递增子序列 {
    // dp n^2
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // f[i]以i结尾的子数组的最长上升子序列长度
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for(int i = 1; i < n; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(nums[i] > nums[j]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        return Arrays.stream(f).max().getAsInt();
    }



    // 贪心 + 二分 n log n
    public int lengthOfLIS1(int[] nums) {
        int n = nums.length;
        // f[len] : 长度为len的上升子序列的末尾元素
        int[] f = new int[n + 1];
        int len = 1;
        f[len] = nums[0];
        for(int i = 1; i < n; i++) {
            if(nums[i] > f[len]) {
                f[++len] = nums[i];
            } else {
                 // 找到第一个小于idx的位置l
                int l = 0, r = len;
                while(l < r) {
                    int m = (l + r + 1) >>> 1;
                    if(f[m] >= nums[i]) {
                        r = m - 1;
                    } else {
                        l = m;
                    }
                }
                f[l + 1] = nums[i];
            }
        }
        return len;
    }
}
