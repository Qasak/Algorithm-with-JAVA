package leetcode.template.BIT;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/6 16:39
 */
public class Q327_CountRangeSum {
    // 前缀和暴力n^2
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            long sum = 0;
            for(int j = i; j < n; j++) {
                sum += nums[j];
                if(sum >= lower && sum <=upper) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
