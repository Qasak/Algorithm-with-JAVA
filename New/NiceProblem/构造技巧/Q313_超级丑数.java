package leetcode.NiceProblem.构造技巧;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/9 10:26
 */
public class Q313_超级丑数 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int a = 1;
        PriorityQueue<Long> q = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        q.offer(1L);
        set.add(1L);
        n--;
        while(n-- > 0) {
            long t = q.poll();
            for(int p : primes) {
                long next = p * t;
                if(set.add(next)) {
                    q.offer(next);
                }
            }
        }
        long ans = q.poll();
        return (int) ans;
    }
    // 多路归并
    public int nthSuperUglyNumber1(int n, int[] primes) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int m = primes.length;
        for(int i = 0; i < m; i++) {
            // 值，所在行，丑数下标
            q.offer(new int[]{primes[i], i, 0});
        }
        int j = 1;
        int[] ans = new int[n];
        ans[0] = 1;
        while(j < n) {
            int[] t = q.poll();
            // 始终弹出最后一个丑数
            int val = t[0], i = t[1], idx = t[2];
            if(val > ans[j - 1]) {
                ans[j] = val;
                j++;
            }
            // 对应行生成新的丑数
            // q的大小始终是m
            q.offer(new int[]{ans[idx + 1] * primes[i], i, idx + 1});
        }
        // System.out.println(Arrays.toString(ans));
        return ans[n - 1];
    }
}
