package leetcode.JianZhi;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/22 10:02
 */
public class Q53 {
    public int search(int[] nums, int target) {
        return upperBound(nums, target) - lowerBound(nums, target);
    }
    public int lowerBound(int[] nums, int target) {
        int l = 0, r = nums.length;
        while(l < r) {
            int m = (l + r) >>> 1;
            if(nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
    public int upperBound(int[] nums, int target) {
        int l = 0, r = nums.length;
        while(l < r) {
            int m = (l + r) >>> 1;
            if(nums[m] <= target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
