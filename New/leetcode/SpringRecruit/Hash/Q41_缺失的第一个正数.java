package leetcode.SpringRecruit.Hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/11 22:28
 */
public class Q41_缺失的第一个正数 {
    // 排序
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 1;
        }
        Arrays.sort(nums);
        int i = 0;
        for(; i < n; i++) {
            if(nums[i] > 0) {
                break;
            }
        }
        int j = 1;
        for(; i < n; i++) {
            if(i + 1 < n && nums[i] == nums[i + 1]) {
                continue;
            }
            if(nums[i] != j) {
                return j;
            } else {
                j++;
            }
        }
        return nums[n - 1] < 0 ? 1 : nums[n - 1] + 1;
    }
    // HashSet
    // 对于一个长度为 N 的数组，其中没有出现的最小正整数只能在 [1, N+1] 中。这是因为如果 [1, N] 都出现了，那么答案是 N+1，否则答案是 [1, N] 中没有出现的最小正整数。
    //

    public int firstMissingPositive1(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 1;
        }
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
        }
        for(int i = 1; i <= n; i++) {
            if(!set.contains(i)) {
                return i;
            }
        }
        return n + 1;
    }
    // 自哈希

    // [1, N]
    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for(int i = 0; i < n; i++) {
            if(Math.abs(nums[i]) <= n) {
                nums[Math.abs(nums[i]) - 1] = -Math.abs((nums[Math.abs(nums[i]) - 1]));
            }
        }
        for(int i = 0; i < n; i++) {
            if(nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
