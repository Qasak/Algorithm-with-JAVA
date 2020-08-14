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
        int left=0;
        int right=n-1;
        int target=0;
        while(left+1<right) {
            int i=left+1;
            int j=right;
            target=-nums[left];
            while(i<j) {
                if(nums[i]+nums[j]<target)
                    i++;
                else if(nums[i]+nums[j]>target)
                    j--;
                else {
                    ans.push_back({nums[left], nums[i], nums[j]});
                    while(nums[i]==nums[++i]&&i<j);
                    while(nums[j]==nums[--j]&&i<j);
                }
            }
            while(nums[left]==nums[++left]&&left+1<right);
        }

        return ans;
    }
};