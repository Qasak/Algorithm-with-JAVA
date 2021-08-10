package leetcode.NiceProblem.DP技巧.map数组DP;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/10 13:42
 */
public class Q446_等差数组划分2_子序列 {
    public static int numberOfArithmeticSlices(int[] nums) {
        // [7,7,7,7,7]
        //  0 1 3 7
        // 1 + (1 + 3) + (1 + 3 + 7)
        int n = nums.length;
        if(n < 3) {
            return 0;
        }
        int ans = 0;
        // f[i] [d]: 第i个元素公差为d的子序列长度
        Map<Integer, Integer>[] f = new Map[n];
        for(int i = 0; i < n; i++) {
            f[i] = new HashMap<Integer, Integer>();

            //map // d : 最大长度
            for(int j = i - 1; j >= 0; j--) {
                long d = (long)nums[i] - (long)nums[j];
                if(d < Integer.MIN_VALUE || d > Integer.MAX_VALUE) {
                    continue;
                }
                int dd = (int) d;
                int pre = f[j].getOrDefault(dd, 0);
                int cur = f[i].getOrDefault(dd, 0);
                ans += pre;
                f[i].put(dd, pre + cur + 1);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
//        int[] nums = new int[]{1,14,34,8,13,6,9,12,2,3};
//        int[] nums = new int[]{2,4,6,8,10};
//        int[] nums = new int[]{7,7,7,7,7};
        int[] nums = new int[]{1,2,3,3,3};

        System.out.println(numberOfArithmeticSlices(nums));

    }
}
