package leetcode.template.DP.StateCompress;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/29 16:49
 */
public class Q1681_MinIncompability {
    // 1 <= k <= nums.length <= 16
    // 整数数组 nums  和一个整数 k 。你需要将这个数组划分到 k 个相同大小的子集中，使得同一个子集里面没有两个相同的元素。
    // 一个子集的 不兼容性 是该子集里面最大值和最小值的差。
    // 返回将数组分成 k 个子集后，各子集 不兼容性 的 和 的 最小值 ，如果无法分成分成 k 个子集，返回 -1 。
    public int minimumIncompatibility(int[] nums, int k) {
        int n = nums.length;
        int m = n / k;
        int[] value = new int[(1 << n)];
        int[] dp = new int[(1 << n)];
        Arrays.fill(value, -1);
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int sub = 0; sub < (1 << n); sub++) {
            if(Integer.bitCount(sub) == m) {
                TreeSet<Integer> t = new TreeSet<>();
                for(int i = 0; i < n; i++) {
                    // 1001
                    if(((sub >> i) & 1) == 1) {
                        t.add(nums[i]);
                    }
                }
                if(t.size() < m) {
                    continue;
                }
                value[sub] = t.last() - t.first();
            }
        }
        // 1111
        // = 1100 + 0011
        // = 1001 + 0110
        //

        for(int mask = 1; mask < (1 << n); mask++) {
            if((Integer.bitCount(mask) % m) == 0) {
                // mask = 0011
                // 0010
                // 0001

                // 1100
                // 1011 -> 1000
                // 0111 -> 0100
                // 0011 -> 0000
                //
                // 不要空集

                // m = 3
                // 111000
                // 110000   101111
                // 101000   100111
                // 100000   011111
                // 011000   010111
                // 010000   001111
                // 001000   000111
                // 000000
                // [0, 7]
                // 枚举子集
                //        // 111111
                //        // = 111100 + 000011
                //        // = 110011 + 001100
                //        // = 001111 + 110000
                for(int sub = mask; sub > 0; sub = (sub - 1) & mask) {
                    if(value[sub] != -1 && dp[mask ^ sub] != -1) {
                        if(dp[mask] == -1) {
                            dp[mask] = dp[mask ^ sub] + value[sub];
                        } else {
                            dp[mask] = Math.min(dp[mask], dp[mask ^ sub] + value[sub]);
                        }
                    }
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}
