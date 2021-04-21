package leetcode.template.BinSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/5 22:47
 */
public class Q51O_ReversePair {
    public int reversePairs(int[] nums) {
        int ans = 0;
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i = n - 1; i >= 0; i--) {
            int idx = lowerBound(list, nums[i]);
            ans += idx;
            list.add(idx, nums[i]);
        }
        return ans;
    }
    private int lowerBound(List<Integer> list, int target) {
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
}
