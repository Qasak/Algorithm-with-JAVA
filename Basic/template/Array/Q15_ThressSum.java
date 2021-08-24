package leetcode.template.Array;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/2 18:25
 */
public class Q15_ThressSum {
    //1. n ^ 2 log n + set去重
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        if(nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        int n = nums.length;
        // -4 -1 -1 0 1 2
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        for(int i = 0; i < n - 2; i++) {
            for(int j = i + 1; j < n - 1; j++) {
                int target = -(nums[i] + nums[j]);

                //
                int idx = lowerBound(nums, target, j + 1, n);
                if(idx == -1) {
                    continue;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[idx]);
                    ans.add(list);
                }
            }
        }
        return new ArrayList<>(ans);
    }
    public int lowerBound(int[] nums, int target, int l, int r) {
        int n = nums.length;
        while(l < r) {
            int m = (l + r) >>> 1;
            if(nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        if(l == n || nums[l] != target) {
            return -1;
        }
        return l;
    }
    // 2. 双指针
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length < 3) {
            return ans;
        }
        int n = nums.length;
        // -4 -4 -4 -1 -1 -1 0 0 0 1 1 1 2 2 2
        Arrays.sort(nums);
        for(int i = 0; i < n - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = n - 1;
            int target = -nums[i];
            while(l < r) {
                if(nums[l] + nums[r] == target) {
                    if(l > i + 1 && nums[l] == nums[l - 1]) {
                        l++;
                        continue;
                    }
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]); list.add(nums[l]); list.add(nums[r]);
                    ans.add(list);
                    l++;r--;
                } else if(nums[l] + nums[r] < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return ans;
    }


    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int target = -nums[i];
            int r = n - 1;
            for(int l = i + 1; l < n; l++) {
                if(l > i + 1 && nums[l - 1] == nums[l]) {
                    continue;
                }
                while(l < r && nums[l] + nums[r] > target) {
                    r--;
                }
                if(l == r) {
                    break;
                }
                if(nums[l] + nums[r] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]); list.add(nums[l]); list.add(nums[r]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
