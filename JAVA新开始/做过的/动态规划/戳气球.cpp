class Solution {
public:
    int maxCoins(vector<int>& nums) {
        int n = nums.size();
        vector<vector<int>> dp(n + 2, vector<int>(n + 2));
        vector<int> val(n + 2);
        val[0] = val[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        for (int i = 0; i <= n-1; i++) {
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) 
                    dp[i][j] = max(dp[i][j], val[i] * val[k] * val[j] + dp[i][k] + dp[k][j]);
            }
        }
        return dp[0][n + 1];
    }
};

class Solution {
public:
    int maxCoins(vector<int>& nums) {
        int n = nums.size();
        vector<vector<int>> dp(n + 2, vector<int>(n + 2));
        vector<int> val(n + 2);
        val[0] = val[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        for (int len = 3; len<=n+2; len++) {
            for (int l = 0; l+len-1<=n+1; l++) {
                int r=l+len-1;
                for (int k = r-1; k > l; k--) 
                    dp[l][r] = max(dp[l][r], val[l] * val[k] * val[r] + dp[l][k] + dp[k][r]);
            }
        }
        return dp[0][n+1];
    }
};
 
 