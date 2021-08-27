class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        // 第i天不持有股票的最大收益
        int[] f = new int[n];
        // 第i天持有股票的最大收益
        int[] g = new int[n];
        g[0] = -prices[0];
        for(int i = 1; i < n; i++) {
            f[i] = Math.max(f[i - 1], g[i - 1] + prices[i] - fee);
            g[i] = Math.max(g[i - 1], f[i - 1] - prices[i]);
        }
        return f[n - 1];
    }
}