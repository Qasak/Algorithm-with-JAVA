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

    // dp去重
    // 令新生成的丑数尽量最小
    public int nthSuperUglyNumber2(int n, int[] primes) {
        // f[i] : 第i个丑数
        int[] f = new int[n];
        int m = primes.length;
        int[] ptr = new int[m];
        f[0] = 1;
        for(int i = 1; i < n;) {
            int min = Integer.MAX_VALUE;
            int idx = -1;
            for(int j = 0; j < m; j++) {
                int cur = primes[j] * f[ptr[j]];
                if(cur < min) {
                    min = cur;
                    idx = j;
                }
            }
            ptr[idx]++;
            if(min > f[i - 1]) {
                f[i++] = min;
            }
        }
        return f[n - 1];
    }

    // dp 一次性去重
    public int nthSuperUglyNumber3(int n, int[] primes) {
        // f[i] : 第i个丑数
        int[] f = new int[n];
        int m = primes.length;
        int[] ptr = new int[m];
        f[0] = 1;
        for(int i = 1; i < n; i++) {
            int[] tmp = new int[m];
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < m; j++) {
                tmp[j] = primes[j] * f[ptr[j]];
                min = Math.min(tmp[j], min);
            }
            f[i] = min;
            for(int j = 0; j < m; j++) {
                if(tmp[j] == min) {
                    ptr[j]++;
                }
            }
        }
        return f[n - 1];
    }
}
