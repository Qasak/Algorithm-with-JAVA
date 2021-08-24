package Mitsuha.递归_栈;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/24 23:31
 */
public class Q394_字符串解码 {
    public String decodeString(String s) {
        int n = s.length();
        StringBuilder ans = new StringBuilder();
        char[] cs = s.toCharArray();
        int i = 0;
        int k = 0;
        while(i < n) {
            if(Character.isDigit(cs[i])) {
                int j = i;
                int num = 0;
                while(Character.isDigit(cs[j])) {
                    num *= 10;
                    num += (int) (cs[j++] - '0');
                }
                k = num;
                i = j;
            } else if(Character.isAlphabetic(cs[i])) {
                while(i < n && Character.isAlphabetic(cs[i])) {
                    ans.append(cs[i]);
                    i++;
                }
            } else {
                int cnt = 1;
                int j = i + 1;
                while(true) {
                    if(cs[j] == '[') {
                        cnt++;
                    }
                    if(cs[j] == ']') {
                        cnt--;
                    }
                    if(cnt == 0) {
                        break;
                    }
                    j++;
                }
                String t = decodeString(s.substring(i + 1, j));
                for(int l = 0; l < k; l++) {
                    ans.append(t);
                }
                k = 0;
                i = j + 1;
            }
        }
        return ans.toString();
    }
}
