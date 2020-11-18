class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        vector<int> tmp(nums1.size());
        copy(nums1.begin(), nums1.end(),tmp.begin());
        int i,j,k;
        i=j=k=0;
        while(i<m && j<n) {
            if(tmp[i]<nums2[j]) 
                nums1[k]=tmp[i++];
            else
                nums1[k]=nums2[j++];
            k++;
        }
        while(i<m) 
            nums1[k++]=tmp[i++];
        while(j<n)
            nums1[k++]=nums2[j++];
    }
};

// 倒序，空间优化
class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        if(!n) return;
        int k=n+m-1;
        int i=m-1;
        int j=n-1;
        while(i>=0 && j>=0) 
            nums1[k--]=nums1[i]>nums2[j] ? nums1[i--] : nums2[j--];
        while(j>=0)
            nums1[k--]=nums2[j--];
    }
};