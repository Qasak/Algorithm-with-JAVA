class Solution {
public:

    vector<vector<int>> ans;
    void dfs(vector<int> tmp, map<int, bool> &hash_table,int n) {
        if(tmp.size()==n) {
            ans.push_back(tmp);
            return;
        }
        for(auto &pair:hash_table) {
            if(pair.second==false) {
                tmp.push_back(pair.first);
                pair.second=true;
                dfs(tmp, hash_table, n);
                tmp.pop_back();
                pair.second=false;
            }
        }


    }
    vector<vector<int>> permute(vector<int>& nums) {
        int n = nums.size();
        map<int, bool> hash_table;
        for(auto &num:nums) {
            hash_table[num]=false;
        }
        vector<int> tmp;
        dfs(tmp, hash_table, n);
        return ans;
    }
};