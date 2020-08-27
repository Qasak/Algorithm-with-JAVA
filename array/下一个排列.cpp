class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int n=nums.size();
        if(n<2) 
            return;
        int i=n-2;
        int j=n-1;
        
        while(i>=0 && nums[i]>=nums[j]) {i--;j--;}
        if (i!=-1) {
            int k=n-1;
            while(k>j && nums[k]<=nums[i]) k--;
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