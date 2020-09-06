#include<vector>
#include<iostream>

using namespace std;

int cnt=0;
int m, n;


void dfs(int i, int j, vector<vector<char>> &matrix, vector<vector<bool>> &used) {
    if(used[i][j]) 
        return;

    used[i][j]=true;

    if(matrix[i][j]=='.')
        cnt++;
    if(i-1>=0 && matrix[i-1][j]=='.')
        dfs(i-1,j, matrix, used);
    if(i+1<n && matrix[i+1][j]=='.')
        dfs(i+1, j, matrix, used);
    if(j-1>=0 && matrix[i][j-1]=='.')
        dfs(i,j-1, matrix, used);
    if(j+1<m && matrix[i][j+1]=='.')
        dfs(i, j+1, matrix, used);
}


int main() {

    while(cin>>m>>n) {
        cnt=0;
        if(m==0 && n==0) break;
        vector<vector<char>> matrix(n, vector<char>(m));
        vector<vector<bool>> used(n, vector<bool>(m, false));
        pair<int, int> s;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m;j++) {
                cin>>matrix[i][j];
                if(matrix[i][j]=='@') {
                    s.first=i;
                    s.second=j;
                    cnt++;
                }

            }
        }
        dfs(s.first, s.second, matrix, used);
        cout<<cnt<<endl;
    }
    return 0;
}