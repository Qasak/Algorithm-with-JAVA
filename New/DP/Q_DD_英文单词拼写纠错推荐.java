package leetcode.SpringRecruit.DP;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/29 23:51
 */
public class Q_DD_英文单词拼写纠错推荐 {
    public static Character[] g1 = new Character[]{'q', 'w', 'e', 'r', 't', 'a', 's', 'd', 'f', 'g', 'z', 'x', 'c', 'v'};
    public static Character[] g2 = new Character[]{'y' , 'u' , 'i' , 'o' , 'p' , 'h' , 'j' , 'k' , 'l' , 'b' , 'n' , 'm'};
    public static Set<Character> set1 = new HashSet<>(Arrays.asList(g1));
    public static Set<Character> set2 = new HashSet<>(Arrays.asList(g2));

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = null;
        while (sc.hasNext()) {
            String t = sc.nextLine();
            words = t.split(" ");
            // System.out.println(Arrays.toString(words));
            String s = words[0];
            int n = words.length - 1;
            Map<String, Integer> map = new HashMap<>();
            for(int i = 1; i <= n; i++) {
                map.put(words[i], getPoint(s, words[i]));
            }
            Arrays.sort(words, 1, n + 1, (a, b) -> (map.get(a) - map.get(b)));
            for(int i = 1; i <= n; i++) {
                System.out.print(words[i]);
                if(i < 3) {
                    System.out.println(" ");
                } else {
                    break;
                }
            }
        }
    }
    public static int getPoint(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n * m == 0) {
            return n + m;
        }
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++) {
            dp[i][0] = 3 * i;
        }
        for(int i = 1; i <= m; i++) {
            dp[0][i] = 3 * i;
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j] + 3), dp[i][j - 1] + 3);
                } else {
                    int add = ( (set1.contains(s.charAt(i - 1)) && set1.contains(t.charAt(j - 1)) )
                            || (set2.contains(s.charAt(i - 1)) && set2.contains(t.charAt(j - 1)) ) ) ? 1 : 2;

                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j] + 3), dp[i][j - 1] + 3) + add;
                }
            }
        }
        return dp[n][m];
    }
}
