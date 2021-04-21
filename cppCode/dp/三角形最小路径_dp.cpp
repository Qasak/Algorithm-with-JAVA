class Solution {
public:
    vector<vector<int>> dp;
    int minimumTotal(vector<vector<int>>& triangle) {
        int n=triangle.size();
        if(!n) return 0;
        dp.resize(n, vector<int>(n));
        for(int i=0;i<n;i++) 
            dp[n-1][i]=triangle[n-1][i];
        for(int i=n-2;i>=0;i--) {
            for(int j=0;j<=i;j++)
                dp[i][j]=triangle[i][j]+min(dp[i+1][j], dp[i+1][j+1]);
        }
        return dp[0][0];
    }
};



// 空间优化

class Solution {
public:
    vector<int> dp;
    int minimumTotal(vector<vector<int>>& triangle) {
        int n=triangle.size();
        if(!n) return 0;
        dp.resize(n);
        for(int i=0;i<n;i++) 
            dp[i]=triangle[n-1][i];
        for(int i=n-2;i>=0;i--) {
            for(int j=0;j<=i;j++)
                dp[j]=triangle[i][j]+min(dp[j], dp[j+1]);
        }
        return dp[0]; 
    }
};