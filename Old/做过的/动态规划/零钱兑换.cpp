class Solution {
public:
    const int MAXN=0x3f3f3f3f;
    vector<int> coins;
    vector<int> dp;
    int dfs(int amount, int n) {
		if(amount<0)
			return -1;
        if(amount==0)
            return 0;
        int &ans=dp[amount];
        if(ans<MAXN)
            return ans;
		int Min=MAXN;
        for(int i=0;i<n;i++) {
			int res=dfs(amount-coins[i], n);
			if(res>=0 && res<Min)
				Min=res+1;

        }
        return ans=Min==MAXN ? -1:Min;
    }
    int coinChange(vector<int>& coins, int amount) {
        
        int n=coins.size();
        this->dp=vector<int>(amount+1, MAXN);
        this->coins=coins;
        return dfs(amount, n);
    }
};