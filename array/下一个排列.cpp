class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int pos=nums.size()-1;
        while(pos>0 && nums[pos]<=nums[pos-1]) pos--;
		
        if (pos!=0) {
            int k=nums.size()-1;
            while(k>pos && nums[k]<=nums[pos-1]) k--;
            swap(nums[pos-1],nums[k]);
        }
		sort(nums.begin()+pos, nums.end());
        return;
    }
};