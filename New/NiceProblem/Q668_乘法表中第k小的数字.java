package leetcode.contest.NiceProblem;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/16 18:17
 */
public class Q668_乘法表中第k小的数字 {
    public int findKthNumber(int m, int n, int k) {
        int l = 1, r = m * n;
        while(l < r) {
            int mid = (l + r) >>> 1;
            if(check(m, n, mid, k)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    // 检查mid是否是第k个或大于第k个
    private boolean check(int m, int n, int mid, int k) {
        int i = m, j = 1;
        int num = 0;
        while(i >= 1 && j <= n) {
            if(i * j <= mid) {
                num += i;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }
}
