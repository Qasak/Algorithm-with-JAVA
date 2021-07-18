package leetcode.JianZhi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/12 23:44
 */
public class Q16 {
    // 注意n可以取到
    // 2.00000
    // -2147483648
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Math.abs(1);
    }
}
