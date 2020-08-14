// 把map换成字典树 再用优先队列
typedef pair<string, int> pii;
struct Cmp {
    bool operator() (const pii &a, const pii &b) {
        if(a.second==b.second) return a.first<b.first;
        else return a.second>b.second;
    }
};


class Solution {

public:
    struct TrieNode {
        bool isEnd;
        pii word_freq;
        TrieNode* children[26];
        TrieNode():isEnd(false) {
            word_freq.second=0;
            for(auto &c:children) {
                c=nullptr;
            }
        }
    };
    TrieNode* root = new TrieNode();
    int K;
    priority_queue<pii, vector<pii>, Cmp> pq;
    void insert(string word) {
        if(word.size()==0) return;
        TrieNode* node=root;
        for(auto const &c:word) {
            if(node->children[c-'a'] == nullptr)
                node->children[c-'a'] = new TrieNode();
            node = node->children[c-'a'];
        }
        node -> isEnd =true;
        node -> word_freq.first = word;
        node -> word_freq.second++;
    }

    void dfs(TrieNode* node) {
        if(node == nullptr)
            return;
        if(node->isEnd) {
            pii tmp{node -> word_freq.first, node -> word_freq.second};
            pq.push(tmp);
            if(pq.size()>K)
                pq.pop();
        }
        for(auto const &child:node->children) {
            if(child) {
                dfs(child);
            }
        }
    }

    vector<string> topKFrequent(vector<string>& words, int k) {
        vector<string> ans;
        K=k;
        for(auto const &word:words) {
            insert(word);
        }
        dfs(root);
        while(k--) {
            ans.push_back(pq.top().first);
            pq.pop();
        }
        reverse(ans.begin(), ans.end());

        return ans;
    }
};