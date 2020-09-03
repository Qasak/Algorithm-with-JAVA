#include<bits/stdc++.h>
using namespace std;
vector<int> dp(1025, 0x3f3f3f3f);
int coins[]={1,4,16,64};
int dfs(int s) {
    if(s==0) return 0;
    if(s<0) return -1;
    if(dp[s]<0x3f3f3f3f) return dp[s];
    int Min=0x3f3f3f3f;
    for(int i=0;i<4;i++) {
        int res=dfs(s-coins[i]);
        if(res>=0 && res<Min)
            Min=res+1;
    }
    return dp[s]=Min==0x3f3f3f3f ? -1 : Min;
}

int main() {
    int n;
    cin>>n;
    int s=1024-n;
    cout<<dfs(s);
    return 0;
}