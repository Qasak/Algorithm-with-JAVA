package leetcode.contest.NiceProblem;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/9 1:45
 */
public class Q879_盈利计划 {
    // 题面：
    // 第 i 种工作会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与。如果成员参与了其中一项工作，就不能参与另一项工作。
    // 工作的任何至少产生 minProfit 利润的子集称为 盈利计划

    // 暗示  f[前i个工作][j名工人参与][至少k利润]
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        // 01背包扩展
        // dp[j][k] 表示在前 i 个工作中选择了 j 个员工，并且满足工作利润[至少为 k] 的情况下的盈利计划的总数目
        // j = [0, n]
        // ∑ dp[j][minProfit]
        int m = group.length;
        int mod = (int) 1e9 + 7;
        int[][][] f = new int[m + 1][n + 1][minProfit + 1];
        f[0][0][0] = 1;
        for(int i = 1; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                for(int k = 0; k <= minProfit; k++) {
                    // 工人数量超过第i个工作的需要人数才可以开展当前工作i
                    if(j >= group[i - 1]) {
                        // 这 第i个工作对应的利润可以超过k
                        f[i][j][k] = f[i - 1][j][k] + f[i - 1][j - group[i - 1]][Math.max(0, k - profit[i - 1])];
                        if(f[i][j][k] >= mod) {
                            f[i][j][k] -= mod;
                        }
                    } else {
                        f[i][j][k] = f[i - 1][j][k];
                    }
                }
            }
        }
        int ans = 0;
        for(int j = 0; j <= n; j++) {
            ans += f[m][j][minProfit];
            if(ans >= mod) {
                ans -= mod;
            }
        }
        return ans;
    }

    // 滚动数组优化 : 01背包 反向
    public int profitableSchemes1(int n, int minProfit, int[] group, int[] profit) {
        // 当采用二维动态规划解法时，对于最小工作利润为 0 的情况，无论当前在工作的员工有多少人，我们总能提供一种方案，所以初始化dp[i][0]=1。
        int m = group.length;
        int mod = (int) 1e9 + 7;
        int[][] f = new int[n + 1][minProfit + 1];
        f[0][0] = 1;
        for(int i = 0; i < m; i++) {
            for(int j = n; j >= group[i]; j--) {
                for(int k = 0; k <= minProfit; k++) {
                    // 工人数量超过第i个工作的需要人数才可以开展当前工作i
                    // 这 第i个工作对应的利润可以超过k
                    f[j][k] = f[j][k] + f[j - group[i]][Math.max(0, k - profit[i])];
                    if(f[j][k] >= mod) {
                        f[j][k] -= mod;
                    }
                }
            }
        }
        int ans = 0;
        for(int j = 0; j <= n; j++) {
            ans += f[j][minProfit];
            if(ans >= mod) {
                ans -= mod;
            }
        }
        return ans;
    }


    // 利润恰好为k的写法
    /**
     问题的本质是：从group选择子集G，对应的profit子集为P。满足sum(G)<=n, 且sum(P)>=minProfit。G有多少种选择法？
     相当于容量为n的01背包问题。
     dp[i][j][k]表示前i种工作，总人数为j时，使得利润为k的计划的数量。
     1.做第i种工作：dp[i][j][k] += dp[i-1][j-group[i-1]][k-profit[i-1]]
     2.不做第i种工作：dp[i][j][k] += dp[i-1][j][k]
     */
    public int profitableSchemes2(int n, int minProfit, int[] group, int[] profit) {
        int MOD = 1000000007;
        int sum = 0; // 最大利润
        for (int p: profit) {
            sum += p;
        }
        int[][] pre = new int[n+1][sum+1];
        for (int j=0; j<=n; ++j) {
            pre[j][0] = 1;    // 最小利润为0时，计划数量为1，就是不做任何工作
        }
        for (int i=1; i<=group.length; ++i){
            int[][] curr = new int[n+1][sum+1];
            curr[0][0] = 1;    // 最小利润为0时，计划数量为1，就是不做任何工作
            for (int j=1; j<=n; ++j){
                for (int k=0; k<=sum; ++k){
                    if (j-group[i-1]>=0 && k-profit[i-1]>=0) {
                        curr[j][k] = (pre[j][k]+pre[j-group[i-1]][k-profit[i-1]])%MOD;
                    } else {
                        curr[j][k] = pre[j][k];
                    }
                }
            }
            pre = curr;
        }
        int ans = 0;    // 统计所有工作，总人数为n时，利润>=minProfit的总计划数
        for (int i=minProfit; i<=sum; ++i) {
            ans = (ans+pre[n][i])%MOD;
        }
        return ans;
    }
}
