package leetcode.contest.NiceProblem.二分应用;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/11 18:45
 */
public class Q274_H指数 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        // System.out.println(Arrays.toString(citations));
        int l = 0, r = n - 1;
        while(l < r) {
            int m = (l + r) >>> 1;
            if(citations[m] < n - m) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return Math.min(citations[l], n - l);
    }
}
