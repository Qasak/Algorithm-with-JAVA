class Solution {
    vector<vector<int>> ans;
    int n;
public:
    void dfs(vector<int>& nums, int idx) {
        if(idx==n) {
            ans.emplace_back(nums);
            return;
        }
        for(int i=idx;i<n;i++) {
            sort(nums.begin()+idx, nums.end());
            if(i+1<n && nums[i]==nums[i+1])
                continue;
            swap(nums[i], nums[idx]);
            dfs(nums, idx+1);
            swap(nums[i], nums[idx]);
        }
    }
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        n=nums.size();
        dfs(nums, 0);
        return ans;
    }
};