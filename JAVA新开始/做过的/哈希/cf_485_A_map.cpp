#include<bits/stdc++.h>
using namespace std;


unordered_map<string, string> mp;

int main() {
    mp["purple"] = "Power";
    mp["green"] = "Time";
    mp["blue"] = "Space";
    mp["orange"] = "Soul";
    mp["red"] = "Reality";
    mp["yellow"] = "Mind";
	int n;
	cin>>n;
	cout<<6-n<<endl;
	while(n--) {
		string t;
		cin>>t;
		mp[t]="";
	}
	for(auto &s:mp) {
		if(s.second!="") {
			cout<<s.second;
			cout<<("\n");
		}
	}
	return 0;
}