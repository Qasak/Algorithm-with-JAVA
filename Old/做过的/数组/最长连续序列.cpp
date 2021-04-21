class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> num_set;
        for(int num:nums) {
            num_set.insert(num);
        }
        
        int mxcnt=0;
        for(int num:nums) {
            if(!num_set.count(num-1)) {            
                int cnt=0;
                while(num_set.count(num)) {
                    cnt++;
                    num++;
                    mxcnt=max(cnt, mxcnt);
                }
            }
        }
        return mxcnt;
    }
};