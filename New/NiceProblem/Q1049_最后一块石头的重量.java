package leetcode.contest.NiceProblem;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/8 0:06
 */
public class Q1049_最后一块石头的重量 {
    public int lastStoneWeightII(int[] stones) {
        // (sum - neg) - neg = diff
        // 要使diff最小，就要使得neg <= sum / 2的前提下 最大
        int sum = Arrays.stream(stones).sum();
        int n = stones.length;
        int neg = sum / 2;
        // f[i][j] : 前i个石头是否可以凑成容量j
        boolean [] f = new boolean[neg + 1];
        f[0] = true;
        for(int i = 0; i < n; i++) {
            for(int j = neg; j >= 0; j--) {
                if(j >= stones[i]) {
                    f[j] = f[j] | f[j - stones[i]];
                } else {
                    f[j] = f[j];
                }
            }
        }

        for(int i = neg; i >= 0; i--) {
            if(f[i]) {
                return sum - 2 * i;
            }
        }
        return -1;
    }
}
