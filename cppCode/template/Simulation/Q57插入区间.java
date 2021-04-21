package leetcode.template.Simulation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/8 23:29
 */
public class Q57插入区间 {
    public int[][] insert(int[][] nums, int[] seg) {
        int n = nums.length;
        int l = seg[0];
        int r = seg[1];
        boolean flag = false;
        List<int[]> ans = new ArrayList<>();
        for(int[] t : nums) {
            if(t[1] < l) {
                ans.add(t);
            } else if(t[0] > r) {
                if(!flag) {
                    flag = true;
                    ans.add(new int[]{l, r});
                }
                ans.add(t);
            } else {
                l = Math.min(l, t[0]);
                r = Math.max(r, t[1]);
            }
        }
        if(!flag) {
            ans.add(new int[]{l, r});
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
