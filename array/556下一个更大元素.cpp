class Solution {
public:
    vector<long long> nums;
    int nextGreaterElement(int n) {
        while(n) {
            nums.push_back(n%10);
            n/=10;
        }
        reverse(nums.begin(), nums.end());
        int len=nums.size();
        if(len<2)
            return -1;
        int i=len-2;
        int j=len-1;
        
        while(i>=0 && nums[i]>=nums[j]) {i--;j--;}

        if(i==-1)
            return -1;

        int k=len-1;
        while(k>j && nums[k]<=nums[i]) k--;
        swap(nums[k],nums[i]);

        while(j<len-1) {
            swap(nums[j], nums[len-1]);
            j++;
            len--;
        }
        long long ans=0;
        for(int i=nums.size()-1;i>=0;i--) {
            ans+=nums[i]*pow(10,nums.size()-1-i);
            if(ans>0x7fffffff)
                return -1;
        }
        return ans;

    }
};