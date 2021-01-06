package leetcode.template.Hash;

import java.util.HashMap;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/3 12:10
 */
public class Q5642_CountPairs {
    public int countPairs(int[] arr) {
        int n = arr.length;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= 21; j++) {
                if(map.containsKey((1 << j) - arr[i])) {
                    ans += map.get((1 << j) - arr[i]);
                    if(ans >= 1000000007) {
                        ans -= 1000000007;
                    }
                }
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        return ans;
    }
}
