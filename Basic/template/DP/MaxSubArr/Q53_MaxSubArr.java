package leetcode.template.DP.MaxSubArr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/16 18:19
 *
 *
 * dp(i) 代表以第 i 个数结尾的「连续子数组的最大和」
 */
public class Q53_MaxSubArr {
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int ans = dp[0];
        for(int i = 1; i < n; i++) {
            // 对当前数，选或者不选
            // 如果不选，
            // dp[i]一定包含元素nums[i]
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            // 最大和不一定在最后
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return ans;
    }
    public int maxSubArray1(int[] nums) {
        // 连续子数组
        int n = nums.length;
        int ans = nums[0];
        // dp[i] :以i结尾的子数组的最大子序列和
        int dp = nums[0];
        for(int i = 1; i < n; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            ans = Math.max(ans, dp);
        }
        return ans;
    }
    // 贪心: 不断移动前缀和起点
    public int maxSubArray3(int[] nums) {
        // 连续子数组
        int n = nums.length;
        // ans 所有以i[0, n - 1] 结尾的最大子序和的最大值
        int ans = Integer.MIN_VALUE;
        int pre = 0;
        for(int i = 0; i < n; i++) {
            pre += nums[i];
            ans = Math.max(ans, pre);
            pre = Math.max(pre, 0);
        }
        return ans;
    }
    // dp 求最大子序和的的区间
    public int maxSubArray4(int[] nums) {
        // 连续子数组
        int n = nums.length;
        // ans 所有以i[0, n - 1] 结尾的最大子序和的最大值
        int ans = nums[0];
        int dp = nums[0];
        int l = 0, r = 0;
        for(int i = 1; i < n; i++) {
            if(dp > 0) {
                dp = dp + nums[i];
            } else {
                dp = nums[i];
                l = i;
            }
            if(dp > ans) {
                ans = dp;
                r = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        if(l > r) {
            l = r;
        }
        for(int i = l; i <= r; i++) {
            list.add(nums[i]);
        }
        System.out.println(list);
        return ans;
    }
    // 贪心 求最大子序和的的区间
    public int maxSubArray5(int[] nums) {
        // 连续子数组
        int n = nums.length;
        // ans 所有以i[0, n - 1] 结尾的最大子序和的最大值
        int ans = Integer.MIN_VALUE;
        int pre = 0;
        int l = 0, r = 0;
        for(int i = 0; i < n; i++) {
            pre += nums[i];
            if(pre > ans) {
                ans = pre;
                r = i;
            }
            if(pre < 0) {
                l = i + 1;
                pre = 0;
            }
        }
        List<Integer> list = new ArrayList<>();
        if(l > r) {
            l = r;
        }
        for(int i = l; i <= r; i++) {
            list.add(nums[i]);
        }
        System.out.println(list);
        return ans;
    }
    // 分治
    public class Status {
        public int lSum, rSum, mSum, iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

    public int maxSubArray2(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    public Status getInfo(int[] a, int l, int r) {
        if (l == r) {
            return new Status(a[l], a[l], a[l], a[l]);
        }
        int m = (l + r) >> 1;
        Status lSub = getInfo(a, l, m);
        Status rSub = getInfo(a, m + 1, r);
        return pushUp(lSub, rSub);
    }

    public Status pushUp(Status l, Status r) {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }



    public static void main(String[] args) {
        int[] a = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        // dp :           [-2, 1, -2, 4, 3, 5, 6, 1, 5]
        System.out.println(maxSubArray(a));
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();//定义需要的阶层数n
    }
}
