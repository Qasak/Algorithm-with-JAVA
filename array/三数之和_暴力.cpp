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