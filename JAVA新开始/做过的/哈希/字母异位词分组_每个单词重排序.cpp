class Solution {
public:

    vector<vector<string>> groupAnagrams(vector<string>& strs) {

        vector<vector<string>> ans;
        unordered_map<string, vector<string>> hash_map;
        for(auto &word:strs) {
            string t=word;
            sort(t.begin(), t.end());
            hash_map[t].push_back(word);
        }
        for(auto const &v:hash_map) {
            ans.push_back(v.second);
        }
        return ans;
    }
};