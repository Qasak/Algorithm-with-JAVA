class Solution {
public:
    int cnt=1;
    int mxcnt=1;
    int findLengthOfLCIS(vector<int>& nums) {
        
        int n=nums.size();
        if(!n) return 0;
        for(int i=0;i<n-1;i++) {
            if(nums[i]<nums[i+1]) {
                cnt++;
                mxcnt=max(cnt,mxcnt);
            }
            else 
                cnt=1;
        }
        return mxcnt;
    }
    
};