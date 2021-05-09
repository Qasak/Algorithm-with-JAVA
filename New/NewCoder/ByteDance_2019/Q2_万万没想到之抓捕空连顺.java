package NewCoder.ByteDance_2019;

import java.util.Scanner;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/1 10:25
 */
public class Q2_万万没想到之抓捕空连顺 {
    static int MOD = 99997867;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long ans = 0;
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        for(int i = 0, j = 2 ; j < n; j++) {
            while(i < j && nums[j] - nums[i] > d) {
                i++;
            }
            if(j - i + 1 >= 3) {
                ans += CN2(j - i);
                ans %= MOD;
            }
        }
        System.out.println(ans);
    }
    public static long CN2(int n) {
        if(n < 2) {
            return 0;
        }
        long nn = n;
        return (nn * (nn - 1) / 2) ;
    }
}
