package leetcode.contest.Rating1800.前缀和;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/25 15:59
 */
public class Q1744_你能在你最喜欢的那天吃到你最喜欢的糖果吗 {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;
        int m = queries.length;
        long[] pre = new long[n + 1];
        for(int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + candiesCount[i];
        }
        boolean[] ans = new boolean[m];
        for(int i = 0; i < m ;i++) {
            ans[i] = check(candiesCount, queries[i], pre);
        }

        return ans;
    }

    boolean check(int[] candiesCount, int[] query, long[] pre) {
        int type = query[0], day = query[1], cap = query[2];
        long min = day, max = cap * (day + 1), pSum = pre[type], sum = pre[type + 1];
        // if(max < 0) {
        //     max = Long.MAX_VALUE;
        // }
        // System.out.println(sum + " " + pSum + " " + min + " " + max);
        // min : 至少要吃多少个
        // max : 最多吃多少个
        if(sum <= min || pSum / cap > day) {
            return false;
        }
        return true;
        // int l = 0, r = candiesCount.length;
        // while(l < r) {
        //     int m = (l + r) >>> 1;

        // }
    }
}
