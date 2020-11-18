class Solution {
public:
    unordered_map<char, string> hash_map;
    vector<string> buttoms;
    vector<string> ans;
    string tmp;
    void dfs(int k) {
        if(k==buttoms.size()) {
            ans.push_back(tmp);
            return;
        }
        for(char &c:buttoms[k]) {
            tmp+=c;
            dfs(k+1);
            tmp.resize(k);
        }
    }
    vector<string> letterCombinations(string digits) {
        if(digits.size()==0)
            return ans;
        hash_map['1']="";
        hash_map['2']="abc";
        hash_map['3']="def";
        hash_map['4']="ghi";
        hash_map['5']="jkl";
        hash_map['6']="mno";
        hash_map['7']="pqrs";
        hash_map['8']="tuv";
        hash_map['9']="wxyz";
        for(char &c:digits) {
            buttoms.push_back(hash_map[c]);
        }
        dfs(0);
        // cout<<ans.size();
        return ans;
    }
};