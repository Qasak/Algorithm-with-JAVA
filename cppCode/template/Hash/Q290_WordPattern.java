package leetcode.template.Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/16 9:46
 *
 *
 *
 * 此题注意containsValue的用法
 */
public class Q290_WordPattern {
    public boolean wordPattern(String p, String s) {
        String[] words = s.split(" ");
        int n = p.length();
        int m = words.length;
        if(n != m) {
            return false;
        }
        // a : [0, 3]
        // b : [1, 2]

        // dog [0, 3]
        // car [1, 2]
        Map<Character, ArrayList<Integer>> map1 = new HashMap<>();
        Map<String, ArrayList<Integer>> map2 = new HashMap<>();

        for(int i = 0; i < n; i++) {
            char c = p.charAt(i);
            if(!map1.containsKey(c)) {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(i);
                map1.put(c, l);
            } else {
                ArrayList<Integer> l = map1.get(c);
                l.add(i);
                map1.put(c, l);
            }
        }
        for(int i = 0; i < n; i++) {
            String c = words[i];
            if(!map2.containsKey(c)) {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(i);
                map2.put(c, l);
            } else {
                ArrayList<Integer> l = map2.get(c);
                l.add(i);
                map2.put(c, l);
            }
        }
        for(int i = 0; i < n; i++) {
            ArrayList<Integer> a = map1.get(p.charAt(i));
            ArrayList<Integer> b = map2.get(words[i]);
            if(a.size() != b.size()) {
                return false;
            }
            for(int j = 0; j < a.size(); j++) {
                // 注意封装类型用equal比较，否则超出128会出错
                if(!a.get(j).equals(b.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean wordPattern1(String p, String s) {
        String[] words = s.split(" ");
        int n = p.length();
        int m = words.length;
        if(n != m) {
            return false;
        }
        // pattern = "abbc", str = "dog cat cat pig"
        // a : [0, 3]
        // b : [1, 2]

        // dog [0, 3]
        // car [1, 2]
        Map<Character, String> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            char c = p.charAt(i);
            // key存在
            if(map.containsKey(c)) {
                if(!map.get(c).equals(words[i])) {
                    return false;
                }
            // key不存在
            } else {
                // 注意containsValue的用法
                if(map.containsValue(words[i])) {
                    return false;
                } else {
                    map.put(c, words[i]);
                }
            }
        }
        return true;
    }
}
