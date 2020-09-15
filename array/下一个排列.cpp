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

class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int n=nums.size();
        if(n<=1) return;
        int i=n-1;
        int j=n-2;
        while(j>=0) {
            if(nums[j]<nums[i])
                break;
            i--;
            j--;
        }
        int cnt=0;
        if(j>=0) {
            int k=n-1;
            for(;k>=i;k--) {
                if(nums[k]>nums[j])
                    break;
            }
            swap(nums[j], nums[k]);
        }

        sort(nums.begin()+i, nums.end());
        return;
    }
};