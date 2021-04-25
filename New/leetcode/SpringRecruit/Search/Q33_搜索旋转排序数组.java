package leetcode.SpringRecruit.Search;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/21 13:59
 */
public class Q33_搜索旋转排序数组 {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while(l <= r) {
            int m = (l + r) >>> 1;
            if(target == nums[m]) {
                return true;
            }
            if(nums[m] == nums[l] && nums[m] == nums[r]) {
                l++; r--;
                continue;
            }
            // 目标在大数组
            if(target > nums[r]) {
                // m 在小数组
                if(nums[m] < nums[l]) {
                    r = m - 1;
                } else {
                    // 目标和m都在大数组：正常二分写法
                    if(nums[m] < target) {
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                }
                // 目标在小数组
            } else {
                // m 在大数组
                if(nums[m] > nums[r]) {
                    l = m + 1;
                } else {
                    // 目标和m都在小数组：正常二分写法
                    if(nums[m] < target) {
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                }
            }
        }
        return false;
    }
}
