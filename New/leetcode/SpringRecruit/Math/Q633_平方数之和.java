package leetcode.SpringRecruit.Math;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/28 9:51
 */
public class Q633_平方数之和 {
    // 1. 双指针
    public boolean judgeSquareSum(int c) {
        int l = 0, r = (int) Math.sqrt(c) + 1;
        while(l <= r) {
            if(c - l * l == r * r) {
                return true;
            } else if(l * l  < c - r * r) {
                l++;
            } else {
                r--;
            }
        }
        return false;
    }
    // 费马平方和
    //当且仅当一个自然数的质因数分解中，满足 4k+3 形式的质数次方数均为偶数时，该自然数才能被表示为两个平方数之和。
    public boolean judgeSquareSum1(int c) {
        for (int i = 2; i * i <= c; i++) {
            int cnt = 0;
            while (c % i == 0) {
                cnt++;
                c /= i;
            }
            if (i % 4 == 3 && cnt % 2 != 0) {
                return false;
            }
        }
        return c % 4 != 3;
    }

}
