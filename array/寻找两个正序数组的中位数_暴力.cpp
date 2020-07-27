class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int n=nums1.size();
        int m=nums2.size();
        int len=(n+m)>>1;
        int mid1,mid2;
        double ans;
        int i,j;
        i=j=0;
        
        if(m==0){
            if(n%2)
                return (double)nums1[n/2];
            else 
                return (double)(nums1[n/2]+nums1[n/2-1])/2;
        }
        
        if(n==0){
            if(m%2)
                return (double)nums2[m/2];
            else 
                return (double)(nums2[m/2]+nums2[m/2-1])/2;
        }
        
        while(len>=0) {
            mid2=mid1;
            if(i<n&&j<m) {
                if(nums1[i]<=nums2[j]) {
                    mid1=nums1[i];
                    i++;
                } else {
                    mid1=nums2[j];
                    j++;
                }
            } else if(i==n) {
                mid1=nums2[j];
                j++;
            } else {
                mid1=nums1[i];
                i++;
            }

            len--;
        }
        ans=(m+n)%2?mid1:(double)(mid1+mid2)/2;
        return ans;
    }
};