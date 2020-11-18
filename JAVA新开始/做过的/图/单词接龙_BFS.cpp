class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> s{wordList.begin(), wordList.end()};
        queue<pair<string, int>> q;
        q.push({beginWord, 1});
        while(!q.empty()) {
            auto top=q.front();
            if(top.first==endWord)
                return top.second;
            q.pop();
            string tmp=top.first;
            for(int i=0; i<tmp.size(); i++) {
                char ch=tmp[i];
                for(char c='a'; c<='z'; c++) {
                    if(c==tmp[i])
                        continue;
                    tmp[i]=c;
                    if(s.find(tmp)!=s.end()) {
                        q.push({tmp, top.second+1});
                        s.erase(tmp);
                    }
                }
                tmp[i]=ch;
            }
        }
        return 0;
    }
};