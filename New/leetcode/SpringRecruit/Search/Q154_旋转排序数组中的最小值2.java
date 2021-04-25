package leetcode.SpringRecruit.Search;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/7 13:01
 */
public class Q154_旋转排序数组中的最小值2 {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while(l < r) {
            int m = (l + r) >>> 1;
            if(nums[l] == nums[m] && nums[r] == nums[m]) {
                r--;
                l++;
                continue;
            }
            if(nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums[l];
    }
}
