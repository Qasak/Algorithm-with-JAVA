class Solution {
public:
    vector<int> tmp;
    int merge_sort(vector<int> &nums, vector<int> &tmp, int l, int r) {
        if(l>=r)
            return 0;
        int mid=(l+r)/2;
        int cnt = merge_sort(nums, tmp, l, mid)+merge_sort(nums, tmp, mid+1,r);

        int i=l, j=mid+1, pos=l;
        while(i<=mid && j<=r) {
            if(nums[i]<=nums[j]) {
                tmp[pos++]=nums[i];
                i++;
                cnt+=j-(mid+1);
            } else {
                tmp[pos++]=nums[j];
                j++;
            }
        }
        while(i<=mid) {
            tmp[pos++] = nums[i];
            cnt+=j-(mid+1);
            i++;
        }
        while(j<=r) {
            tmp[pos++]=nums[j];
            j++;
        }
        copy(tmp.begin()+l, tmp.begin()+r+1, nums.begin()+l);
        return cnt;
    }
    int reversePairs(vector<int>& nums) {
        int n=nums.size();
        tmp.resize(n);
        return merge_sort(nums, tmp, 0, n-1);
    }
};