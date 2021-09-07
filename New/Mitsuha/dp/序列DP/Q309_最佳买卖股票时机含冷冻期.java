class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 1) {
            return 0;
        }
        // 不持有的最大收益
        int[] f = new int[n];
        // 持有的最大收益
        int[] g = new int[n];
        g[0] = -prices[0];
        f[1] = Math.max(0, g[0] + prices[1]);
        g[1] = Math.max(g[0], -prices[1]);
        for(int i = 2; i < n; i++) {
            f[i] = Math.max(f[i - 1], g[i - 1] + prices[i]);
            g[i] = Math.max(g[i - 1], f[i - 2] - prices[i]);
        }
        return f[n - 1];
    }
}