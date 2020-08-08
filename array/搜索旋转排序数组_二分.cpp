class Solution {
public:
    int search(vector<int>& nums, int target) {
        int n=nums.size();
        int l=0;
        int r=n;
        int mid;
        while(l<r) {
            mid=l+(r-l)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[mid]>=nums[0]) {
                if(nums[0]<=target && target < nums[mid])
                    r = mid;
                else
                    l = mid + 1;
            } else {
                if(nums[mid]<target && target <= nums[n-1])
                    l = mid + 1;
                else
                    r = mid;
            }
        }
        return -1;
    }
};