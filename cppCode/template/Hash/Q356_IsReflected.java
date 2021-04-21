package leetcode.template.Hash;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/3 0:32
 */
public class Q356_IsReflected {
    public boolean isReflected(int[][] points) {
        // (0, 1) (2, 1)
        int n = points.length;
        // System.out.println(n);

        if(n <= 1) {
            return true;
        }
        System.out.println(n);

        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        ArrayList<Integer> t = new ArrayList<>();
        ArrayList<Integer> p = new ArrayList<>();
        t.add(points[0][0]);
        p.add(points[0][1]);

        for(int i = 1; i < n; i++) {
            if(points[i][0] != points[i - 1][0]) {
                t.add(points[i][0]);
                p.add(points[i][1]);
            }
        }
        // 3 : 0, 1, 2
        // 4 : 0, 1, 2, 3
        // 5 : 0, 1, 2, 3, 4
        n = t.size();

        if(n <= 1) {
            return true;
        }
        int s = t.get(0) + t.get(n - 1);
        if(!p.get(0).equals(p.get(n - 1))) {
            System.out.println(p.get(0) + " " + p.get(n - 1));

            return false;
        }
        int l = 1, r = n - 2;
        while(l < r) {

            if(t.get(l) + t.get(r) != s || !p.get(l).equals(p.get(r))) {
                return false;
            }
            l++;
            r--;
        }
        if((n % 2) == 1) {

            return t.get(n / 2) - t.get(n / 2 - 1) == t.get(n / 2 + 1) - t.get(n / 2);
        }
        return true;
    }
}
