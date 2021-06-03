package leetcode.contest.NiceProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/3 0:22
 */
public class Q525_连续数组 {
    public static int findMaxLength(int[] nums) {
        // 若[i, j] 区间含有相同数量的0和1 则：2倍区间和 == 区间长度
        // 2 * (pre[j + 1] - pre[i]) == j - i + 1;
        // 2 * pre[j + 1] - (j + 1) == 2 * pre[i] - i
        int n = nums.length;
        int s = 0;
        int ans = 0;

        // 当前key： 下标
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            s += nums[i];
            int cur = 2 * s - (i + 1);
            if(map.containsKey(cur)) {
                ans = Math.max(ans, i - map.get(cur) + 1);
            } else {
                map.put(cur, i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,1,0,0,1,0,0,1,0,0,1,0,1,0,0,1,0,1,0,1,0,0,1,0};
        System.out.println(findMaxLength(nums));
    }
}
