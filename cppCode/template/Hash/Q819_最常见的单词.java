package leetcode.template.Hash;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/16 18:02
 */
public class Q819_最常见的单词 {
    public String mostCommonWord(String paragraph, String[] banned) {
        String t = paragraph.toLowerCase();
        Map<String, Integer> map = new HashMap<>();
        List<String> tmp = new ArrayList<>();
        Set<String> set = new HashSet<>();
        int n = t.length();
        for(String s : banned) {
            set.add(s);
        }
        for(int i = 0; i < n; i++) {
            if(!(t.charAt(i) >= 'a' && t.charAt(i) <= 'z')) {
                continue;
            }
            int j = i;
            while(j < n && t.charAt(j) >= 'a' && t.charAt(j) <= 'z') {
                j++;
            }
            if(map.get(t.substring(i, j)) == null) {
                tmp.add(t.substring(i, j));
                map.put(t.substring(i, j), 0);
            } else {
                map.put(t.substring(i, j), map.get(t.substring(i, j)) + 1);
            }
            i = j - 1;
        }
        Collections.sort(tmp, (a, b) -> (map.get(b) - map.get(a)));
        for(String s : tmp) {
            if(!set.contains(s)) {
                return s;
            }
        }
        return "";
    }
}
