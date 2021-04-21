package leetcode.SpringRecruit.Search;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/29 11:24
 */
public class Q611_有效三角形的个数 {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        if(n < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = 0;
        for(int i = 0; i < n - 2; i++) {
            for(int j = i + 1; j < n - 1; j++) {
                int target = nums[i] + nums[j];
                int idx = lowerBound(nums, j, target);
                if(idx > j) {
                    ans += idx - j - 1;
                }
            }
        }
        return ans;
    }
    public int lowerBound(int[] nums, int l, int target) {
        int r = nums.length;
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
}
