package leetcode.template.SubArray;

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
}
