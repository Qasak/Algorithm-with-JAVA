class Solution {
public:
    
    int minimumTotal(vector<vector<int>>& triangle) {
        int n=triangle.size();
        if(!n) return 0;
        dp.resize(n*n);
        return dfs(1,0,0,n,triangle);
    }
private:
    vector<int> dp;
    int mx=0;
    int dfs(int l, int i, int j, int n, vector<vector<int>>& triangle) {
        if(l>n) return 0;
        int idx=i*(i+1)/2+j;
        if(dp[idx]!=0) return dp[idx];
        return dp[idx]=triangle[i][j]+min(dfs(l+1,i+1,j,n, triangle), dfs(l+1,i+1,j+1,n, triangle));
    }
};