#include<bits/stdc++.h>
using namespace std;


int lo_b(vector<int> &a, int l, int r, int target) {
	int mid;
	while(l<r) {
		mid=(l+r)/2;
		if(a[mid]<target) {
			l=mid+1;
		} else {
			r=mid;
		}
	}
	if(a[l]==target)
		return l;
	return -1;
}



int main() {
    vector<int> a{1,2,3,4};
    cout<<lo_b(a,0,4,1);
    return 0;
}