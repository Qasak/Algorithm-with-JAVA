class Solution {
public:
    int maxArea(vector<int>& height) {
        int n=height.size();
        if (!n) return 0;
        int maxsum=0;
        for(int i=0;i<n;i++) {
            for(int j=n-1;j>=0;j--) {
                int len=j-i;
                int sum=len*min(height[i],height[j]);
                if(sum>maxsum)
                    maxsum=sum;
                if(height[j]>=height[i])
                    break;
            }
        }
        return maxsum;
    }
};