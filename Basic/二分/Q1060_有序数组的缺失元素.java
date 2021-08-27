class Solution {
	// O(n)
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        for(int i = 0; i < n - 1; i++) {
            int diff = nums[i + 1] - nums[i] - 1;
            if(k <= diff) {
                return nums[i] + k;
            } else {
                k -= diff;
            }
        }
        
        return nums[n - 1] + k;
    }
	// 二分
    public int missingElement(int[] nums, int k) {
        int l = 0, r = nums.length;
        // 截止在idx时缺失的元素数目为 nums[idx] - nums[0] + 1 - (idx + 1)
        // nums[idx] - nums[0] - idx
        while(l < r) {
            int m = (l + r) >>> 1;
            if(help(nums, m) < k) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums[l - 1] + k - help(nums, l - 1);
    }
	// 虚拟元素数量 - 实际元素数量 == 缺失元素数量
    private int help(int[] nums, int idx) {
        return nums[idx] - nums[0] - idx;
    }
}