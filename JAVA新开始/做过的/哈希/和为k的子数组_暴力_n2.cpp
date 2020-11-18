/*
给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。

示例 1 :

输入:nums = [1,1,1], k = 2
输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
说明 :

数组的长度为 [1, 20,000]。
数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。

C++



作者：力扣 (LeetCode)
链接：https://leetcode-cn.com/leetbook/read/2020-top-interview-questions/xrus7d/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/

class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        int n=nums.size();
        int cnt=0;
        for(int i=0; i<n; i++) {
            int sum=0;
            for(int j=i; j<n;j++) {
                sum+=nums[j];
                if(sum==k) {
                    cnt++;
                }
                    
            }
        }
        return cnt;
    }
};