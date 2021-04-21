class Solution {
private:
    int dx[4]={-1,0,1,0};
    int dy[4]={0,1,0,-1};
    int n;
    int m;
public:
    int numIslands(vector<vector<char>>& grid) {
        int cnt=0;
        n=grid.size();
        if(!n) return 0;
        m=grid[0].size();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m;j++) {
                if(grid[i][j]=='1') {
                    dfs(i, j, grid);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    void dfs(int x, int y, vector<vector<char>>& grid) {
        if(grid[x][y]=='0')
            return;
        grid[x][y]='0';
        for(int i=0;i<4;i++) {
            int xx=x+dx[i];
            int yy=y+dy[i];
            if(xx>=0 && xx<n && yy>=0 && yy<m)
                dfs(xx,yy,grid);
        }
    }
};