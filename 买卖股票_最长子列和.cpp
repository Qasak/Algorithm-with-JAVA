class Solution {
public:
    int maxProfit(vector<int>& prices) {
        
        int profit=0;
        int maxProfit=0;
        int n=prices.size();
        if(!n) return maxProfit;
        int diff[n];
        for(int i=0;i<n-1;i++) {
            diff[i]=prices[i+1]-prices[i];
        }
        for(int i=0;i<n-1;i++) {
            profit=max(diff[i], profit+diff[i]);
            if(profit>maxProfit)
                maxProfit=profit;
        }
        return maxProfit;
    }
};