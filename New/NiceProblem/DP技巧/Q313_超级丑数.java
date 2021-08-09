package leetcode.NiceProblem.DP技巧;

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
}
