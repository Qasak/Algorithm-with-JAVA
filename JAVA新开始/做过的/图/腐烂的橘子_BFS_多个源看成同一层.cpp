class Solution {
public:
    int time[10][10];
    int ans;
    int fresh;
    vector<pair<int, int>> direction={{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    int orangesRotting(vector<vector<int>>& grid) {
        int n=grid.size();
        int m=grid[0].size();
        queue<pair<int, int>> q;
        memset(time, -1, sizeof(time));
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]==2) {
                    time[i][j]=0;
                    q.push({i,j});

                }
                if(grid[i][j]==1) {
                    fresh++;
                }
            }
        }
        while(!q.empty()) {
            auto t=q.front();
            q.pop();
            int x=t.first;
            int y=t.second;
            for(auto &dir:direction) {
                int xx=x+dir.first;
                int yy=y+dir.second;
                if(xx>=0 && xx < n && yy>=0 && yy<m && grid[xx][yy]==1) {
                    fresh--;
                    time[xx][yy]=time[x][y]+1;
                    grid[xx][yy]=2;
                    q.push({xx,yy});
                    ans=time[xx][yy];
                }
            }
        }

        return fresh ? -1 : ans;
    }
};