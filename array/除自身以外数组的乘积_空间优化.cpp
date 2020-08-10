class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        vector<int> ans;
        if(nums.empty())
            return ans;
        int n=nums.size();
        int prod=1;
        for(int i=0;i<n;i++) {
			ans.push_back(prod);
            prod*=nums[i];
        }
        prod=1;
        for(int i=n-1;i>=0;i--) {
            ans[i]*=prod;
            prod*=nums[i];
        }
        return ans;
    }
};