package leetcode.template.Math;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/16 16:31
 *
 * n阶乘有多少个0？
 */
// 1 2 6 24 120 720 5760 4xx0
// 1 2 3 4 5    6   7   8    9    10
public class _16_05 {
    public int Zeros(int n) {
        int ans = 0;
        while(n > 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }
}
