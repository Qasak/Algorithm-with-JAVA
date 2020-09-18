class Solution {
public:
    void dfs(int idx, int n, vector<vector<int>>& ans, vector<int>& nums) {
        if(idx==n) {
            ans.emplace_back(nums);
            return; 
        }
        for(int i=idx; i<n; i++) {
            // sort(nums.begin()+idx, nums.end());
            swap(nums[idx], nums[i]);
            dfs(idx+1, n, ans, nums);
            swap(nums[idx], nums[i]);
        }
    }
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> ans;
        dfs(0, nums.size(), ans, nums);
        return ans;
    }
};