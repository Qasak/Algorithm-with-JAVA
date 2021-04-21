package leetcode.template.String;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/19 18:01
 */
public class Q125_IsPalindrome {
    public boolean isPalindrome0(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c) || Character.isAlphabetic(c)) {
                sb.append(c);
            }
        }
        return sb.toString().equals(sb.reverse().toString());
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c) || Character.isAlphabetic(c)) {
                sb.append(c);
            }
        }

        int n = sb.length();
        // a a a a a
        for(int i = 0; i < n; i++) {
            if(sb.charAt(i) != sb.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
    public boolean isPalindrome1(String s) {
        // 只考虑字母和数字字符
        int n = s.length();
        if(n == 0) {
            return true;
        }
        s = s.toLowerCase();
        int l = 0, r = n - 1;
        while(l < r) {
            while(l < n && (!Character.isDigit(s.charAt(l)) && !Character.isAlphabetic(s.charAt(l))) ) {l++;}
            while(r >= 0 && (!Character.isDigit(s.charAt(r)) && !Character.isAlphabetic(s.charAt(r))) ) {r--;}
            if(l == n || r == -1) {
                return true;
            }
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A ,bc";
        s = s.toLowerCase();
        System.out.println(s);
    }
}
