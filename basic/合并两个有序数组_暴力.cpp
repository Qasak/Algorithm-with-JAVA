class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        if(m){
            int tmp[m];
            for(int i=0;i<m;i++) {
                tmp[i]=nums1[i];
            }
            int p=0;
            int i=0;
            int j=0;
            while(m&&n) {
                if(tmp[i]<nums2[j]) {
                    m--;
                    nums1[p++]=tmp[i++];
                } else {
                    n--;
                    nums1[p++]=nums2[j++];
                }
            }
            if(m) {
                while(m--) {
                    nums1[p++]=tmp[i++];
                }
            }
            if(n) {
                while(n--) {
                    nums1[p++]=nums2[j++];
                }
            }
        }
        else {
            for(int i=0;i<n;i++) {
                nums1[i]=nums2[i];
            }
        }
    }
};