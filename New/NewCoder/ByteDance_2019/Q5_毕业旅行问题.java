package NewCoder.ByteDance_2019;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/31 17:31
 */

// 小明目前在做一份毕业旅行的规划。打算从北京出发，分别去若干个城市，然后再回到北京，每个城市之间均乘坐高铁，且每个城市只去一次。由于经费有限，希望能够通过合理的路线安排尽可能的省一些路上的花销。给定一组城市和每对城市之间的火车票的价钱，找到每个城市只访问一次并返回起点的最小车费花销。
//
//输入描述:
//城市个数n（1<n≤20，包括北京）
//
//城市间的车票价钱 n行n列的矩阵 m[n][n]
//
//输出描述:
//最小车费花销 s
//
//输入例子1:
    /*
4
0 2 6 5
2 0 4 4
6 4 0 2
5 4 2 0
    * */

//
//输出例子1:
//13
//
//例子说明1:
//共 4 个城市，城市 1 和城市 1 的车费为0，城市 1 和城市 2 之间的车费为 2，城市 1 和城市 3 之间的车费为 6，城市 1 和城市 4 之间的车费为 5，依次类推。假设任意两个城市之间均有单程票可购买，且票价在1000元以内，无需考虑极端情况。
public class Q5_毕业旅行问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++) {
            String[] t = sc.nextLine().split(" ");
            for(int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(t[j]);
            }
        }
        System.out.println(tsp(n, matrix));
    }
    public static int tsp(int n, int[][] d) {
        int[][] dp = new int[n][1 << n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 0x3f3f3f3f);
        }
        dp[0][0] = 0;
        for(int s = 1; s < (1 << n); s++) {
            for(int u = 0; u < n; u++) {
                for(int v = 0; v < n; v++) {
                    if(((s >> v) & 1) == 0) {
                        continue;
                    }
                    dp[v][s] = Math.min(dp[v][s], dp[u][s - (1 << v)] + d[u][v]);
                }
            }
        }
        return dp[0][(1 << n) - 1];
    }
}
