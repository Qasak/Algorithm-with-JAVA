package leetcode.template.String;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/9 9:52
 */
public class Q1047_删除字符串中的相邻重复项 {
    public String removeDuplicates(String S) {
        StringBuilder ans = new StringBuilder(S);
        for(int i = 1; i < ans.length(); ) {
            boolean flag = false;
            while(i > 0 && i < ans.length() && ans.charAt(i - 1) == ans.charAt(i)) {
                flag = true;
                ans.deleteCharAt(i - 1);
                ans.deleteCharAt(i - 1);
            }
            if(flag) {
                i = i - 1;
            } else {
                i = i + 1;
            }
        }
        return ans.toString();
    }
}
