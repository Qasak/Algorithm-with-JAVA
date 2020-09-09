class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if(prices.empty()) 
            return 0;
        int n=prices.size();
        int profit=0;
        int max_profit=0;

        int diff[n];
        for(int i=0;i<n-1;i++) {
            diff[i]=prices[i+1]-prices[i];
        }
        for(int i=0;i<n-1;i++) {
            profit=max(diff[i], profit+diff[i]);
            max_profit=max(profit, max_profit);
        }
        return max_profit;
    }
};