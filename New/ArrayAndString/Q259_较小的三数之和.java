package leetcode.SpringRecruit.ArrayAndString;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/29 16:09
 */
public class Q259_较小的三数之和 {
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
        return 0;
    }
}
