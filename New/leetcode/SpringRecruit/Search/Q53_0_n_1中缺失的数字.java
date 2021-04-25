package leetcode.SpringRecruit.Search;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/25 17:38
 */
public class Q53_0_n_1中缺失的数字 {
    public int missingNumber(int[] nums) {
        int l = 0, r = nums.length;
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
