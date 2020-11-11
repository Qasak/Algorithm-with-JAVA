// 买卖该股票一次
// 求出差分数组后，方法同求连续子数组的最大和
// dp[i]表示以i结尾的数组的最大和是多少
// dp[i] = dp[i - 1] > 0 ? dp[i - 1] + dp[i] : dp[i]
// 若dp[i-1] <= 0 , 说明dp[i - 1]对dp[i]产生负(零)贡献，即dp[i - 1] + nums[i] 还不如nums[i]本身大
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) {
            return 0;
        }
        int[] diff = new int[prices.length - 1];
        for(int i = 1; i < prices.length; i++) {
            diff[i - 1] = prices[i] - prices[i - 1];
        }
        int sum = diff[0];
        for(int i = 1; i < diff.length; i++) {
            diff[i] = diff[i - 1] > 0 ? diff[i - 1] + diff[i] : diff[i];
            sum = Math.max(diff[i], sum);
        }
        if(sum < 0) {
            return 0;
        }
        return sum;
    }
}