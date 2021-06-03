package leetcode.contest.NiceProblem;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/1 14:08
 */
public class Q1744_你能在最喜欢的那天吃到最喜欢的糖果吗 {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int m = queries.length;
        boolean[] ans = new boolean[m];
        int n = candiesCount.length;
        long[] pre = new long[n + 1];
        for(int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + candiesCount[i];
        }
        for(int i = 0; i < m; i++) {
            // 每天至少吃一颗：前i类糖果总量 > 查询天数
            // 前i - 1类糖果总量 < 最多能吃的总量
            ans[i] = (pre[queries[i][0] + 1] > (long) queries[i][1]) && (pre[queries[i][0]] < ((long) (queries[i][1] + 1)) * ((long) queries[i][2]));
        }
        return ans;
    }
}
