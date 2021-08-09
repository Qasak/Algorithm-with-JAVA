package codeForces;

import java.util.Scanner;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/9 21:27
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        if((n & 1) == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
