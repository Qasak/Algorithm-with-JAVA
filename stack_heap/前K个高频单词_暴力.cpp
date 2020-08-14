bool cmp (const pair<string, int> &a, const pair<string, int> &b) {
    if(a.second==b.second)return a.first<b.first;
    else return a.second>b.second;
}

class Solution {
public:
    vector<string> topKFrequent(vector<string>& words, int k) {
        map<string, int> m;
        
        vector<string> ans;
        for(auto &word: words) {
            m[word]++;
        }
        vector<pair<string, int> > tmp(m.begin(), m.end()); // 直接放begin() end()就可以转换
        sort(tmp.begin(), tmp.end(), cmp);
        for(const auto &item:tmp) {
            if(k--==0) break;
            ans.push_back(item.first);
        }
        return ans;
    }
};