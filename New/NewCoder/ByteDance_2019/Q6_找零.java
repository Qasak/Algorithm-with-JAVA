package NewCoder.ByteDance_2019;

import java.util.Scanner;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/31 18:03
 */

/*
Z国的货币系统包含面值1元、4元、16元、64元共计4种硬币，以及面值1024元的纸币。现在小Y使用1024元的纸币购买了一件价值为N(0, 1024])的商品，请问最少他会收到多少硬币？

输入例子1:
200

输出例子1:
17

花200，需要找零824块，找12个64元硬币，3个16元硬币，2个4元硬币即可。
* */
public class Q6_找零 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = 1024 - n;
        int cnt = 0;
        while(m >= 64) {
            m -= 64;
            cnt++;
        }
        while(m >= 16) {
            m -= 16;
            cnt++;
        }

        while(m >= 4) {
            m -= 4;
            cnt++;
        }

        while(m > 0) {
            m -= 1;
            cnt++;
        }
        System.out.println(cnt);
    }
}
