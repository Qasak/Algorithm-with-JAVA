
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
    set<edge> :: iterator iter;
    void merge(edge &tmp) {
        iter=s.find(tmp);
        if(iter!=s.end()) {
            int l=min(iter->l, tmp.l);
            int r=max(iter->r, tmp.r);
            s.erase(iter);
            tmp.l=l;
            tmp.r=r;
            merge(tmp);
        } else {
            s.insert(tmp);
        }
    }

    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>> ans;
        if(intervals.empty())
            return ans;
        int n=intervals.size();
        edge tmp;
        tmp.l=intervals[0][0];
        tmp.r=intervals[0][1];
        s.insert(tmp);
        for(int i=1; i<n; i++) {
            tmp.l=intervals[i][0];
            tmp.r=intervals[i][1];
            merge(tmp);
        }
        for(iter=s.begin(); iter!=s.end(); iter++) {
            ans.push_back({iter->l, iter->r});
        }
        return ans;
    }
};