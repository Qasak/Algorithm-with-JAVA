package NewCoder.ByteDance_2019;

import java.util.Scanner;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/31 23:59
 */


/*
* 三个同样的字母连在一起，一定是拼写错误，去掉一个的 helllo -> hello
* 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母：比如 helloo -> hello
* 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC
*
*
*
2
helloo
wooooooow

输出例子1:
hello
woow
* */
public class Q1_万万没想到之聪明的编辑 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(sc.nextLine());
        while(m-- > 0) {
            String s = sc.nextLine();
            StringBuilder ans = new StringBuilder(s);
            for(int i = 0 ; i < ans.length() - 1; i++) {
                boolean flag = false;
                if(ans.charAt(i) == ans.charAt(i + 1)) {
                    if(i + 2 < ans.length()) {
                        if(ans.charAt(i + 2) == ans.charAt(i)) {
                            ans.deleteCharAt(i);
                            flag = true;
                        }
                    }
                    if(i + 3 < ans.length()) {
                        if(ans.charAt(i + 2) == ans.charAt(i + 3)) {
                            ans.deleteCharAt(i + 2);
                            flag = true;
                        }
                    }
                }
                if(flag) {
                    i--;
                }
            }
            System.out.println(ans.toString());
        }
    }
}
