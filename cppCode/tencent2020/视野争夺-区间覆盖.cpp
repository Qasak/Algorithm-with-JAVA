#include<bits/stdc++.h>
using namespace std;
int main() {
    int n,L;

    cin>>n>>L;
    int m=n;
    vector<vector<int>> ranges;
    while(m--) {
        int a,b;
        cin>>a>>b;
        ranges.push_back({a,b});
    }
    sort(ranges.begin(), ranges.end(), [](vector<int> &a, vector<int> &b) {return (a[0]<b[0] || a[0]==b[0] && a[1]>b[1]);});
    int r_end=0;
    int i=0;
    int cnt=0;
    int cur_end=0;
    while(r_end<L) {
        cur_end=1<<31;
        while(i<n && ranges[i][0]<=r_end) {
            cur_end=max(cur_end, ranges[i][1]);
            i++;
        }
        if(cur_end==1<<31) {
            cout<<-1<<endl;
            return 0;
        }
        cnt++;
        r_end=cur_end;
        
    }
    cout<<cnt;
    return 0;
}