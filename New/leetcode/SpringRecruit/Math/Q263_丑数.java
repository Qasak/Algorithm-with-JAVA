package leetcode.SpringRecruit.Math;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/10 11:14
 */
public class Q263_丑数 {
    public boolean isUgly(int n) {
        if(n <= 0) {
            return false;
        }
        while(n != 0) {
            if(n == 1) {
                return true;
            }
            if(n % 2 == 0) {
                n /= 2;
            } else if(n % 3 == 0) {
                n /= 3;
            } else if(n % 5 == 0) {
                n /= 5;
            } else {
                return false;
            }
        }
        return true;
    }
}
