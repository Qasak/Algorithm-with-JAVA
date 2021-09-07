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
        // f[i] : 以i结尾的元素的最大整除子集
        List<TreeSet<Integer>> f = new ArrayList<>();
        f.add(new TreeSet<>());
        f.get(0).add(nums[0]);
        for(int i = 1; i < n; i++) {
            TreeSet<Integer> cur = new TreeSet<>();
            int pre = -1;
            int size = 0;
            for(int j = 0; j < i; j++) {
                if(nums[i] % f.get(j).last() == 0) {
                    if(f.get(j).size() > size) {
                        pre = j;
                        size = f.get(j).size();
                    }
                }
            }

            if(pre != -1) {
                cur.addAll(f.get(pre));
            }
            cur.add(nums[i]);
            f.add(cur);
            if(cur.size() > len) {
                len = cur.size();
                idx = i;
            }

        }
        return new ArrayList<>(f.get(idx));
    }

    // 当我们决策到某一个数 nums[i] 时（nums 已排好序），我们无法直接将 nums[i] 直接接在符合「约数关系」的、最靠近位置 i 的数后面，
    // 而是要检查位置 i 前面的所有符合「约数关系」的位置，找一个已经形成「整除子集」长度最大的数。
    public List<Integer> largestDivisibleSubset1(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        // 以i结尾的元素的最大子集长度
        int[] f = new int[n];
        // 以i结尾的元素从哪里转移来
        int[] g = new int[n];
        // 最大长度及其元素下标
        int max = 1;
        int idx = 0;
        Arrays.fill(f, 1);
        for(int i = 1; i < n; i++) {
            int len = 1, pre = i;
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0 && f[j] + 1 > len) {
                    pre = j;
                    len = f[j] + 1;
                }

            }
            if(len > max) {
                max = len;
                idx = i;
            }
            g[i] = pre;
            f[i] = len;
        }
        List<Integer> ans = new ArrayList<>();
        while(ans.size() < max) {
            ans.add(nums[idx]);
            idx = g[idx];
        }
        return ans;
    }
}
