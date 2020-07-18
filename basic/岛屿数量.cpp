class Solution {
private:
    int n;
    int m;
    int grid_i[1<<10][1<<10]={0};
public:
    int numIslands(vector<vector<char>>& grid) {
        int num=0;
        n=grid.size();
        if(!n) return num;
        
        m=grid[0].size();
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m;j++) {
                grid_i[i+1][j+1]=grid[i][j]-'0';
            }
        }
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m;j++) {
                if(grid_i[i][j]==1) {
                    dfs(i, j);
                    num++;
                }
            }
        }
        return num;
    }
    void dfs(int i, int j) {
        grid_i[i][j]=0;
        if(grid_i[i-1][j])
            dfs(i-1,j);
        if(grid_i[i+1][j])
            dfs(i+1,j);
        if(grid_i[i][j-1])
            dfs(i,j-1);
        if(grid_i[i][j+1])
            dfs(i,j+1);
    }
    
    
};