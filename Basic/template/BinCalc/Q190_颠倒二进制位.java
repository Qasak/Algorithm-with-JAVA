package leetcode.template.BinCalc;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/22 13:41
 */
public class Q190_颠倒二进制位 {
    public int reverseBits(int n) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            ans |= ((n >> (31 - i)) & 1) << i;
        }
        return ans;
    }
}
