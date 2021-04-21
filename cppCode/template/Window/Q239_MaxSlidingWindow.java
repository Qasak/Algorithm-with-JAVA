package leetcode.template.Window;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/2 12:24
 */
public class Q239_MaxSlidingWindow {
    // 线段树
    int[] d;
    int[] a;

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n == 0) {
            return nums;
        }
        a = nums;
        d = new int[4 * n];
        Arrays.fill(d, Integer.MIN_VALUE);
        build(0, n - 1, 0);
        int m = n - k + 1;
        int[] ans = new int[m];
        for(int i = 0; i < m; i++) {
            // 0节点对应[0, n)区间
            // ans[i] = query(i, i + k, 0, 0, n);
            ans[i] = getMax(i, i + k - 1, 0, n - 1, 0);
        }
        return ans;
    }
    // 对 [s,t] 区间建立线段树,当前根的编号为 p
    void build(int s, int t, int p) {
        if (s == t) {
            d[p] = a[s];
            return;
        }
        int m = (s + t) / 2;
        // 递归对左右区间建树
        build(s, m, p * 2 + 1);
        build(m + 1, t, p * 2 + 2);
        d[p] = Math.max(d[p * 2 + 1], d[p * 2 + 2]);
    }
    int getMax(int l, int r, int s, int t, int p) {
        // l:r [0, 2]
        // s:t [0, 7]
        if(l <= s && t <= r) {
            return d[p];
        }
        int m = (s + t) / 2;
        int minl = Integer.MIN_VALUE, minr = Integer.MIN_VALUE;
        if(l <= m) {
            minl = getMax(l, r, s, m, p * 2 + 1);
        }
        if(r >= m + 1) {
            minr = getMax(l, r, m + 1, t, p * 2 + 2);
        }
        return Math.max(minl, minr);
    }
    // 优先队列
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        // [3,3,3,3]
        int[] ans = new int[n - k + 1];
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int i = 0; i < k; i++) {
            q.add(new int[]{nums[i], i});
        }
        ans[0] = q.peek()[0];
        for(int i = k; i < n; i++) {
            q.add(new int[]{nums[i], i});
            while(q.peek()[1] <= i - k) {
                q.poll();
            }
            ans[i - k + 1] = q.peek()[0];
        }
        return ans;
    }
    // 单调队列
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }
    // 分块+预处理
    public int[] maxSlidingWindow3(int[] nums, int k) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        for (int i = 0; i < n; ++i) {
            if (i % k == 0) {
                prefixMax[i] = nums[i];
            }
            else {
                prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            if (i == n - 1 || (i + 1) % k == 0) {
                suffixMax[i] = nums[i];
            } else {
                suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
            }
        }

        int[] ans = new int[n - k + 1];
        for (int i = 0; i <= n - k; ++i) {
            ans[i] = Math.max(suffixMax[i], prefixMax[i + k - 1]);
        }
        return ans;
    }
}
