class Solution {
public:
    vector<int> dp;
    int lengthOfLIS(vector<int>& nums) {
        int n=nums.size();
        if(!n) return 0;
        dp.resize(n);
        for(int i=0;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(nums[j]<nums[i])
                    dp[i]=max(dp[j],dp[i]);
            }
            dp[i]++;
        }
        return *max_element(dp.begin(),dp.end());
    }
};


//
class Solution {
public:
    vector<int> dp;
    int lengthOfLIS(vector<int>& nums) {
        int n=nums.size();
        if(!n) return 0;
        dp.resize(n);
        int cnt=0;
        int mxcnt=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(nums[j]<nums[i])
                    dp[i]=max(dp[j],dp[i]);
            }
            cnt=++dp[i];
            mxcnt=max(mxcnt,cnt);
        }
        return mxcnt;
    }
};