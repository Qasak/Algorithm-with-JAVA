package leetcode.template.Window;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/11 23:31
 */
public class Q713_SubProd {
    // 暴力O n^3
    public int numSubarrayProductLessThanK(int[] nums, int kk) {
        int n = nums.length;
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                long p = 1;
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
    // 对 nums 数组取对数，将乘法转换为加法
    // 双指针滑动窗口
    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        int n = nums.length;
        // 正整数数组
        // 小于 k
        if(k <= 1 || n == 0) {
            return 0;
        }
        int prod = 1, l = 0, ans = 0;
        for(int r = 0; r < n; r++) {
            prod *= nums[r];
            while(prod >= k) {
                prod /= nums[l++];
            }
            ans += r - l + 1;
        }
        return ans;
    }
}
