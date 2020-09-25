class Solution {
public:
    const int MAX=0x3f3f3f3f;
    int minCost(int n, vector<int>& cuts) {
        sort(cuts.begin(), cuts.end());
        cuts.insert(cuts.begin(), 0);
        cuts.push_back(n);
        vector<vector<int>> dp(cuts.size(), vector<int>(cuts.size(),MAX));
        for (int i = 0; i < cuts.size() - 1; ++i) {
            dp[i][i+1] = 0;
        }
        return dfs(0, cuts.size() - 1, dp, cuts);
    }
    int dfs(int i, int j, vector<vector<int>>& dp, vector<int>& cuts) {
        if (dp[i][j] < MAX)  return dp[i][j];
        for (int k = i+1; k < j; ++k) {
            dp[i][j] = min (dp[i][j], dfs(i, k, dp, cuts) + dfs (k , j, dp, cuts) + cuts[j] - cuts[i]);
        }    
        return dp[i][j];
    }
    
};

class Solution {
public:
    int f[103][103];
    int minCost(int n, vector<int>& cuts) {
        cuts.push_back(0);
        cuts.push_back(n);
        sort(cuts.begin(),cuts.end());
        int m=cuts.size();
        for(int i=0;i<m-1;++i) f[i][i+1] = 0;
        for(int len=2;len<m;++len){
            for(int l=0;l+len<m;++l){
                int r = l+len;
                f[l][r]=INT_MAX;
                for(int p=l+1;p<r;++p){
                    f[l][r]=min(f[l][r],f[l][p]+f[p][r]);
                }
                f[l][r]+=cuts[r]-cuts[l];
            }
        }
        return f[0][m-1];
    }
};