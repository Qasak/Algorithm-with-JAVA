package leetcode.SpringRecruit.DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/15 11:30
 */
public class Q256_粉刷房子 {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int ans = Integer.MAX_VALUE;
        int a = costs[0][0];
        int b = costs[0][1];
        int c = costs[0][2];
        for(int i = 1; i < n; i++) {
            int aa = a, bb = b, cc = c;
            a = Math.min(bb + costs[i][0], cc + costs[i][0]);
            b = Math.min(aa + costs[i][1], cc + costs[i][1]);
            c = Math.min(bb + costs[i][2], aa + costs[i][2]);
        }
        return Math.min(Math.min(a, b), c);
    }
}
