package leetcode.template.BinSearch;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/22 11:16
 */
public class Q1060 {
    // 线性
    public int missingElement(int[] nums, int k) {
        //       4 5 6 7 8 9 10 11 12 13 ... 10000000
        //       4     7   9 10

        //    1 2 3 4 5 6 7
        //    1 2   4
        int n = nums.length;
        int m = nums[n - 1] - nums[0] + 1 - n;
        if(k > m) {
            return nums[n - 1] + k - m;
        }

        int[] bet = new int[n - 1];
        for(int i = 0; i < n - 1; i++) {
            bet[i] = nums[i + 1] - nums[i] - 1;
        }
        for(int i = 0; i < n - 1; i++) {
            if(k <= bet[i]) {
                return nums[i] + k;
            } else {
                k -= bet[i];
            }
        }
        return 0;
    }
    // 二分
    public int missingElement1(int[] nums, int k) {
        int l = 0, r = nums.length;
        // 截止在idx时缺失的元素数目为 nums[idx] - nums[0] + 1 - (idx + 1)
        // nums[idx] - nums[0] - idx
        while(l < r) {
            int m = (l + r) >>> 1;
            if(help(nums, m) < k) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums[l - 1] + k - help(nums, l - 1);
    }
    private int help(int[] nums, int idx) {
        return nums[idx] - nums[0] - idx;
    }
}
