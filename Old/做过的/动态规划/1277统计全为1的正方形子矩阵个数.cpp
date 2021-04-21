class Solution {
public:
    int countSquares(vector<vector<int>>& matrix) {
        int cnt=0;
        int n=matrix.size();
        int m=matrix[0].size();
        int f[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0; j<m;j++) {
                if(i==0||j==0) {
                    f[i][j]=matrix[i][j];
                } else if(matrix[i][j]==0) {
                    f[i][j]=0;
                } else {
                    f[i][j]=min(min(f[i-1][j], f[i][j-1]), f[i-1][j-1]) + 1;
                }
                cnt+=f[i][j];
            }
        }
        return cnt;
    }
};