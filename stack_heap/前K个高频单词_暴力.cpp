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
        vector<pair<string, int> >::iterator it_t = tmp.begin();
        for(int i=0; i<k; i++) {
            ans.push_back(it_t->first);
            it_t++;
        }
        return ans;
    }
};