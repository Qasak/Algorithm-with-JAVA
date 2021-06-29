package leetcode.contest.Week_246;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/29 17:58
 */
public class Q1909_删除一个元素使数组严格递增 {
    // n ^ 2
    // O(N)
    public boolean canBeIncreasing(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n - 1; i++) {
            if(nums[i] >= nums[i + 1]) {
                return check(nums, i) || check(nums, i + 1);
            }
        }
        return true;
    }
    public boolean check(int[] nums, int i) {
        int n = nums.length;
        if(i == 0 || i == n - 1) {
            if(i == 0) {
                return check(nums, 1, n - 1);
            } else {
                return check(nums, 0, n - 2);
            }
        } else {
            return nums[i - 1] < nums[i + 1] && check(nums, 0, i - 1) && check(nums, i + 1, n - 1);
        }
    }
    public boolean check(int[] nums, int l, int r) {
        for(int i = l; i < r; i++) {
            if(nums[i] >= nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
