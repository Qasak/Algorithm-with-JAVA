/*
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。
给定数组 nums = [-1, 0, 1, 2, -1, -4]，



满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]

*/


class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        int n=nums.size();
        sort(nums.begin(), nums.end());
        vector<vector<int>> ans;
        int target=0;
        for(int i=0; i<n-2; ) {
			target=-nums[i];
            int l=i+1;
            int r=n-1;
            while(l<r) {
                if(nums[l]+nums[r]<target)
                    l++;
                else if(nums[l]+nums[r]>target)
                    r--;
                else {
                    ans.push_back({nums[i], nums[l], nums[r]});
                    while(nums[l]==nums[++l]&&l<r);
                    while(nums[r]==nums[--r]&&l<r);
                }
            }
            while(nums[i]==nums[++i]&&i<n-2);
        }

        return ans;
    }
};
