package leetcode.SpringRecruit.Math;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/19 14:06
 */
public class Q_MS_17_19_消失的两个数字 {
    // 暴力
    public int[] missingTwo(int[] nums) {
        int n = 2 + nums.length;
        int[] ans = new int[2];
        int idx = 0;
        int j = 0;
        Arrays.sort(nums);
        for(int i = 1; i <= n; i++) {
            if(idx == 2) {
                break;
            }
            if((j < nums.length && nums[j] != i) || j >= nums.length) {
                ans[idx++] = i;
                continue;
            }
            j++;
        }

        return ans;

    }
    // O(n) O(1)
    public int[] missingTwo2(int[] nums) {
        int n = 2 + nums.length;
        // a + b
        int sum = (n + 1) * n / 2;
        int diff = sum - Arrays.stream(nums).sum();
        int limit = diff / 2;
        // sum = a + b + sum(nums)
        // a + ... + | + ... + b
        sum = (limit + 1) * limit / 2;
        for(int i : nums) {
            if(i <= limit) {
                sum -= i;
            }
        }
        return new int[]{sum, diff - sum};
    }

}
