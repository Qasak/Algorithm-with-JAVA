class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int l = 0, r = n;
        while(l < r) {
            int m = (l + r) >>> 1;
            if(nums[m] == m) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
	
}
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        return (n * (n + 1)) / 2 - Arrays.stream(nums).sum();
    }
}