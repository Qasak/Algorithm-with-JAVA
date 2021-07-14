package leetcode.contest.NiceProblem.二分应用;

import java.util.TreeSet;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/9 18:46
 */
public class Q1712_将数组分成三个子数组的方案数 {
    public static int waysToSplit(int[] nums) {
        int n = nums.length;
        int mod = 1000_000_000 + 7;
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        int res = 0;
        //l为left的最后一个元素
        for (int l = 0; l < n - 2 && preSum[l] <= preSum[n - 1]/3; l++) {
            int[] mid = search(preSum, l);
            if (mid[0] == -1 || mid[1] == -1) {
                continue;
            }
            res = (res + mid[1] - mid[0] + 1) % mod;
        }
        return res;
    }

    private static int[] search(int[] preSum, int start) {
        int[] res = new int[2];
        int n = preSum.length;
        res[0] = -1;
        res[1] = -1;
        //首先搜索左端点
        int l = start + 1;
        int r = n - 2;
        int mid;
        while (l < r) {
            mid = l + ((r - l) >> 1);
            if (preSum[mid] < 2 * preSum[start]) {
                l = mid + 1;
            } else {
                if (mid - 1 >= l && preSum[mid - 1] < 2 * preSum[start]) {
                    l = mid;
                    break;
                }
                r = mid - 1;
            }
        }
        if (l >= 0 && l < n && preSum[l] >= 2 * preSum[start]) {
            res[0] = l;
        }

        //然后搜索右端点
        r = n - 2;
        while (l < r) {
            mid = l + ((r - l) >> 1);
            if (preSum[n - 1] < 2 * preSum[mid] - preSum[start]) {
                r = mid - 1;
            } else {
                if (mid + 1 <= r && preSum[n - 1] < 2 * preSum[mid + 1] - preSum[start]) {
                    l = mid;
                    break;
                }
                l = mid + 1;
            }
        }
        if (l >= 0 && l < n && preSum[n - 1] >= 2 * preSum[l] - preSum[start]) {
            res[1] = l;
        }
        return res;
    }


    // remaster
    public int waysToSplit1(int[] nums) {
        int n = nums.length;
        int mod = (int)(1e9 + 7);
        int[] pre = new int[n + 1];
        for(int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        int ans = 0;
        //  0 ~ i|i + 1 ~ b | b + 1 ~ n - 1
        for(int i = 0; pre[i + 1] <= pre[n] / 3 && i <= n - 3; i++) {
            // mid的左边界 / mid的右边界 [a, b]
            int l = i + 1, r = n - 2;
            // ceiling
            while(l < r) {
                int m = (l + r) >>> 1;
                if(pre[m + 1] - pre[i + 1] < pre[i + 1]) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            int a = l;
            l = i + 1;
            r = n - 2;
            // floor
            while(l < r) {
                int m = (l + r + 1) >>> 1;
                if(pre[m + 1] - pre[i + 1] > pre[n] - pre[m + 1]) {
                    r = m - 1;
                } else {
                    l = m;
                }
            }
            int b = l;
            if(pre[i + 1] <= pre[a + 1] - pre[i + 1] &&
                    pre[n] - pre[b + 1] >= pre[b + 1] - pre[a]) {
                ans = (ans + b - a + 1) % mod;
            }
        }
        return (ans % mod);
    }
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(3);
        System.out.println(set.ceiling(2));
        System.out.println(set.floor(0));

    }
}
