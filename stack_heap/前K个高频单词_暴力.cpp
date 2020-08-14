bool cmp (const pair<string, int> &a, const pair<string, int> &b) {
    return a.second>b.second;
}
class Solution {
public:
    vector<string> topKFrequent(vector<string>& words, int k) {
        map<string, int> m;
        vector<pair<string, int> > tmp;
        vector<string> ans;
        for(auto &word: words) {
            m[word]++;
        }
        for(const auto &i:m) {
            tmp.push_back(make_pair(i.first, i.second));
        }
        stable_sort(tmp.begin(), tmp.end(), cmp);
        for(const auto &item:tmp) {
            if(k--==0) break;
            ans.push_back(item.first);
        }
        return ans;
    }
};