class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int max_len=0;
        int ans=0;
        int n=matrix.size();
        if(!n) return 0;
        int m=matrix[0].size();
        vector<vector<int>> dp(n, vector<int>(m));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j]=='0') {
                    dp[i][j]=0;
                } else {
                    if(i==0||j==0) {
                        dp[i][j]=1;
                    } else {
                        dp[i][j]=min(min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1])+1;
                    }
                    max_len=max(max_len, dp[i][j]);
                }
            }
        }
        ans=max_len*max_len;
        return ans;
    }
};