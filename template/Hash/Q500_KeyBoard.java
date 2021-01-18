package leetcode.template.Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/18 22:56
 */
public class Q500_KeyBoard {
    public String[] findWords(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        String s1 = "qwertyuiopQWERTYUIOP";
        String s2 = "asdfghjklASDFGHJKL";
        String s3 = "zxcvbnmZXCVBNM";
        List<String> ans = new ArrayList<>();
        for(char c : s1.toCharArray()) {
            map.put(c, 0);
        }
        for(char c : s2.toCharArray()) {
            map.put(c, 1);
        }
        for(char c : s3.toCharArray()) {
            map.put(c, 2);
        }
        for(String word : words) {
            boolean flag = true;
            int line = map.get(word.charAt(0));
            for(int i = 1; i < word.length(); i++) {
                if(map.get(word.charAt(i)) != line) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                ans.add(word);
            }
        }
        String[] res = new String[ans.size()];
        int idx = 0;
        for(String word: ans) {
            res[idx++] = word;
        }
        return res;
    }
}
