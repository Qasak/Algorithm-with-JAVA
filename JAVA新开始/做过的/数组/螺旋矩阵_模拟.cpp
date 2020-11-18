class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        int n=0;
        int m=0;
        vector<int> ans;
        
        n=matrix.size();
        if(!n) return ans;
        m=matrix[0].size();



        bool flag[n+2][m+2];
        memset(flag,0,sizeof(flag));

        for(int i=0;i<=n+1;i++) {
            flag[i][0]=1;
            flag[i][m+1]=1;
        }
        for(int j=0;j<=m+1;j++) {
            flag[0][j]=1;
            flag[n+1][j]=1;
        }


        int forward=0;
        int i=1;
        int j=1;

        int cnt=m*n;
        while(cnt) {
            switch(forward) {
                case 0:
                while(!flag[i][j]) {
                    ans.push_back(matrix[i-1][j-1]);
                    flag[i][j]=1;
                    j++;
                    cnt--;
                }
                forward=(forward+1)%4;
                j--;
                i++;
                break;

                case 1:
                while(!flag[i][j]) {
                    ans.push_back(matrix[i-1][j-1]);
                    flag[i][j]=1;
                    i++;
                    cnt--;
                }
                forward=(forward+1)%4;
                i--;
                j--;
                break;

                case 2:
                while(!flag[i][j]) {
                    ans.push_back(matrix[i-1][j-1]);
                    flag[i][j]=1;
                    j--;
                    cnt--;
                }
                forward=(forward+1)%4;
                j++;
                i--;
                break;

                case 3:
                while(!flag[i][j]) {
                    ans.push_back(matrix[i-1][j-1]);
                    flag[i][j]=1;
                    i--;
                    cnt--;
                }
                forward=(forward+1)%4;
                i++;
                j++;
                break;
            }
        }


        return ans;
    }
};