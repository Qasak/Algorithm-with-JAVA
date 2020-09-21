class Solution {
public:
    int trap(vector<int>& height) {
        stack<int> s;
        int ans=0;
        int n=height.size();
        for(int i=0;i<n;i++) {
            while(!s.empty() && height[i]>height[s.top()]) {
                int h=height[s.top()];
                s.pop();
                if(s.empty())
                    break;
                ans+=(min(height[s.top()], height[i])-h)*(i-s.top()-1);
            }
            s.push(i);
        }
        return ans;
    }
};