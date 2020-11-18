
#include<bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin>>n;
    while(n--) {
        string s;
        cin>>s;
        int j=0;
		int i=0;
		int n=s.size();
        while(i < n) {
            s[j++]=s[i++];
            if(j>=3 && s[j-1]==s[j-2] && s[j-2]== s[j-3]) // AAA
                j--;
            if(j>=4 && s[j-1]==s[j-2] && s[j-3]==s[j-4])/// AABB
                j--;
        }
        s.erase(s.begin()+j, s.end());
        cout<<s<<endl;
    }
    return 0;
}