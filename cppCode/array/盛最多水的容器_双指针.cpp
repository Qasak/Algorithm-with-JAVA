class Solution {
public:
    int maxArea(vector<int>& height) {
        int n=height.size();
        if (!n) return 0;
        int i=0;
        int j=n-1;
        int maxsum=0;
        while(i<j) {
            int sum=(j-i)*min(height[i], height[j]);
            if(height[i]<height[j]) {
                if(sum>maxsum)
                    maxsum=sum;
                i++;
            } else {
                if(sum>maxsum)
                    maxsum=sum;
                j--;
            }
        }
        return maxsum;
    }
};