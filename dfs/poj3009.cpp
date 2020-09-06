#include <cstdio>
#include <cstring>
#include <iostream>

using namespace std;

const int INF = 1000;
const int TYPE_VACANT = 0;
const int TYPE_BLOCK = 1;
const int TYPE_START = 2;
const int TYPE_GOAL = 3;
const int MAX_THROW = 10;

int m, n;
int mat[22][22];
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1};
int ans;


void dfs(int x, int y, int step) {
    if(step >= MAX_THROW) {
        return;
    }
    for(int i = 0; i < 4; ++i) {
        int xx = x;
        int yy = y;
        while(true) {
            xx += dx[i];
            yy += dy[i];
            if(xx < 0 || xx >= m || yy < 0 || yy >= n) {
                break;
            }
            if(mat[xx][yy] == TYPE_GOAL) {
                ans = min(ans, step + 1);
                break;
            }
            if(mat[xx][yy] == TYPE_BLOCK) {
                mat[xx][yy] = TYPE_VACANT;
                int prex = xx - dx[i];
                int prey = yy - dy[i];
                if(prex != x || prey != y) {
                    dfs(prex, prey, step + 1);
                }
                mat[xx][yy] = TYPE_BLOCK;
                break;
            }
        }
    }
}

void solve() {
    ans = INF;
    int sx, sy;
    for(int i = 0; i < m; ++i) {
        for(int j = 0; j < n; ++j) {
            cin >> mat[i][j];
            if(mat[i][j] == TYPE_START){
                sx = i;
                sy = j;
            }
        }
    }
    dfs(sx, sy, 0);
    if(ans == INF){
        ans = -1;
    }
}

int main() {
    while(cin >> n >> m && n > 0 && m > 0) {
        solve();
        cout << ans << endl;
    }
    return 0;
}