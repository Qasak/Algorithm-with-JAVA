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
        for(const auto &item:word_freq) {
            pii tmp{item.first, item.second};
			pq.push(tmp);							// 直接push，不用比较和top的大小
			if(pq.size()>k)
				pq.pop();
        }
        while(k--) {
            ans.push_back(pq.top().first);
            pq.pop();
        }
        reverse(ans.begin(), ans.end());

        return ans;
    }
};