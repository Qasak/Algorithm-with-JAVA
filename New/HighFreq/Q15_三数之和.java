package leetcode.HighFreq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/24 19:31
 */
public class Q15_三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // 枚举起点
        int n = nums.length;
        int i = 0;
        while(i < n) {
            int a = nums[i];
            int target = -a;
            // b + c == target
            int j = i + 1, k = n - 1;
            while(j < k) {
                if(nums[j] + nums[k] == target) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    ans.add(tmp);
                    // -1 , 0 0 1 1
                    j++; k--;
                    while(j < k && nums[j - 1] == nums[j]) {
                        j++;
                    }
                    while(k > j && nums[k + 1] == nums[k]) {
                        k--;
                    }


                } else if(nums[j] + nums[k] < target) {
                    j++;
                } else {
                    k--;
                }
            }
            i++;
            while(i < n && nums[i - 1] == nums[i]) {
                i++;
            }
        }
        return ans;
    }

}
