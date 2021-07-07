package leetcode.contest.WeekContest_248;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/7 9:39
 */
public class Q1922_统计好数字的数目 {
    public int mod = (int) 1e9 + 7;
    public Map<Long, Integer> map = new HashMap<>();
    public int countGoodNumbers(long n) {
        // 5 * 4 * 5 * 4
        long ans = 0;
        if(n == 1) {
            return 5;
        }
        if(map.containsKey(n)) {
            return map.get(n);
        }
        if((n & 1) == 0) {
            long a = countGoodNumbers(n - 1);
            ans = (a * 4) ;
        } else {
            long a = countGoodNumbers(n / 2) % mod;
            long b = countGoodNumbers(n / 2 + 1) % mod;
            ans = (a * b) ;
        }
        map.put(n, (int) (ans % mod));
        return (int) (ans % mod);
    }
}
