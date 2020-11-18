class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int sum=0;
        int max_sum=1<<31;
        int n=nums.size();
        for(int i=0;i<n;i++) {
            sum=max(nums[i], nums[i]+sum);
            max_sum=max(max_sum, sum);
        }
        return max_sum;
    }
};