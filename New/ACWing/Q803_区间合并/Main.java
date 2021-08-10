package ACWing.Q803_区间合并;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        int[][] ranges = new int[n][2];
        for(int i = 0; i < n; i++) {
            ranges[i][0] = sc.nextInt(); ranges[i][1] = sc.nextInt();
        }
        Arrays.sort(ranges, (a, b) -> (a[0] - b[0]));
        int cnt = 0;
        for(int i = 0; i < n;) {
            int r = ranges[i][1];
            if(i < n - 1 && r >= ranges[i + 1][0]) {
                while(i < n - 1 && r >= ranges[i + 1][0]) {
                    r = Math.max(r, ranges[i + 1][1]);
                    i++;
                }
                cnt++;
                i++;
            } else {
                i++;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}