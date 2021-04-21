package leetcode.template.BinSearch;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/4 9:51
 */
public class Q81_SearchII {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) {
            return false;
        }
        int l = 0;
        int r = n;
        while(l < r && nums[l] == nums[r - 1]) {
            if(target == nums[l]) {
                return true;
            }
            l++;
            r--;
        }
        int ll = l;
        int rr = r;
        while(l < r) {
            int mid = (l + r) / 2;
            if(nums[mid] == target) {
                return true;
            } else {
                if(nums[mid] >= nums[ll]) {
                    if(target < nums[ll]) {
                        l = mid + 1;
                    } else {
                        if(target < nums[mid]) {
                            r = mid;
                        } else {
                            l = mid + 1;
                        }
                    }
                } else {
                    if(target > nums[rr - 1]) {
                        r = mid;
                    } else {
                        if(target < nums[mid]) {
                            r = mid;
                        } else {
                            l = mid + 1;
                        }
                    }
                }
            }
        }
        return false;
    }
}
