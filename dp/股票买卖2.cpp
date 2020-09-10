class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n=prices.size();
        int mxprofit=0;
        int diff[n];
        for(int i=0;i<n-1;i++) {
            diff[i]=prices[i+1]-prices[i];
        }
        for(int i=0;i<n-1;i++) {
            mxprofit+=max(0,diff[i]);
        }
        return mxprofit;
    }
};