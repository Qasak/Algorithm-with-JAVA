package leetcode.contest.Rating2300.贪心;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/26 10:42
 */

// LCS + LIS的思想
// 当其中一个数组元素各不相同时，最长公共子序列问题（LCS）可以转换为最长上升子序列问题（LIS）进行求解。同时最长上升子序列问题（LIS）存在使用「维护单调序列 + 二分」的贪心解法，复杂度为 O(n\log{n})O(nlogn)。
public class Q1713_得到子序列的最少操作次数 {
    public int minOperations(int[] target, int[] arr) {
        // n - LCS == min
        int n = target.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(target[i], i);
        }
        // f[len] : 长度为len的LIS的最后一个元素的值
        int[] f = new int[n + 1];
        f[0] = -1;
        int len = 0;
        for(int i : arr) {
            if(map.containsKey(i)) {
                int idx = map.get(i);
                if(idx > f[len]) {
                    f[++len] = idx;
                } else {
                    int l = 0, r = len;
                    // 找到第一个小于idx的位置l
                    while(l < r) {
                        int m = (l + r + 1) >>> 1;
                        if(f[m] >= idx) {
                            r = m - 1;
                        } else {
                            l = m;
                        }
                    }
                    f[l + 1] = idx;
                }
            }
        }
        return n - len;
    }
    public static void main(String[] args) {
        List<Integer> d = new ArrayList<Integer>();
        d.set(8,1);
        System.out.println(d);
    }
}
