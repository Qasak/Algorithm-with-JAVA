package ACWing;

import java.util.Scanner;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/5/15 13:47
 */
public class Q3_完全背包问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cap = sc.nextInt();
        int[] wei = new int[n];
        int[] val = new int[n];
        for(int i = 0; i < n; i++) {
            wei[i] = sc.nextInt();
            val[i] = sc.nextInt();
        }
        // f[i][j] : 对于前i个物品，容量为 j 时的最大价值
        int[] f = new int[cap + 1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= cap; j++) {
                if(i == 0) {
                    f[j] = j >= wei[i] ? val[i] : 0;
                    continue;
                }
                if(j >= wei[i]) {
                    f[j] = Math.max(f[j - wei[i]] + val[i], f[j]);
                }

            }
        }
        System.out.println(f[cap]);
    }
}
