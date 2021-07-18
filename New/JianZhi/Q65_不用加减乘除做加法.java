package leetcode.JianZhi;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/18 9:12
 */
public class Q65_不用加减乘除做加法 {
    public int add(int a, int b) {
        while(b != 0) {
            // 进位和
            int c = (a & b) << 1;
            // 非进位和
            a ^= b;
            b = c;
        }
        return a;
    }
}
