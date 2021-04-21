class Solution {
public:
    bool used[101][101];
    int dx[4]={-1, 0, 1, 0};
    int dy[4]={0, 1, 0, -1};
    int N;
    int M;
    int cnt;
    void dfs(int x, int y, int k) {
        if(used[x][y]) return;
        int tx=x, ty=y, sum=0;
        while(tx) {
            sum+=tx%10;
            tx/=10;
        }
        while(ty) {
            sum+=ty%10;
            ty/=10;
        }
        if(sum>k) return;
        used[x][y]=true;
        cnt++;
        for(int i=0;i<4;i++) {
            int xx=x+dx[i], yy=y+dy[i];
            if(xx>=0 && xx < N && yy>=0 && yy < M)
                dfs(xx, yy, k); 
        }
    }
    int movingCount(int m, int n, int k) {
        
        N=n;
        M=m;
        dfs(0,0,k);
        return cnt;
    }
};