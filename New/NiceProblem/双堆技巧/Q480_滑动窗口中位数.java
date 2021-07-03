package leetcode.contest.NiceProblem.双堆技巧;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/2 13:17
 */
public class Q480_滑动窗口中位数 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int idx = 0;
        double[] ans = new double[n - k + 1];
        for(int i = 0; i < n; i++) {
            if(i >= k - 1) {
                list.add(bs(list, nums[i]), nums[i]);
                if(i == k - 1) {
                    Collections.sort(list);
                }
                ans[idx++] = (list.get(k / 2)* 1.0 + list.get((k - 1) / 2) * 1.0)  / 2;
                list.remove(bs(list, nums[i - k + 1]));
            } else {
                list.add(nums[i]);
            }
        }
        return ans;
    }
    public int bs(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while(l < r) {
            int m = (l + r) >>> 1;
            if(list.get(m) < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
    public static void main(String[] args) {
        String s = "aa";
        List<Character> list = new ArrayList<>();
        int[] cnt = new int[128];

        for(char c : s.toCharArray()) {
            list.add(c);
            cnt[c]++;
        }
        Collections.sort(list, (a, b) -> (cnt[b] - cnt[a]));
        char[] tmp = new char[list.size()];
        for(int i = 0; i < list.size(); i++) {
            tmp[i] = list.get(i);
        }
    }
}
