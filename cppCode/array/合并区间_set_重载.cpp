struct edge {
    int l;
    int r;
};
bool operator <(const edge &a, const edge &b) {
    return a.r<b.l;
}

class Solution {
public:
    set<edge> s;
    void merge(edge &tmp) {
        auto iter=s.find(tmp);
        if(iter!=s.end()) {
            tmp.l=min(iter->l, tmp.l);
            tmp.r=max(iter->r, tmp.r);
            s.erase(iter);
            merge(tmp);
        } else {
            s.insert(tmp);
        }
    }

    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>> ans;
        if(intervals.empty())
            return ans;
		for(auto &interval:intervals) {
            edge tmp;
            tmp.l=interval[0];
            tmp.r=interval[1];
			merge(tmp);
		}
        for(auto p:s) {
            ans.push_back({p.l,p.r});
        }
        return ans;
    }
};







//Lutece 2145 人在地上走，锅从天上来
//https://acm.uestc.edu.cn/contest/12/problem/C
#include<bits/stdc++.h>
#define LL long long
using namespace std;
const int maxn = 100001;
struct edge {
    int l;
    int r;
};

bool operator <(edge a, edge b)
{
    return a.r < b.l;
}
set<edge> s;
set<edge>::iterator iter;
int merge(edge & temp)
{
    if ((iter = s.find(temp)) != s.end())
    {
      temp.l = min(temp.l, iter->l);
      temp.r = max(temp.r, iter->r);
      s.erase(iter);
      merge(temp);
      return 1;
    }
    else
    {
      s.insert(temp);
      return 0;
    }
}
int main()
{
    cin.sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
      edge temp;
      cin >> temp.l >> temp.r;
      merge(temp);
      cout << (i?" ":"") << s.size();
    }
}
