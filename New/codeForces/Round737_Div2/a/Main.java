package codeForces.Round737_Div2.a;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/9 22:38
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for(int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            Arrays.sort(nums);
            double ans = 0;
            for(int i : nums) {
                ans += i;
            }
            ans = (ans - nums[n - 1]) / (n - 1) + nums[n - 1];
            System.out.println(ans);
        }
    }
}
