package leetcode.SpringRecruit.Search;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/9 16:27
 */
public class Q69_X的平方根 {
    // 1. 二分
    public int mySqrt(int x) {
        if(x == 0 || x == 1) {
            return x;
        }
        int l = 0, r = x;
        while(l <= r) {
            int m = (l + r) >>> 1;
            // 防止溢出
            if(m == x / m) {
                return m;
            } else if(m > x / m) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l == x / l ? l : l - 1;
    }
    // 2. 牛顿迭代
    public int mySqrt1(int x) {
        if (x == 0) {
            return 0;
        }

        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }

}
