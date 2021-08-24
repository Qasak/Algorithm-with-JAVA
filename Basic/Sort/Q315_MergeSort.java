package leetcode.template.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/3 15:31
 */
public class Q315_MergeSort {
    int[] idx;
    int[] res;
    int[] tmp;
    public List<Integer> countSmaller(int[] nums) {
        // nums数组：
        // 5 2 6 1
        // 2 5 1 6
        // 1 2 5 6

        // idx数组：
        // 0 1 2 3
        // 1 0 3 2
        // 3 1 0 2
        int n = nums.length;
        idx = new int[n];
        res = new int[n];
        tmp = new int[n];
        for(int i = 0; i < n; i++) {
            idx[i] = i;
        }

        mergeSort(nums, 0, n - 1);


        List<Integer> ans = new ArrayList<>();
        for(int i : res) {
            ans.add(i);
        }
        return ans;
    }

    public void mergeSort(int[] nums, int l, int r) {
        if(l >= r) {
            return;
        }
        int len = r - l + 1;
        int m = (l + r) >>> 1;
        // 长度为奇数时，左边多一个
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, r);
        int p1 = l;
        int p2 = m + 1;
        int i = l;
        while(p1 <= m && p2 <= r) {
            if(nums[idx[p1]] <= nums[idx[p2]]) {
                res[idx[p1]] += p2 - m - 1;
                tmp[i++] = idx[p1++];
            } else {
                tmp[i++] = idx[p2++];
            }
        }
        while(p1 <= m) {
            res[idx[p1]] += p2 - m - 1;
            tmp[i++] = idx[p1++];
        }
        while(p2 <= r) {
            tmp[i++] = idx[p2++];
        }
        for(int j = l; j <= r; j++) {
            idx[j] = tmp[j];
        }
    }

}
