package ACWing.Q801_二进制中1的个数;

import java.util.Scanner;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/10 20:45
 */
public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int cnt = 0;
            while(t != 0) {
                t -= (t & -t);
                cnt++;
            }
            System.out.println(cnt);
        }
    }
}
