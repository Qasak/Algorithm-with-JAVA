class Solution {
public:
    int dp[1001][1001];
    int minPathSum(vector<vector<int>>& grid) {
        int n=grid.size();
        int m=grid[0].size();
        if(!m||!n) return 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(i==0 && j==0) 
                    dp[i][j]=grid[i][j];
                else if(i==0)
                    dp[i][j]=grid[i][j]+dp[i][j-1];
                else if(j==0)
                    dp[i][j]=grid[i][j]+dp[i-1][j];
                else
                    dp[i][j]=grid[i][j]+min(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[n-1][m-1];
    }
};