package leetcode.contest.NiceProblem;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/7 23:53
 */
public class Q279_完全平方数 {
    public int numSquares(int n) {
        int max = (int) Math.sqrt(n) + 1;
        int[] nums = new int[max];
        for(int i = 0; i < max; i++) {
            nums[i] = (i + 1) * (i + 1);
        }
        int[] f = new int[n + 1];
        Arrays.fill(f, 0x3f3f3f3f);
        f[0] = 0;
        for(int i = 0; i < max; i++) {
            for(int j = 1; j <= n; j++) {
                if(j >= nums[i]) {
                    f[j] = Math.min(f[j], f[j - nums[i]] + 1);
                }
            }
        }
        return f[n];
    }
}
