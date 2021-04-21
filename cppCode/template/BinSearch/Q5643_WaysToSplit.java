package leetcode.template.BinSearch;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/3 12:33
 *
 * 数组被分成三个 非空 连续子数组，从左至右分别命名为 left ， mid ， right 。
 * left 中元素和小于等于 mid 中元素和，mid 中元素和小于等于 right 中元素和
 */
public class Q5643_WaysToSplit {
    public int waysToSplit(int[] nums) {
        int mod=1_000_000_007;
        int n = nums.length;
        int[] pre = new int[n + 1];
        //   [1,1,1]
        // [0,1,2,3]
        // pre[3] - pre[1] =
        for(int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        int ans = 0;
        // i:left的右端点，mid的左端点
        // left  /  mid  / right
        // [0, i) [i, j), [j, n)
        // left:[0, i)
        // left至少一个值->剩下两个值给mid和right
        //
        // [0, n - 2) [n - 2, n - 1) [n - 1, n)
        for(int i = 1; i <= n - 2; i++) {
            // pre[i] : sum([0, i))
            int lsum = pre[i];
            // mid的左端点i
            // 找mid满足的右端点
            // mid:[i, [j1, j2])

            int l1 = i + 1, r1 = n;
            while(l1 < r1) {
                // m: mid的右端点
                int m = l1 + ((r1 - l1) >> 1);
                // msum : sum of nums[i, m)
                int msum = pre[m] - lsum;
                if(msum >= lsum) {
                    r1 = m;
                } else {
                    l1 = m + 1;
                }
            }
            int l2 = l1, r2 = n;
            while(l2 < r2) {
                int m = l2 + ((r2 - l2) >> 1);
                int msum = pre[m] - lsum;
                // sum of nums[m, n)
                if(msum <= pre[n] - pre[m]) {
                    l2 = m + 1;
                } else {
                    r2 = m;
                }
            }
            ans = (ans + l2 - l1) % mod;
        }
        return ans;
    }

    public static int waysToSplit2(int[] nums) {
        int n = nums.length;
        int mod = 1000_000_000 + 7;
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        int res = 0;
        //l为left的最后一个元素
        for (int l = 0; l < n - 2 && preSum[l] <= preSum[n - 1] / 3; l++) {
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


    public static int lowerBound(int[] nums, int l, int r, int target){
        while(l < r) {
            int m = (l + r) / 2;
            if(nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
    public static int upperBound(int[] nums, int l, int r, int target){
        while(l < r) {
            int m = (l + r) / 2;
            if(nums[m] <= target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
    public static int waysToSplit3(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n + 1];
        //
        for(int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        int ans = 0;
        int mod = 1_000_000_007;



        // X, Y
        // pre[X] <= pre[Y] - pre[X] <= pre[n] - pre[Y];

        // 1: pre[Y] <= 2 * pre[X]
        // 2: pre[Y] <= (pre[n] + pre[X]) / 2


        // pre[1] : 至少一个数

        // pre[n] 剩0个数
        // pre[n - 1] 剩一个数
        // pre[n - 2] : 剩两个数
        for(int X = 1; X <= n - 2 ; X++) {
            int Y1 = lowerBound(pre, X + 1, n, 2 * pre[X]);
            int Y2 = upperBound(pre, Y1, n, (pre[X] + pre[n]) / 2);
            ans += Y2 - Y1;
            if(ans >= mod) {
                ans -= mod;
            }
        }
        return ans;
    }
}
