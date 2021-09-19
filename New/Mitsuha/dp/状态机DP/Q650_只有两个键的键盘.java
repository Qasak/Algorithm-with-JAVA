package Mitsuha.状态机DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/9/20 0:01
 */
public class Q650_只有两个键的键盘 {
    class Solution {
        int INF = 0x3f3f3f3f;
        public int minSteps(int n) {
            int[][] f = new int[n + 1][n + 1];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    f[i][j] = INF;
                }
            }
            f[1][0] = 0; f[1][1] = 1;
            for (int i = 2; i <= n; i++) {
                int min = INF;
                for (int j = 0; j <= i / 2; j++) {
                    f[i][j] = f[i - j][j] + 1;
                    min = Math.min(min, f[i][j]);
                }
                f[i][i] = min + 1;
            }
            int ans = INF;
            for (int i = 0; i <= n; i++) ans = Math.min(ans, f[n][i]);
            return ans;
        }
    }
}
