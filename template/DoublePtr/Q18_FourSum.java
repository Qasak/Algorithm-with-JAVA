package leetcode.template.DoublePtr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/26 17:33
 */
public class Q18_FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int a, b, c, d;
        for(int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            a = nums[i];
            for(int j = i + 1; j < n; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int r = n - 1;
                b = nums[j];
                for(int l = j + 1; l < n; l++) {
                    if(l > j + 1 && nums[l] == nums[l - 1]) {
                        continue;
                    }
                    c = nums[l];
                    while(l < r && a + b + c + nums[r] > target) {
                        r--;
                    }
                    if(l == r) {
                        break;
                    }
                    d = nums[r];
                    if(a + b + c + d == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(a); list.add(b); list.add(c); list.add(d);
                        ans.add(list);
                    }
                }
            }
        }
        return ans;
    }
}
