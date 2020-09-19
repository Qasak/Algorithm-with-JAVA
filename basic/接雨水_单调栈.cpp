class Solution {
public:
    int trap(vector<int>& height) {
        stack<int> s;
        int ans=0;
        int n=height.size();
        for(int i=0;i<n;i++) {
            while(!s.empty() && height[s.top()]<height[i]) {
                int cur=s.top();
                s.pop();
                if(s.empty()) break;
                int l=s.top();
                int r=i;
                ans+=(min(height[l], height[r])-height[cur])*(r-l-1);
            }
            s.push(i);
        }
        return ans;
    }
};