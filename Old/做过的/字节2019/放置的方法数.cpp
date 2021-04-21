#include<bits/stdc++.h>
using namespace std;
long long C(long long x) {
    return (x*(x-1))/2;
}
int main() {
    vector<long long> a;
    int n, m;
    long long cnt=0;
    cin>>m;
    n=m;
    int d;
    cin>>d;
    while(m--) {
        int t;
        cin>>t;
        a.push_back(t);
    }
    for(int i=0; i<n; i++) {
        int target=a[i]+d;
        int j=lower_bound(a.begin(), a.end(), target) - a.begin();
        if(a[j]==a[i]+d) j++;
        if(j-i-1>=2) {
            cnt+=C(j-i-1);
            cnt %= 99997867;
        }
    }
    cout<<cnt;
    return 0;
}