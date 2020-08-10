class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        vector<int> ans;

        if(nums.empty())
            return ans;
        int n=nums.size();
        int pre[n];
        int post[n];
        int prod=1;
        pre[0]=1;
        for(int i=1;i<n;i++) {
            prod*=nums[i-1];
            pre[i]=prod;
        }
        prod=1;
        post[n-1]=1;
        for(int i=n-2;i>=0;i--) {
            prod*=nums[i+1];
            post[i]=prod;
        }
        for(int i=0;i<n;i++) {
            ans.push_back(pre[i]*post[i]);
        }
        return ans;
    }
};