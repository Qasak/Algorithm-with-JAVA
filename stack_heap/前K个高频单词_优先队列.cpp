typedef pair<string, int> pii;
struct Cmp {
    bool operator() (const pii &a, const pii &b) {
        if(a.second==b.second) return a.first<b.first;
        else return a.second>b.second;
    }
};


class Solution {
public:
    vector<string> topKFrequent(vector<string>& words, int k) {
        map<string, int> word_freq;
        vector<string> ans;
        for(auto &word: words) {
            word_freq[word]++;
        }

        priority_queue<pii, vector<pii>, Cmp> pq;
        Cmp cmp;
        for(const auto &item:word_freq) {
            pii tmp{item.first, item.second};
            if(pq.size()<k) pq.push(tmp);
            else if(cmp(tmp, pq.top())) {
                pq.pop();
                pq.push(tmp);
            }
        }
        while(k--) {
            ans.push_back(pq.top().first);
            pq.pop();
        }
        reverse(ans.begin(), ans.end());

        return ans;
    }
};