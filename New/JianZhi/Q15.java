package leetcode.JianZhi;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/12 23:43
 */
public class Q15 {
    public int hammingWeight(int n) {
        int cnt = 0;
        while(n != 0) {
            if((n & 1) == 1) {
                cnt++;
            }
            n >>>= 1;
        }
        return cnt;
    }
}
