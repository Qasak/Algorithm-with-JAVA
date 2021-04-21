package leetcode.JianZhi;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/12 17:20
 */
public class Q5 {
    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }
    public String replaceSpace1(String s) {
        StringBuilder ans = new StringBuilder();
        char[] cs = s.toCharArray();
        for(char c : cs) {
            if(c == ' ') {
                ans.append("%20");
            } else {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
