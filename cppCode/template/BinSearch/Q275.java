package leetcode.template.BinSearch;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/22 10:06
 */
public class Q275 {
    public int hIndex(int[] arr) {
        int ans = 0;
        int n = arr.length;
        int l = 0, r = arr.length;
        while(l < r) {
            int m = (l + r) >>> 1;
            if(arr[m] < n - m) {
                l = m + 1;
            } else {
                if(arr[m] == n - m) {
                    return n - m;
                }
                r = m;
            }
        }
        return n - l;
    }
}
