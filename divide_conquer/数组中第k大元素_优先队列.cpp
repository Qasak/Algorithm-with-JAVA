class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int> pq;
        for(int &c:nums) {
            pq.push(c);
        }
        while(k-1) {
            k--;
            pq.pop();
        }
        return pq.top();
    }
};