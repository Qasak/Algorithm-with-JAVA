class Solution {
public:
    vector<vector<int>> ans;
    
    vector<vector<int>> subsets(vector<int>& nums) {
        int n=nums.size();
        for(long long mask=0; mask < (1<<n); mask++) {
            vector<int> t;
            for(int i=0;i<n;i++) {
                if(mask & (1<<i))
                    t.push_back(nums[i]);
            }
            ans.emplace_back(t);
        }
        return ans;
    }
};
class Solution {
public:
    vector<vector<int>> ans;
    vector<int> t;
    void dfs(int cur, vector<int>& nums) {
        if(cur==nums.size()) {
            ans.emplace_back(t);
            return;
        }
            
        t.push_back(nums[cur]);
        dfs(cur+1, nums);
        t.pop_back();
        dfs(cur+1, nums);
    }
    vector<vector<int>> subsets(vector<int>& nums) {
        dfs(0, nums);
        return ans;
    }
};
