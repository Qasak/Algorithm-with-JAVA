package leetcode.template.Window;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/11 23:31
 */
public class Q713_SubProd {
    // 乘积单调递增
    // 暴力O n^3 ：超过大小
    public int numSubarrayProductLessThanK(int[] nums, int kk) {
        int n = nums.length;
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                long p = 1;
                // 包含 j - i + 1个子集
                for(int k = i; k <= j; k++) {
                    p *= nums[k];
                }
                if(p < kk) {
                    cnt++;
                }
                if(p > Integer.MAX_VALUE){
                    System.out.println(p);

                }

            }
        }
        return cnt;
    }
    // 二分
    // 0 < nums.length <= 50000
    // 0 < nums[i] < 1000
    // 直接乘法最大为 1000 ^ 50000
    // 对 nums 数组取对数，将乘法转换为加法
    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        // pre[j + 1] - pre[i] == k
        //
        if(k == 0) {
            return 0;
        }
        int n = nums.length;
        double kk = Math.log(k);
        double[] pre = new double[n + 1];
        int ans = 0;
        for(int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + Math.log(nums[i]);
        }
        for(int i = 0; i < n + 1; i++) {
            int l = i + 1, r = n + 1;
            while(l < r) {
                int m = (l + r) >>> 1;
                if(pre[m] < pre[i] + kk - 1e-9) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            ans += l - i - 1;
        }
        return ans;
    }





    // 双指针滑动窗口
    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        // 正整数数组 nums。
        int n = nums.length;
        int ans = 0;
        int prod = 1;
        int l = 0;
        for(int i = 0; i < n; i++) {
            prod *= nums[i];
            while(l <= i && prod >= k) {
                prod /= nums[l++];
            }
            ans += i - l + 1;
        }
        return ans;
    }
}
