package leetcode.SpringRecruit.Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/26 21:37
 */
public class Q784_字母大小写全排列 {
    List<String> ans = new ArrayList<>();
    public List<String> letterCasePermutation(String S) {
        dfs(0, S, new StringBuilder());
        return ans;
    }
    public void dfs(int i, String s, StringBuilder path) {
        int n = s.length();
        if(i == n) {
            ans.add(path.toString());
            return;
        }
        int len = path.length();
        if(!Character.isAlphabetic(s.charAt(i))) {
            path.append(s.charAt(i));
            dfs(i + 1, s, path);
        } else {
            path.append(Character.toLowerCase(s.charAt(i)));
            dfs(i + 1, s, path);
            path.setLength(len);

            path.append(Character.toUpperCase(s.charAt(i)));
            dfs(i + 1, s, path);
            path.setLength(len);
        }
    }
    public static void main(String[] args) {
        System.out.println(Character.isAlphabetic('a'));
    }
}
