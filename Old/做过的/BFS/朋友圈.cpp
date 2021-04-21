typedef pair<int, int> pii;
class Solution {
public:
    int n;
    int m;
    void bfs(vector<vector<int>>& M, int x, int y) {
        queue<pii> q;
        q.push({x, y});
        while(!q.empty()) {
            pii p=q.front();
            q.pop();
            for(int j=p.second;j<m;j++) {
                if(M[p.first][j]){
                    q.push({j,0});
                    M[p.first][j]=0;
                }
            }
        }
    }
        
    int findCircleNum(vector<vector<int>>& M) {
        int cnt=0;
        n=M.size();
        m=M[0].size();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++)
                if(M[i][j]==1) {
                    cnt++;
                    bfs(M, i, j);
                }
        }
        return cnt;
    }
};