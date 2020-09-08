class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int, vector<int>> q;
        int ans;
        for(int num:nums) {
            q.push(num);
        }
        while(k--) {
            ans=q.top();
            q.pop();
        }
        return ans;
    }
};