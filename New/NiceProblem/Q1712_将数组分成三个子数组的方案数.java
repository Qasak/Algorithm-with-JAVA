package leetcode.contest.NiceProblem;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/5/31 19:02
 */


// 前缀和 + 两次二分
public class Q1712_将数组分成三个子数组的方案数 {
    public int waysToSplit(int[] nums) {
        int mod = (int) 1e9 + 7;
        int n = nums.length;
        int[] pre = new int[n + 1];
        int ans = 0;
        for(int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        // [0, i] [i + 1, j] [j + 1, n - 1]
        // 枚举mid区间的右端点
        // mid[i + 1,  x1 ~ x2]
        // sum(mid) >= sum(left) && sum(mid) < sum(right)
        for(int i = 0; i <= n - 3; i++) {
            int j = i + 1, k = n - 1;
            while(j < k) {
                int m = (j + k) >>> 1;
                if(pre[m + 1] - pre[i + 1] < pre[i + 1]) {
                    j = m + 1;
                } else {
                    k = m;
                }
            }
            // System.out.println((pre[i + 1]) + " " + (pre[j + 1] - pre[i + 1]));
            // x1 尽量小, x2 尽量大
            int x1 = j;
            k = n - 1;
            while(j < k) {
                int m = (j + k) >>> 1;
                if(pre[m + 1] - pre[i + 1] <= pre[n] - pre[m + 1]) {
                    j = m + 1;
                } else {
                    k = m;
                }
            }
            ans += k - x1;
            // System.out.println(x1 + " " + k);
            ans %= mod;
        }
        return ans;
    }
}
