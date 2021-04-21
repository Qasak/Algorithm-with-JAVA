package leetcode.template.DP.Jump;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/21 11:26
 * 
 * 给你一个整数数组arr 和一个整数d 。每一步你可以从下标i跳到：
 *
 * i + x，其中i + x < arr.length且0 < x <= d。
 * i - x，其中i - x >= 0且0 < x <= d。
 * 除此以外，你从下标i 跳到下标 j需要满足：arr[i] > arr[j]且 arr[i] > arr[k]，
 * 其中下标k是所有 i到 j之间的数字（更正式的，min(i, j) < k < max(i, j)）。
 * 你可以选择数组的任意下标开始跳跃。
 * 请你返回你 最多 可以访问多少个下标。
 * 从高出跳到低处，并且中间不能被挡住
 *
 * 输入：arr = [6,4,14,6,8,13,9,7,10,6,12], d = 2
 * 输出：4
 *
 * 输入：arr = [7,6,5,4,3,2,1], d = 1
 * 输出：7
 * 从下标 0 处开始，你可以按照数值从大到小，访问所有的下标。
 *
 * 输入：arr = [3,3,3,3,3], d = 3
 * 输出：1
 * 解释：你可以从任意下标处开始且你永远无法跳到任何其他坐标。
 *
 * 输入：arr = [7,1,7,1,7,1], d = 2
 * 输出：2
 */

// 1 <= arr.length <= 1000
//1 <= arr[i] <= 10^5
//1 <= d <= arr.length
public class Q1340_maxJump {

    // 起跳点的可跳跃次数是:所有能跳到的点可跳跃次数最大值 加一
    // 我们遍历每个点的顺序 从矮到高遍历，然后记录每个点的可移动的最大步数。
    //这样就可以得到的动态转移方程为
    //dp[i] = max(dp[可以去的阶梯])+1;

    // dfs
    int[] dp;
    int[] arr;
    int d;
    public int maxJumps(int[] arr, int d) {
        int ans = 0;
        int n = arr.length;
        this.arr = arr;
        this.dp = new int[n];
        this.d = d;
//        Arrays.fill(dp, 1);
        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, getMax(i));
        }
        return ans;
    }
    // 从i点可以去到的点，移动次数最大值
    private int getMax(int i) {
        if(dp[i] != 0) {
            return dp[i];
        }
        // 往左走
        int lmax = 0;
        for(int j = i - 1; j >= 0 && j >= i - d; j--) {
            if(arr[j] >= arr[i]) {
                break;
            }
            lmax = Math.max(lmax, getMax(j));
        }
        // 往右走
        int rmax = 0;
        for(int j = i + 1; j < arr.length && j <= i + d; j++) {
            if(arr[j] >= arr[i]) {
                break;
            }
            rmax = Math.max(rmax, getMax(j));
        }
        return dp[i] = Math.max(lmax, rmax) + 1;
    }
    // dp 我们遍历每个点的顺序 从矮到高遍历，然后记录每个点的可移动的最大步数
    public int maxJumps1(int[] arr, int d) {
        int n = arr.length;
        int[] dp = new int[n];
        int ans = 1;
        ArrayList<int[]> tmp = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            tmp.add(new int[]{arr[i], i});
        }
        // 按值从小到大排序
        tmp.sort((a, b) -> a[0] - b[0]);
        for(int[] pair: tmp) {
            int idx = pair[1];
            dp[idx] = 1;
            // 往左
            for(int j = idx - 1; j >= 0 && j >= idx - d; j--) {
                if(arr[j] >= arr[idx]) {
                    break;
                }
                // 可以访问到j
                dp[idx] = Math.max(dp[idx], dp[j] + 1);
            }
            // 往右
            for(int j = idx + 1; j < n && j <= idx + d; j++) {
                if(arr[j] >= arr[idx]) {
                    break;
                }
                // 可以访问到j
                dp[idx] = Math.max(dp[idx], dp[j] + 1);
            }
            ans = Math.max(ans, dp[idx]);
        }
        return ans;
    }
    public static void main(String[] args) {
        Q1340_maxJump q = new Q1340_maxJump();
        int d= 2;
        int[] arr = new int[]{6,4,14,6,8,13,9,7,10,6,12};
        System.out.println(q.maxJumps(arr, d));
    }
}
