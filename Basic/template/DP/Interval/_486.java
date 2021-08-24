package leetcode.template.DP.Interval;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/17 17:56
 * 预测赢家
 * [1, 5, 2]
 * 玩家1先选
 */
public class _486 {
    // dfs
    public boolean PredictTheWinner(int[] nums) {
        int sum = 0;
        for(int i : nums) {
            sum += i;
        }
        int t = dfs(nums, 0, nums.length - 1);
        return t >= sum - t;
    }
    private int dfs(int[] nums, int l, int r) {
        if(l > r) {
            return 0;
        }
        return Math.max(
                nums[l] + Math.min(dfs(nums, l + 1, r - 1), dfs(nums, l + 2, r)),
                nums[r] + Math.min(dfs(nums, l + 1, r - 1), dfs(nums, l, r - 2))
        );
    }

    // dfs2
    public boolean PredictTheWinner1(int[] nums) {
        // A胜 则返回true
        return dfs(0, nums.length - 1, nums, true, 0, 0);
    }
    private boolean dfs(int l, int r, int[] nums, boolean flag, int a, int b) {
        // 最后一轮是l = r
        // 下一轮一定是l > r
        //左右越界，没有牌了，比较得分，判断胜负（以A为主角）
        if(l > r) {
            return a >= b;
        }
        if(flag) {
            //轮到A选牌,A是主角，只要左边或者右边有一种必胜情况，就说明可以必胜
            return dfs(l + 1, r, nums, false, a + nums[l], b) || dfs(l, r - 1, nums, false, a + nums[r], b);
        } else {
            //轮到B选牌，不管B怎么选，此时只有左右两边都保证A是必胜的，才能保证A最终必胜！
            return dfs(l + 1, r, nums, true, a, b + nums[l]) && dfs(l, r - 1, nums, true, a, b + nums[r]);
        }
    }
    // dfs 3
    public boolean PredictTheWinner3(int[] nums) {
        return play(nums, 0, nums.length - 1) >= 0;
    }

    private int play(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return 0;
        }
        int planA = nums[lo] - play(nums, lo + 1, hi);
        int planB = nums[hi] - play(nums, lo, hi - 1);
        return Math.max(planA, planB);
    }
    //dfs 4
    public boolean PredictTheWinner5(int[] nums) {
        return total(nums, 0, nums.length - 1, 1) >= 0;
    }

    public int total(int[] nums, int l, int r, int turn) {
        if (l == r) {
            return nums[l] * turn;
        }
        int scorel = nums[l] * turn + total(nums, l + 1, r, -turn);
        int scorer = nums[r] * turn + total(nums, l, r - 1, -turn);
        return Math.max(scorel * turn, scorer * turn) * turn;
    }

    //dfs 5
    public boolean PredictTheWinner6(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int f = dfs(nums, 0, n - 1, 0);
        return f >= sum - f;
    }
    private int dfs(int[] nums, int l, int r, int chance) {
        if(l > r) {
            return 0;
        }
        if(chance == 0) {
            return Math.max(nums[l] + dfs(nums, l + 1, r, 1), nums[r] + dfs(nums, l, r - 1, 1));
        } else {
            return Math.min(dfs(nums, l + 1, r, 0), dfs(nums, l, r - 1, 0));
        }
    }

    // dp
    public boolean PredictTheWinner4(int[] nums) {
        // dp[i][j] 表示当数组剩下的部分为下标 i 到下标 j 时，当前玩家与另一个玩家的分数之差的最大值
        // 当 i=j  时，只剩一个数字，当前玩家只能拿取这个数字
        // 当 i<j 时，当前玩家可以选择 nums[i] 或 nums[j]，然后轮到另一个玩家在数组剩下的部分选取数字。
        // 两种方案中，当前玩家会选择最优的方案，使得自己的分数最大化。因此可以得到如下状态转移方程：
        // dp[i][j] = max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1])
        // 最后判断dp[0][nums.length−1] 的值，如果大于或等于 0，则先手得分大于或等于后手得分，因此先手成为赢家，否则后手成为赢家。
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for(int i = n - 2; i >= 0; i--) {
            for(int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
//        int n = nums.length;
//        int[][] dp = new int[n][n];
//
//        for(int i = n - 1; i >= 0; i--) {
//            dp[i][i] = nums[i];
//            for(int j = i + 1; j < n; j++) {
//                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
//            }
//        }
//        return dp[0][n - 1] >= 0;
    }


    // dp
    public boolean PredictTheWinner7(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n];
        int[] sum = new int[n + 1];
        // 前缀和
        for(int i = 0;i < n; ++i) {
            sum[i + 1] = sum[i] + nums[i];
        }
        dp[n - 1][n - 1] = nums[n - 1];
        for(int i = n - 2;i >= 0;--i){
            dp[i][i] = nums[i];
            for(int j = i + 1; j < n; ++j){
                int sumij = sum[j + 1] - sum[i];
                dp[i][j] = Math.max(sumij - dp[i + 1][j],  sumij - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] * 2 >= sum[n];
    }


}
