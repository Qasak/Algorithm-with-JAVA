package Mitsuha.数位DP;

import java.util.Scanner;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/13 11:15
 */
public class Q233_数字1的个数 {
    // 数字1的个数
    public static int countDigitOne(int n) {
        long cur = 1;
        int ans = 0;
        // 按十进制每位计算1的个数
        while(n >= cur) {
            long nxt = cur * 10;
            // [100, 199]
            ans += (n / nxt) * cur;
            long rem = n % nxt;
            if(rem >= cur * 2) {
                ans += cur;
            } else if(rem >= cur){
                ans += rem - cur + 1;
            }
            cur = nxt;
        }
        return ans;
    }
    // 数字x的个数
    public static int countX(int n, int x) {
        long cur = 1;
        int ans = 0;
        while(n >= cur) {
            long nxt = cur * 10;
            long rem = n % nxt;
            long pre = n / nxt;
            // 第一个数位不能为0
            if(x == 0 && pre == 0) {
                return ans;
            }
            // 排除前缀全为0的情况
            ans += x == 0 ? (pre - 1) * cur : pre * cur;

            if(rem >= cur * (x + 1)) {
                ans += cur;
            } else if(rem >= cur * x) {
                ans += rem - cur * x + 1;
            }
            cur = nxt;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countX(14, 7));
    }
}
