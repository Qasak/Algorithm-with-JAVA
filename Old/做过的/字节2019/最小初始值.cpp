#include<bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin>>n;
    int t=n;
    vector<int> a;
    while(t--) {
        int t;
        cin>>t;
        a.push_back(t);
    }
    int E=0;
    for(int i=n-1;i>=0;i--) {
        E=(E+a[i]+1)/2;
    }
    cout<<E<<endl;
    return 0;
}