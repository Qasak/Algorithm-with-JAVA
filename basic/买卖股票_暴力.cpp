class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int profit=0;
        int maxProfit=0;
        int n=prices.size();
        for(int i=0;i<n;i++) {
            int buy=prices[i];
            for(int j=i+1;j<n;j++) {
                int sell=prices[j];
                profit=sell-buy;
                if(profit>maxProfit)
                    maxProfit=profit;
            }
        }
        return maxProfit;
    }
};