package Mitsuha.状态机DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/18 16:23
 */
public class Q552_学生出勤记录II {
    // 记忆化 / 状态机DP
    int mod = (int) 1e9 + 7;
    public int checkRecord(int n) {
        // f[i][A][L]
        int[][][] f = new int[n][2][3];
        f[0][1][0] = 1;
        f[0][0][1] = 1;
        f[0][0][0] = 1;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 2; j++) {
                for(int k = 0; k < 3; k++) {
                    // A + L不连续情况
                    if(k == 0 && j == 1) {
                        f[i][j][k] = (f[i][j][k] + f[i - 1][j - 1][0]) % mod;
                        f[i][j][k] = (f[i][j][k] + f[i - 1][j - 1][1]) % mod;
                        f[i][j][k] = (f[i][j][k] + f[i - 1][j - 1][2]) % mod;
                    }

                    // L
                    // L连续情况
                    if(k != 0) {
                        f[i][j][k] = (f[i][j][k] + f[i - 1][j][k - 1]) % mod;
                    }
                    // P + L不连续情况
                    if(k == 0) {
                        f[i][j][k] = (f[i][j][k] + f[i - 1][j][0]) % mod;
                        f[i][j][k] = (f[i][j][k] + f[i - 1][j][1]) % mod;
                        f[i][j][k] = (f[i][j][k] + f[i - 1][j][2]) % mod;
                    }
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 3; j++) {
                ans += f[n - 1][i][j];
                ans %= mod;
            }
        }
        return ans;
    }
}
