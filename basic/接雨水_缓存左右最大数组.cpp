class Solution {
public:
    int trap(vector<int>& height) {
        if(height.empty()) 
            return 0;
        int ans=0;
        int n=height.size();
        int max_left[1<<14]={0};
        int max_right[1<<14]={0};
        max_left[0]=height[0];
        for(int i=1; i<n;i++) 
            max_left[i]=max(height[i],max_left[i-1]);
        max_right[n-1]=height[n-1];
        for(int i=n-2; i>=0;i--)
            max_right[i]=max(height[i],max_right[i+1]);
        for(int i=1;i<n-1;i++)
            ans+=min(max_right[i],max_left[i])-height[i];
        return ans;
    }
};