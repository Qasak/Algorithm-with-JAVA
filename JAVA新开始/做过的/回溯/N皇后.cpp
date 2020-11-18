class Solution {
public:
    vector<vector<string>> ans;
    bool vis[3][1<<10];
    int N;
    void dfs(vector<string> &table, int i) {
        if(i==N) {ans.push_back(table); return;}
        for(int j=0;j<N;j++) {
            if(!vis[0][j] && !vis[1][i-j+N] && !vis[2][i+j]) {
                table[i][j]='Q';
                vis[0][j]=vis[1][i-j+N]=vis[2][i+j]=true;
                dfs(table, i+1);
                table[i][j]='.';
                vis[0][j]=vis[1][i-j+N]=vis[2][i+j]=false;
            }
        }
    }
    vector<vector<string>> solveNQueens(int n) {
        N=n;
        vector<string> table(n, "");
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                table[i].push_back('.');
            }
        }
        dfs(table, 0);
        return ans;
    }
};