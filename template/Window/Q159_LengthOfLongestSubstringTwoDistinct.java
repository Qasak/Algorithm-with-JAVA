package leetcode.template.Window;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/2 18:29
 */
public class Q159_LengthOfLongestSubstringTwoDistinct {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int ans = 0;
        int l = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int r = 0; r < n; r++) {
            map.put(cs[r], map.getOrDefault(cs[r], 0) + 1);
            if(map.size() > 2) {
                while(map.get(cs[l]) > 0) {
                    map.put(cs[l], map.get(cs[l]) - 1);
                    if(map.get(cs[l]) == 0) {
                        map.remove(cs[l]);
                        break;
                    }
                    l++;
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
    public int lengthOfLongestSubstringTwoDistinct1(String s) {
        char[] cs = s.toCharArray();
        int l = 0, ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        int n = cs.length;
        for(int r = 0; r < n; r++) {
            map.put(cs[r], map.getOrDefault(cs[r], 0) + 1);
            while(map.size() > 2) {
                map.put(cs[l], map.get(cs[l]) - 1);
                if(map.get(cs[l]) == 0) {
                    map.remove(cs[l]);
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        map.put(1,1);
        System.out.println(map.size());
        map.remove(1);
        System.out.println(map);
    }
}
