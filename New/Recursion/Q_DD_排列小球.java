package leetcode.SpringRecruit.Recursion;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/30 17:23
 */
public class Q_DD_排列小球 {
    // 1. 回溯 超时

    // 2. 记忆化
    // 记录当前每个球的剩余个数以及上一个球的种类
    // aaaaa bbbbb ccccc
    // acb acb cab acb cab
    public static Map<String, Long> map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new HashMap<>();
        String[] nums = null;
        while(sc.hasNext()) {
            String line = sc.nextLine();
            nums = line.split(" ");
            int a = Integer.valueOf(nums[0]);
            int b = Integer.valueOf(nums[1]);
            int c = Integer.valueOf(nums[2]);
            System.out.println(getPerm(a, b, c, 0));
        }
    }
    public static long getPerm(int a, int b, int c, int last) {
        String t = a + " " + b + " " + c + " " + last;
        if(a == 0 && b == 0 && c == 0) {
            return 1;
        }
        if(a < 0 || b < 0 || c < 0) {
            return 0;
        }
        if(map.containsKey(t)) {
            return map.get(t);
        }
        long val = 0;
        if(a > 0 && last != 1) {
            val += getPerm(a - 1, b, c, 1);
        }
        if(b > 0 && last != 2) {
            val += getPerm(a, b - 1, c, 2);
        }
        if(c > 0 && last != 3) {
            val += getPerm(a, b, c - 1, 3);
        }
        map.put(t, val);
        return val;
    }


    // 3. DP
    class Solution{
        public void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int[] n = new int[3];
            n[0] = in.nextInt();
            n[1] = in.nextInt();
            n[2] = in.nextInt();
            long[][][][] dp = new long[3][n[0] + 1][n[1] + 1][n[2] + 1];
            dp[0][1][0][0] = 1L;
            dp[1][0][1][0] = 1L;
            dp[2][0][0][1] = 1L;
            for (int i = 0; i <= n[0]; i++) {
                for (int j =0; j <= n[1]; j++) {
                    for (int k = 0 ;k <= n[2];k++) {
                        dp[0][i][j][k] = Math.max(dp[0][i][j][k], (i - 1 < 0) ? (0L) : (dp[1][i - 1][j][k] + dp[2][i - 1][j][k]));
                        dp[1][i][j][k] = Math.max(dp[1][i][j][k], (j - 1 < 0) ? (0L) : (dp[0][i][j - 1][k] + dp[2][i][j - 1][k]));
                        dp[2][i][j][k] = Math.max(dp[2][i][j][k], (k - 1 < 0) ? (0L) : (dp[0][i][j][k - 1] + dp[1][i][j][k - 1]));
                        //System.out.println(dp[0][i][j][k] + " " + dp[1][i][j][k] + " " + dp[2][i][j][k]);
                    }
                }
            }
            System.out.println(dp[0][n[0]][n[1]][n[2]] + dp[1][n[0]][n[1]][n[2]] + dp[2][n[0]][n[1]][n[2]]);
        }
    }
}
