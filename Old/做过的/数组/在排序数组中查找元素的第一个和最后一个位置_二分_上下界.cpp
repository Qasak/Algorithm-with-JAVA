class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> ans={-1,-1};
        int n=nums.size();
        if(!n) return ans;
        int l=0;
        int r=n;
        int mid;
        while(l<r) {
            mid=l+(r-l)/2;
            if(nums[mid]<target)
                l=mid+1;
            else
                r=mid;
        }
        if(l<n && nums[l]==target)
            ans[0]=l;
        l=0;
        r=n;
        while(l<r) {
            mid=l+(r-l)/2;
            if(nums[mid]<=target)
                l=mid+1;
            else
                r=mid;
        }
        if(l>0 && nums[l-1]==target)
            ans[1]=l-1;
        return ans;
    }
};