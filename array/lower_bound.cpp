#include<iostream>
#include<algorithm>
using namespace std;

int main() {
    int a[4]={1,3,3,3};
    int t;
    int val;
    cin>>val;
    t=lower_bound(a,a+4,val)-a;
    cout<<t;
    return 0;

}