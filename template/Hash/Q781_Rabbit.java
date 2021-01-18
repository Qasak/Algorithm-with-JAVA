package leetcode.template.Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/18 17:59
 */
public class Q781_Rabbit {
    public int numRabbits(int[] arr) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr) {
            if(map.containsKey(i) && map.get(i) > 0) {
                map.put(i, map.get(i) - 1);
            } else {
                ans += i + 1;
                map.put(i, i);
            }
        }
        return ans;
    }
}
