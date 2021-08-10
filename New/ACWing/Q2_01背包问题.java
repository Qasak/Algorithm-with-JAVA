package ACWing;

import java.util.Scanner;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/5/15 12:32
 */
public class Q2_01背包问题 {

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
            for(int j = cap; j >= wei[i]; j--) {
                f[j] = Math.max(f[j - wei[i]] + val[i], f[j]);
            }
        }
        System.out.println(f[cap]);
    }

    public static void main1(String[] args) {
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
        int[][] f = new int[n][cap + 1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= cap; j++) {
                if(i == 0) {
                    f[i][j] = j >= wei[i] ? val[i] : 0;
                    continue;
                }
                if(j >= wei[i]) {
                    f[i][j] = Math.max(f[i - 1][j - wei[i]] + val[i], f[i - 1][j]);
                } else {
                    f[i][j] = f[i - 1][j];
                }

            }
        }
        System.out.println(f[n - 1][cap]);
    }
}


