package leetcode.SpringRecruit.DP;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/31 11:05
 */
public class Q403_青蛙过河 {
    // 1. TreeSet
    public boolean canCross(int[] stones) {
        int n = stones.length;
        TreeSet[] dp = new TreeSet[n];
        for(int i = 0; i < n; i++) {
            dp[i] = new TreeSet<Integer>((a, b) -> b - a);
        }
        dp[0].add(0);
        for(int i = 0; i < n; i++) {
            if(i != 0 && dp[i].isEmpty()) {
                break;
            }
            for(int j = i + 1; j < n; j++) {
                if(stones[i] + (int)dp[i].iterator().next() + 1 < stones[j]) {
                    break;
                }
                for (int cur : (Iterable<Integer>) dp[i]) {
                    if(stones[i] + cur - 1 == stones[j]) {
                        dp[j].add(cur - 1);
                    }
                    if(stones[i] + cur == stones[j]) {
                        dp[j].add(cur);

                    }
                    if(stones[i] + cur + 1 == stones[j]) {
                        dp[j].add(cur + 1);
                    }
                }

            }
        }
        // System.out.println(Arrays.toString(dp));
        return !dp[n - 1].isEmpty();
    }
    // 2. 记忆化

    // 3. map


    public static void main(String[] args) {
        int n = 1;
        TreeSet[] dp = new TreeSet[n];
        for(int i = 0; i < n; i++) {
            dp[i] = new TreeSet<Integer>((a, b) -> b - a);
            Iterator<Integer> it = dp[i].iterator();
            while(it.hasNext()) {
                int cur = it.next();
            }
        }
    }
}
