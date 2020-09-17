class Solution {
public:
    string getPermutation(int n, int k) {
        vector<int> factorial(n);
        factorial[0] = 1;
        for (int i = 1; i < n; ++i) {
            factorial[i] = factorial[i - 1] * i;
        }
        vector<int> nums(n);
        for(int i=0;i<n;i++) nums[i]=i+1;
        string ret;
        --k;
        for (int i = n - 1; i >=0; --i) {
            int t = k / factorial[i];
            ret += nums[t]+'0';
            nums.erase(nums.begin()+t);
            k %= factorial[i];
        }
        return ret;
    }
};