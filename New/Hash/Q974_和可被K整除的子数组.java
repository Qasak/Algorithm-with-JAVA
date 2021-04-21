package leetcode.SpringRecruit.Hash;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/21 13:55
 */
public class Q974_和可被K整除的子数组 {
    public int subarraysDivByK(int[] A, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = A.length;
        map.put(0, 1);
        int ans = 0, sum = 0;
        for(int i = 0; i < n; i++) {
            sum += A[i];
            int mod = (sum % k + k) % k;
            if(map.containsKey(mod)) {
                ans += map.get(mod);
            }
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        return ans;
    }
    public static void main(String[] args) {


        Deque<Integer> dq = new LinkedList<>();
        dq.offer(1);
        dq.offerLast(2);
        Iterator<Integer> it = dq.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
