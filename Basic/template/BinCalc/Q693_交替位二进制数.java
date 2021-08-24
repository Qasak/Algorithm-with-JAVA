package leetcode.template.BinCalc;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/22 14:15
 */
public class Q693_交替位二进制数 {
    public boolean hasAlternatingBits(int n) {
        int pre = n & 1;
        int cnt = 0;
        for(int i = 0; i < 32; i++) {
            if(((n >> (31 - i)) & 1) == 0) {
                cnt++;
            } else {
                break;
            }
        }
        int m = 32 - cnt;
        for(int i = 1; i < m; i++) {
            if((pre ^ ((n >> i) & 1)) == 0) {
                return false;
            }
            pre = ((n >> i) & 1);
        }
        return true;
    }

    public boolean hasAlternatingBits1(int n) {
        int m = ((n >>> 1) ^ n);
        return ((m & (m + 1)) == 0);
    }
}
