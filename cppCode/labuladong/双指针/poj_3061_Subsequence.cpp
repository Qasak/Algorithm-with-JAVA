#include<vector>
#include<algorithm>
#include<iostream>
using namespace std;

const int MAXN = 1<<17;

int n,S;
vector<int> a;
vector<int> sum;

int main() {
    int kase;
    cin>>kase;
    while(kase--) {
        a.clear();
        sum.clear();
        cin >> n;
        cin >> S;
        for(int i=0; i<n; i++) {
            int t;
            cin>>t;
            a.push_back(t);
        }
        sum.resize(n+1);
        for(int i=0;i<=n;i++) {
            sum[i+1]=sum[i]+a[i];
        }
        
        if(sum[n]<S) {
            cout<<0<<endl;
            continue;
        }
        int res=n;
        for(int l=0; sum[l]+S<=sum[n]; l++) {
            int target=S+sum[l];
            int r=lower_bound(sum.begin(), sum.end(), target) - sum.begin();
            res=min(res, r-l);
        }
        cout<<res<<endl;
    }
	
	return 0;
}