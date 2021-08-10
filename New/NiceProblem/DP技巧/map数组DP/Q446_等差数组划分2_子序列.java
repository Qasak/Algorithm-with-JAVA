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
        int n = nums.length;
        if(n < 3) {
            return 0;
        }
        int ans = 0;
        // f[i] [d]: 第i个元素公差为d的等差子序列个数
        Map<Long, Integer>[] f = new Map[n];
        for(int i = 0; i < n; i++) {
            f[i] = new HashMap<Long, Integer>();
            //map // d : 最大长度
            for(int j = i - 1; j >= 0; j--) {
                long d = (long)nums[i] - (long)nums[j];
                int pre = f[j].getOrDefault(d, 0);
                int cur = f[i].getOrDefault(d, 0);
                ans += pre;
                f[i].put(d, pre + cur + 1);
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
