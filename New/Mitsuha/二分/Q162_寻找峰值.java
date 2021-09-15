package Mitsuha.二分;

public class Q162_寻找峰值 {
    class Solution {
        public int findPeakElement(int[] nums) {
            int n = nums.length;
            long INF = 2147483650L;
            int l = 0, r = n;
            while(l < r) {
                int m = (l + r) >>> 1;
                long prev = m == 0 ? -INF : nums[m - 1];
                long next = m == n - 1 ? -INF : nums[m + 1];
                long cur = nums[m];
                if(cur > prev && cur > next) {
                    return m;
                } else if(cur > prev) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            return -1;
        }

    }
}
