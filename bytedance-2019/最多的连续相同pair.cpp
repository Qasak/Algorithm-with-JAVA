#include<bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin>>n;
    map<pair<int, int>, int> cur;
    map<pair<int, int>, int> pre;
    while(n--) {
        int cnt=0;
        int m;
        cin>>m;
        pair<int,int> t;
        while(m--) {
            int len;
            cin>>len;

            while(len--) {
                cin>>t.first>>t.second;
                if(pre.count(t)) {
                    cur[t]=pre[t]+1;
                } else {
                    cur[t]=1;
                }
                cnt=max(cnt, cur[t]);
            }

            pre.clear();
            pre.swap(cur);
        }
        cout<<cnt<<endl;
    }
    return 0;
}