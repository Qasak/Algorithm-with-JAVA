package leetcode.SpringRecruit.ArrayAndString;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/22 15:29
 */
public class Q239_滑动窗口的最大值 {
    // [9,10,9,-7,-4,-8,2,-6]
    // 5
    // 1. 优先队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int m = n - k + 1;
        int[] ans = new int[m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        int idx = 0;
        ans[idx++] = pq.peek()[0];
        for(int i = k; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
            while(pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[idx++] = pq.peek()[0];
        }
        return ans;
    }

    // 2. 单调队列
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        int m = n - k + 1;
        int[] ans = new int[m];
        Deque<Integer> q = new LinkedList<>();
        for(int i = 0; i < k; i++) {
            while(!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
                q.pollLast();
            }
            q.offer(i);
        }
        int idx = 0;
        ans[idx++] = nums[q.peekFirst()];
        for(int i = k; i < n; i++) {
            while(!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
                q.pollLast();
            }
            q.offer(i);
            while(q.peekFirst() <= i - k) {
                q.pollFirst();
            }
            ans[idx++] = nums[q.peekFirst()];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("x");
    }
}
