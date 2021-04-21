package leetcode.SpringRecruit.Recursion;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/21 14:02
 */
public class Q394_字符串解码 {
    public String decodeString(String s) {
        if(s == "") {
            return s;
        }
        StringBuilder pre = new StringBuilder();
        StringBuilder num = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        char[] cs = s.toCharArray();
        int i = 0;
        int n = cs.length;
        while(i < n) {
            if(cs[i] != '[' && ! Character.isDigit(cs[i])) {
                pre.append(cs[i++]);
            } else if(cs[i] != '[' && Character.isDigit(cs[i])) {
                num.append(cs[i++]);
            } else if(cs[i] == '[') {
                int k = Integer.parseInt(num.toString());
                num = new StringBuilder();
                int cnt = 1;
                int j = i + 1;
                for(; j < n; j++) {
                    if(cs[j] == '[') {
                        cnt++;
                    }
                    if(cs[j] == ']') {
                        cnt--;
                    }
                    if(cnt == 0) {
                        break;
                    }
                }
                String inner = decodeString(s.substring(i + 1, j));
                StringBuilder t = new StringBuilder();
                for(int m = 0; m < k; m++) {
                    t.append(inner);
                }
                pre.append(t);
                ans.append(pre.toString());
                pre = new StringBuilder();
                i = j + 1;
            }
        }
        if(pre.length() != 0) {
            ans.append(pre.toString());
        }
        return ans.toString();
    }

    class Solution {
        int i;
        String src;
        public String decodeString(String s) {
            src = s;
            i = 0;
            return getString();
        }

        public String getString() {
            String ret = "";
            if(i == src.length() || src.charAt(i) == ']') {
                return "";
            }
            char ch = src.charAt(i);
            int rep;
            if(Character.isDigit(ch)) {
                rep = getNum();
                i++;
                String tmp = getString();
                for(int j = 0; j < rep; j++) {
                    ret += tmp;
                }
                i++;
            } else {
                ret = String.valueOf(src.charAt(i++));
            }
            return ret + getString();
        }
        public int getNum() {
            StringBuilder num = new StringBuilder();
            while(Character.isDigit(src.charAt(i))) {
                num.append(src.charAt(i++));
            }
            return Integer.valueOf(num.toString());
        }
    }

    public static void main(String[] args) {
        String a = 1 + " " + 2;
        System.out.println(a);
    }
}
