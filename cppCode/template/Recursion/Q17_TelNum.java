package leetcode.template.Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/2 16:36
 */
public class Q17_TelNum {
    List<String> ans;
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if(digits == null || digits.length() == 0) {
            return ans;
        }
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        List<String> tmp = new ArrayList<>();
        for(char c : digits.toCharArray()) {
            if(c != '1') {
                tmp.add(map.get(c - '0'));
            }
        }
        dfs(tmp, 0, 0, new StringBuilder(), tmp.size());
        return ans;
    }
    public void dfs(List<String> tmp, int idx1, int idx2, StringBuilder t, int n) {
        if(t.length() == n) {
            ans.add(t.toString());
            return;
        }
        if(idx1 == tmp.size()) {
            return;
        }
        String cur = tmp.get(idx1);
        for(int i = idx2; i < cur.length(); i++) {
            t.append(cur.charAt(i));
            dfs(tmp, idx1 + 1, 0, t, n);
            t.deleteCharAt(t.length() - 1);
        }
    }
}
