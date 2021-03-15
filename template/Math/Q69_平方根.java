package leetcode.template.Math;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/5 15:08
 */
public class Q69_平方根 {
    public int mySqrt(int x) {
        long l = 0, r = x / 2 + 1;
        while(l < r) {
            long m = (l + r) >>> 1;
            if(m * m < x) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return (int) (l * l > x ? l - 1 : l);
    }

    public int mySqrt1(int x) {
        if(x <= 1) {
            return x;
        }
        int l = 0, r = x / 2 + 1;
        while(l < r) {
            int m = (l + r) >>> 1;
            if(m < x / m) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l > x / l ? l - 1 : l;
    }

    public int mySqrt2(int x) {
        if(x <= 1) {
            return x;
        }
        int l = 0, r = x / 2 + 1;
        while(l < r) {
            int m = (l + r) >>> 1;
            if(m < x / m) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        // l : l * l >= x 的第一个数
        return l == x / l ? l : l - 1;
    }
    public static void main(String[] args) {
        Math.sqrt(3);
    }
}
