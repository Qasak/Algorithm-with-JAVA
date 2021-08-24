package leetcode.template.BinSearch;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/7 12:36
 */
public class Q69_Sqrt {
    // 二分
    public int mySqrt(int x) {
        if(x <= 1) {
            return x;
        }
        int l = 0, r = x;
        int ans = 0;
        // target * target <= x 的最大值
        // [0, x] 递增区间
        while(l <= r) {
            int m = (l + r) >>> 1;
            if(m <= x / m) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }
    public int mySqrt1(int x) {
        int l = 0, r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l-1;
    }
    // 牛顿迭代

    public static void main(String[] args) {
        System.out.println(Math.sqrt(4));
    }
}
