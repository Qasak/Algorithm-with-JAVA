package Mitsuha.序列DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/11 12:19
 */
public class Q368_最大整除子集 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int len = 0;
        int idx = 0;
        List<TreeSet<Integer>> f = new ArrayList<>();
        f.add(new TreeSet<>());
        f.get(0).add(nums[0]);
        for(int i = 1; i < n; i++) {
            TreeSet<Integer> cur = new TreeSet<>();
            int pre = -1;
            int size = 0;
            for(int j = 0; j < i; j++) {
                if(f.get(j).last() % nums[i] == 0 || nums[i] % f.get(j).last() == 0) {
                    if(f.get(j).size() > size) {
                        pre = j;
                        size = f.get(j).size();
                    }
                }
            }

            if(pre != -1)
                cur.addAll(f.get(pre));
            cur.add(nums[i]);
            f.add(cur);
            if(cur.size() > len) {
                len = cur.size();
                idx = i;
            }

        }
        return new ArrayList<>(f.get(idx));
    }
}
