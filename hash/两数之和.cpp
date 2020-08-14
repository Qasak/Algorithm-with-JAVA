class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> mp;
        int n=nums.size();
        
        for(int i=0; i<n; i++) {
            if(mp.count(target-nums[i])) {
                return {mp[target-nums[i]], i};
            }
            mp[nums[i]]=i; 			// 应对重复数字的情况
        }
        return {};
    }
};