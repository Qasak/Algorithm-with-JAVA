package leetcode.contest.NiceProblem;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/4 17:56
 */
public class Q209_长度最小的子数组 {

    // 前缀和 + treeset
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        int[] pre = new int[n + 1];
        for(int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        TreeSet<int[]> set = new TreeSet<>((a, b) -> a[0] - b[0]);
        set.add(new int[]{0, -1});
        for(int i = 0; i < n; i++) {
            // floor 小于等于cur中最大的数
            // ceiling 大于等于cur 中最小的数
            // [floor, cur, ceiling]
            int[] t = set.floor(new int[]{pre[i + 1] - target, 0});

            if(t != null) {
                // System.out.println(t[0] + " " + (pre[i + 1] - target));
                ans = Math.min(ans, i - t[1]);
            }
            set.add(new int[]{pre[i + 1], i});
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    // 滑动窗口 + 前缀和
    public int minSubArrayLen1(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        int l = 0;
        int cur = 0;
        for(int r = 0; r < n; r++) {
            cur += nums[r];
            while(l <= r && cur >= target) {
                ans = Math.min(ans, r - l + 1);
                cur -= nums[l++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    public static void main(String[] args) {
    }
}
