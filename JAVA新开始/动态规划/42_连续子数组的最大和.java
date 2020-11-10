/*
定义dp[i]: 以元素nums[i]为结尾的连续子数组最大和
若dp[i-1] <= 0 , 说明dp[i - 1]对dp[i]产生负(零)贡献，即dp[i - 1] + nums[i] 还不如nums[i]本身大
=>  当dp[i - 1] > 0 时： 执行dp[i] = dp[i - 1] + nums[i];
	当dp[i - 1] <= 0 时，执行dp[i] = nums[i];

初始状态：dp[0] = nums[0] 即以nums[0] 结尾的连续子数组最大和为nums[0];
返回值：返回dp列表中的最大值
**/


class Solution {
    public int maxSubArray(int[] nums) {
        int dp[] = new int[nums.length];
		dp[0] = nums[0];
		int mxSum = dp[0];
        for(int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
			mxSum = Math.max(dp[i], mxSum);
        }
		
        return mxSum;
    }
}

/*
dp[i]只与dp[i - 1]和nums[i] 有关，可将原数组nums作为dp列表，即 直接在nums上修改
可将空间复杂度从O(N) 降到O(1)
**/
class Solution {
    public int maxSubArray(int[] nums) {
		int mxSum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] > 0 ? nums[i - 1] + nums[i] : nums[i];
			mxSum = Math.max(nums[i], mxSum);
        }
        return mxSum;
    }
}