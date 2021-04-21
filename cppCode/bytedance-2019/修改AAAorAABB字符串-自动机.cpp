
#include<bits/stdc++.h>
using namespace std;

void statemachine(string s) {
    char pre=s[0];
    char cur;
    int state=0;
    string ans;
    ans+=pre;
    for(int i=1;i<s.size();i++) {
        cur=s[i];
        switch (state) {
        case 0:
            if(cur==pre) {
                state=1;
            } 
            break;
        case 1:
            if(cur==pre) {
                continue;
            } else {
                state=2;
            }
            break;
        case 2:
            if(cur==pre) {
                continue;
            } else {
                state=0;
            }
            break;
        default:
            break;
        }
        ans+=cur;
        pre=cur;
    }
    cout<<ans<<endl;
}

int main() {
    int n;
    cin>>n;
    while(n--) {
        string s;
        cin>>s;
        statemachine(s);
    }
    return 0;
}