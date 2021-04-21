package leetcode.template.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/10 0:51
 */
public class Q163_FindMissingRanges {
    // 9ms
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        // [  []  ]
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        if(n == 0) {
            if(lower == upper) {
                ans.add(lower + "");
            } else {
                ans.add(lower + "->" + upper);
            }
            return ans;
        }
        if(nums[0] > lower) {
            if(nums[0] - lower == 1) {
                ans.add(lower + "");
            } else {
                ans.add(lower + "->" + (nums[0] - 1));
            }
        }

        for(int i = 0; i < n; i++) {
            int j = i;
            while(j < n - 1 && nums[j + 1] - nums[j] <= 1) {
                j++;
            }
            if(j == n - 1) {
                break;
            }
            if(nums[j + 1] - nums[j] == 2) {
                ans.add((nums[j] + 1) + "");
            } else {

                ans.add((nums[j] + 1) + "->" + (nums[j + 1] - 1));
            }
            i = j;
        }
        if(nums[n - 1] < upper) {
            if(upper - nums[n - 1] == 1) {
                ans.add(upper + "");
            } else {
                ans.add((nums[n - 1] + 1) + "->" + upper);
            }
        }
        return ans;
    }
    // 1ms
    public List<String> findMissingRanges1(int[] nums, int lower, int upper) {
        // 1ms
        List<String> res = new ArrayList<>();
        long l=lower, u=upper;
        for(int i=0;i<nums.length;i++){
            if(nums[i]-l==1) {
                res.add(String.valueOf(l));
            } else if(nums[i]-l > 1) {
                res.add(l + "->" + (nums[i]-1));
            }
            l=(long)nums[i]+1; // 这步一定需要强制转换,因为num[i]和1都是int型,计算结果也为int型再赋给l,需提前进行类型转换
        }
        if(l==u) {
            res.add(String.valueOf(l));
        } else if(l<u) {
            res.add(l + "->" + u);
        }
        return res;
    }
}
