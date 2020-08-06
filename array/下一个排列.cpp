class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int n=nums.size();
        if(n<2) 
            return;
        int i=n-2;
        int j=n-1;
        int k=n-1;
        for(;i>=0;i--,j--) {
            if(nums[i]<nums[j])
                break;
        }
        if(i!=-1) {
            for(;k>j;k--) {
                if(nums[k]>nums[i])
                    break;
            }
            swap(nums[i],nums[k]);
        }
        while(j<n-1) {
            swap(nums[j], nums[n-1]);
            j++;
            n--;
        }
        return;
    }
};