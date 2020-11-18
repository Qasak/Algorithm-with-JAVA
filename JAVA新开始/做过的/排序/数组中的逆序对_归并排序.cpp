class Solution {
public:
    vector<int> tmp;
    int ans = 0;
    void merge_sort(vector<int>& nums, int l, int r) {
        if(l>=r) return;
        int mid=(l+r)/2;
        merge_sort(nums, l, mid); merge_sort(nums, mid+1, r);
        int i=l, j=mid+1, k=0;
        while(i<=mid && j<=r) {
            if(nums[i] <= nums[j])
                tmp[k++]=nums[i++];
            else {
                tmp[k++]=nums[j++];
                ans+=mid-i+1;
            }
        }
        while(i<=mid) tmp[k++]=nums[i++];
        while(j<=r) tmp[k++]=nums[j++];
        for(int i = l, k = 0; i <= r; i++, k++) nums[i] = tmp[k];
    }
    int reversePairs(vector<int>& nums) {
        int n=nums.size();
        tmp.resize(n);
        merge_sort(nums, 0, n-1);
        return ans;
    }
};