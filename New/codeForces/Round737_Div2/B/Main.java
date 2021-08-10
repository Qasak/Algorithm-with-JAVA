package codeForces.Round737_Div2.B;

import com.sun.prism.shader.AlphaOne_Color_Loader;

import java.text.CollationElementIterator;
import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/9 23:05
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int t = sc.nextInt();
        while(t-- > 0) {
            List<int[]> list = new ArrayList<>();

            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] nums = new int[n][2];
            for (int i = 0; i < n; i++) {
                nums[i][0] = sc.nextInt();
                nums[i][1] = i;
            }
            Arrays.sort(nums, (a, b) -> (a[0] - b[0]));
            int cnt = 1;
            for(int i = 0; i < n - 1; i++) {
                if(nums[i][1] + 1 != nums[i + 1][1]) {
                    cnt++;
                }
            }
            System.out.println(cnt);
            if(cnt <= k) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
