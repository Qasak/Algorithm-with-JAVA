package leetcode.template.BinSearch;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/7 12:04
 */
public class Q50_Pow {
    // O(logn)
    public double myPow(double x, int n) {
        double ans = 1;
        // 2 ^ 10       x    ans
        //     1010     2    1
        //     101      4    4
        //     10       16   4
        //     1        256  1024
        long nn = n;
        if(nn < 0) {
            nn = -nn;
            x = 1 / x;
        }
        while(nn > 0) {
            if((nn & 1) == 1) {
                ans *= x;
            }
            x *= x;
            nn >>= 1;
        }
        return ans;
    }
    // 负数从下面逼近0
    // 正数从上面逼近0
    public double myPow1(double x, int n) {
        double res = 1.0;
        for(int i = n; i != 0; i /= 2){
            if(i % 2 != 0){
                res *= x;
            }
            x *= x;
        }
        return  n < 0 ? 1 / res : res;
    }
}
