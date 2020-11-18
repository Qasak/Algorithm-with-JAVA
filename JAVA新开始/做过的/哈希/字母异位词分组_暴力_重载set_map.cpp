struct char_set {
    int chars[26]={0};
    // int chars[26];
    char_set(string s) {
        for(auto const &c:s) {
            chars[c-'a']++;
        }
    }
};

bool operator <(const char_set &a, const char_set &b) {
    for(int i=0;i<26;i++) {
        if(a.chars[i] < b.chars[i])
            return true;
    }
    return false;
}

struct hash_func {
    std::size_t operator()(const char_set &key) const
    {
        using std::size_t;
        using std::hash;
        size_t code;
        for(auto const &c:key.chars) {
            code^=hash<int>() (c-'a');
        }
        return code;
    }

};

struct equals {
    bool operator () (const char_set &a, const char_set &b) const {
        for(int i=0;i<26;i++) {
            if(a.chars[i] != b.chars[i])
                return false;
        }
        return true;
    }
};


class Solution {
public:

    vector<vector<string>> groupAnagrams(vector<string>& strs) {

        vector<vector<string>> ans;
        set<char_set> char_sets;
        unordered_map<char_set, vector<string>, hash_func, equals> hash_map;
        for(auto &word:strs) {
            char_set tmp=char_set(word);
            if(char_sets.find(tmp)==char_sets.end()) {
                char_sets.insert(tmp);
            }
            hash_map[tmp].push_back(word);
        }
        for(auto const &v:hash_map) {
            ans.push_back(v.second);
        }
        // cout<<char_sets.size()<<endl;
        return ans;
    }
};