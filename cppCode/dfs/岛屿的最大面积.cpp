class Solution {
public:
    int dx[4]={-1,0,1,0};
    int dy[4]={0,1,0,-1};
    int mxcnt=0;
    int cnt=0;
    int n;
    int m;
    void dfs(int x, int y, vector<vector<int>>& grid) {
        if(grid[x][y]==0)
            return;
        if(grid[x][y]==1) {
            cnt++;
            mxcnt=max(cnt, mxcnt);
            grid[x][y]=0;
        }
        for(int i=0;i<4;i++) {
            int xx=x+dx[i];
            int yy=y+dy[i];
            if(xx>=0 && xx<n && yy>=0 && yy<m)
                dfs(xx, yy, grid);
        }
        
    }
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        n=grid.size();
        m=grid[0].size();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                cnt=0;
                dfs(i, j, grid);
            }
        }
        return mxcnt;
    }
};