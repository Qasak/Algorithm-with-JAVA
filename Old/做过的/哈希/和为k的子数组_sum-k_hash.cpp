class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
		unordered_map<int, int> hash_map;
		int cnt=0, sum=0;
		hash_map[0]=1;
		for(int num:nums) {
			sum+=num;
			cnt+=hash_map[sum-k];
			++hash_map[sum];	// k可能为0, 放后面.  input:[1], k=0
		}
		return cnt;
    }
};