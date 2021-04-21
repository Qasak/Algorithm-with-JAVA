class Solution {
public:
int largestRectangleArea(vector<int> &heights) {
    stack<int> s;
    int ans = 0;
    heights.push_back(0);
    int n=heights.size();
    for (int i = 0; i < n; i++) {
        while (!s.empty() && heights[i] <= heights[s.top()]) {
            int h = heights[s.top()];
            s.pop();
            if (s.empty())
                ans = max(ans, i * h);
            else
                ans = max(ans, (i - s.top() - 1) * h);
        }
        s.push(i);
    }
    return ans;
}
};
