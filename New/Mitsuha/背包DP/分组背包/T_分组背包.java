class Solution {
    public int maxValue(int N, int C, int[] S, int[][] v, int[][] w) {
        int[][] dp = new int[N + 1][C + 1];
        for (int i = 1; i <= N; i++) {
            int[] vi = v[i - 1];
            int[] wi = w[i - 1];
            int si = S[i - 1];
            for (int j = 1; j <= C; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int k = 0; k < si; k++) {
                    if (j >= vi[k]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - vi[k]] + wi[k]);
                    }
                }
            }
        }
        return dp[N][C];
    }
}