package leetcode.template.queue;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/20 16:59
 *
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 *
 * 一开始你在下标 0 处。每一步，你最多可以往前跳 k 步，但你不能跳出数组的边界。
 * 也就是说，你可以从下标 i 跳到 [i + 1， min(n - 1, i + k)] 包含 两个端点的任意位置。
 * 你的目标是到达数组最后一个位置（下标为 n - 1 ），你的 得分 为经过的所有数字之和。
 * 请你返回你能得到的 最大得分
 */
public class Q5631_jumpingGame {
    // 定义 f[i]表示到下标i处的最大得分，则 f[i] = max(f[i-k..i-1])+nums[i]，但是由于 k 的大小是 O(n) 级别的
    // 遍历 i−k..i−1 的话转移复杂度也是O(n)，总复杂度是 O(n^2)
    //
    // 注意到，转移方程的右边是 max，也就是说我们只需要维护从 f[i-k..i-1]中最大的元素即可。
    //
    public static int maxResult0(int[] nums, int k) {
        int n = nums.length;
        // dp[i] : 下标0跳到下标i的最大得分
        int[] dp = new int[n];
        // 初始化
        dp[0] = nums[0];
        for(int i = 1; i < n; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = i - 1; j >= 0 && j >= i - k; j--) {
                max = Math.max(max, dp[j]);
            }
            dp[i] = max + nums[i];
        }
        return dp[n - 1];
    }
    public int maxResult(int[] nums, int k) {
        int dp = nums[0];
        // 大根堆，按值从大到小排序
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->b[0]-a[0]);
        // 二元组(dp[j], idx(j))
        pq.add(new int[]{dp, 0});
        for (int i = 1; i < nums.length; i++) {
            // 不能超出下标范围
            while (pq.peek()[1] < i - k) {
                pq.poll();
            }
            // 此时是范围内最大值
            dp = pq.peek()[0] + nums[i];
            pq.add(new int[]{dp, i});
        }
        return dp;
    }
    public int maxResult1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) {
            return 0;
        }
        int len = nums.length;
        int res = nums[0];
        int i = 0, j = 0;
        //大根堆，保存下标，按值从大到小排序
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return nums[o2] - nums[o1];
            }
        });
        while (i < len - 1) {
            j = i + 1;
            //寻找下一个非负数
            while (j < len && nums[j] < 0) {
                j++;
            }
            //j为下一次的目的地,nums[i + 1..j - 1]全是负数
            if (j == len) {
                j--;
            }
            // j是k范围内的非负数：直接加
            if (j <= i + k) {
                res += nums[j];
                i = j;
                continue;
            }

            //dp[l - i]表示从nums[i]到nums[l]的最小代价
            int[] dp = new int[j - i + 1];
            heap.add(i);
            for (int l = i + 1; l <= j; l++) {
                // 如果下标不再[l - k, l]范围内
                while (!heap.isEmpty() && heap.peek() < l - k) {
                    heap.poll();
                }
                dp[l - i] = dp[heap.peek() - i] + nums[l];
                heap.add(l);
            }
            res += dp[j - i];
            i = j;
        }
        return res;
    }
    // 单调队列
    public int maxResult2(int[] nums, int k) {
        int n = nums.length;
        int[] f = new int[n];
        f[0] = nums[0];
        // 在单调队列中降序存储当前位置之前最多k个位置的结果。


        // 单减队列p:
        // 对于 f[i]，首先判断 p 中的首元素是否满足距离 k ，不满足则出队。
        //然后由 p 的首元素转移到 i (首元素是 p 中据有最大 f 值的)，接着将 i 从队尾压入 p，将 p 中比 f[i] 小的元素出队，因为这些元素对于 k>i，
        // 肯定不如 f[i] 优。
        //由于每个元素最多只会进/出 p 一次，所以复杂度是 O(p) 的。
        // 从队首到队尾的所有 j 值，它们的下标严格单调递增，而对应的 f[j] 值严格单调递减
        Deque<Integer> q = new LinkedList<>();
        q.offerLast(0);
        for (int i = 1; i < n; ++i) {
            // q 存的下标是不断增大的
            while (q.peek() < i - k) {
                q.pollFirst();
            }
            f[i] = f[q.peek()] + nums[i];

            while (!q.isEmpty() && f[i] >= f[q.peekLast()]) {
                q.pollLast();
            }
            q.offerLast(i);
        }
        return f[n - 1];
    }
    // 暴力DP 2
    // [1,-1,-2,4,-7,3], k = 2
    public int maxResult3(int[] nums, int k) {
        int n = nums.length;
        // dp[i]表示跳到第i个位置的得分
        // 返回dp[n - 1]
        // dp[i] = max(dp[i - k...i - 1]) + nums[i]
        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i = 1; i < n; i++){
            int maxval = dp[i - 1];
            // [i - k, i - 1] 区间的最大值
            for(int j = i - 2; j >= i - k && j >= 0; j--){
                if(dp[j] > maxval) {
                    maxval = dp[j];
                }
                // >0 必选
                if(nums[j] > 0){
                    break;
                }
            }
            // 找到最大值后跟新
            dp[i] = maxval + nums[i];
        }
        return dp[n - 1];
    }
    // dp
    public int maxResult4(int[] nums, int k) {
        int n = nums.length;
        // dp[i]表示跳到第i个位置的得分
        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i = 1; i < n; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = i - 1; j >= 0 && j >= i - k; j--) {
                max = Math.max(max, dp[j]);
                if(nums[j] > 0) {
                    break;
                }
            }
            dp[i] = nums[i] + max;
        }
        return dp[n - 1];
    }
    public static void main(String[] args) {
        int[] nums = new int[]{10,-5,-2,4,0,3};
        int k = 3;
        System.out.println(maxResult0(nums, k));
    }
}
