package leetcode.daily;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/29 11:10
 */
public class Q168_excel表列名称 {
    public static String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        while(columnNumber > 0) {
            System.out.println(columnNumber);
            if((columnNumber % 26) == 0) {
                ans.append('Z');
            } else {
                ans.append((char)((columnNumber % 26) + 'A' - 1));
            }
            columnNumber--;
            columnNumber /= 26;
        }
        return ans.reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(convertToTitle(456976));
    }
}
