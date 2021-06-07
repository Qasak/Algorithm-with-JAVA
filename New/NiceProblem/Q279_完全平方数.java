package leetcode.contest.NiceProblem;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/7 23:53
 */
public class Q279_完全平方数 {
    public int numSquares(int n) {
        // 完全平方数最少为1个，1个时为最大
        int m = (int) Math.sqrt(n);
        int[] tmp = new int[m + 1];
        for(int i = 1; i <= m; i++) {
            tmp[i] = i * i;
        }

        // 完全背包
        // f[i] : 和为正整数i时 最少的完全平方数个数
        int[] f = new int[n + 1];
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 0;
        for(int i = 1; i <= n; i++) {
            // 扫每一个可用平方数取最小
            for(int j = 1; j <= m; j++) {
                if(i < tmp[j]) {
                    break;
                }
                f[i] = Math.min(f[i], f[i - tmp[j]] + 1);
            }
        }
        return f[n];
    }
}
