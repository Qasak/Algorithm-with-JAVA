package ACWing.Q905_区间选点;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] t = new int[n][2];
        for(int i = 0; i < n; i++) {
            t[i][0] = sc.nextInt();
            t[i][1] = sc.nextInt();
        }
        Arrays.sort(t, (a, b) -> (a[0] - b[0]));
        int cnt = 1;
        int r = t[0][1];
        for(int i = 0; i < n - 1; i++) {
            if(r < t[i + 1][0]) {
                cnt++;
            }
            r = Math.max(r, t[i + 1][1]);
        }

        System.out.println(cnt);
    }
}