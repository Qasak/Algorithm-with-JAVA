package codeForces;

import java.util.Scanner;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/9 21:27
 */
public class A_Watermelon {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        if(n % 2 == 1) {
            System.out.println("NO");
            return;
        }

        for(int i = 1; i <= n / 2; i++) {
            if(i % 2 == 0 && (n - i) % 2 == 0) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
