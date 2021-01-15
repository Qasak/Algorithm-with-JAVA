package leetcode.template.DP.Array;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/13 23:27
 */
public class Q376_WiggleArr {

    // 1 前缀差 + 贪心
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        int[] pre = new int[n];
        for(int i = 0; i < n - 1; i++) {
            pre[i] = nums[i + 1] - nums[i];
        }
        // + - + -
        // - + - + -
        // - - - + - + + - - -

        int i = 0;
        int cnt = (nums[0] == 0 ? -1 : 0);
        while(i < n - 1) {
            if(pre[i] > 0) {
                i++;
                while(i < n - 1 && pre[i] >= 0) {
                    i++;
                }
                cnt += i == n - 1 ? 0 : 1;
            } else if(pre[i] < 0) {
                i++;
                while(i < n - 1 && pre[i] <= 0) {
                    i++;
                }
                cnt += i == n - 1 ? 0 : 1;
            } else {
                i++;
            }
        }
        return cnt + 2;
    }
    // 贪心2
    public int wiggleMaxLength4(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int prevdiff = nums[1] - nums[0];
        int ret = prevdiff != 0 ? 2 : 1;
        for (int i = 2; i < n; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
                ret++;
                prevdiff = diff;
            }
        }
        return ret;
    }

    // dp
    public int wiggleMaxLength1(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        int[] up = new int[n];
        int[] down = new int[n];
        Arrays.fill(up, 1);
        Arrays.fill(down, 1);

        int len = 1;
        for(int i = 1; i < n; i++) {
            if(nums[i] > nums[i - 1]) {
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
            } else if(nums[i] < nums[i - 1]) {
                down[i] = Math.max(down[i - 1], up[i - 1] + 1);
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
            len = Math.max(len, Math.max(up[i], down[i]));
        }
        return len;
    }
    // dp 空间优化
    public int wiggleMaxLength2(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int up = 1;
        int down = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            }
            if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
}
