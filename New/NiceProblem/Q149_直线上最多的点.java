package leetcode.contest.NiceProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/24 15:00
 */
public class Q149_直线上最多的点 {
    // 1. 枚举 避免除法
    public int maxPoints(int[][] points) {
        int ans = 1;
        int n = points.length;
        // y = kx + b
        // y1 = kx1 + b;
        // y2 = kx2 + b;
        // y3 = kx3 + b;
        // y1 - y2 = k(x1 - x2)
        // k = (y1 - y2) / (x1 - x2)
        // k' = (y1 - y3) / (x1 - x3)
        // (y1 - y2) * (x1 - x3) == (y1 - y3) * (x1 - x2)
        for(int i = 0; i < n; i++) {
            int[] a = points[i];
            for(int j = i + 1; j < n; j++) {
                int[] b = points[j];
                int cnt = 2;
                for(int k = j + 1; k < n; k++) {
                    int[] c = points[k];
                    int s1 = (a[1] - b[1]) * (a[0] - c[0]);
                    int s2 = (a[1] - c[1]) * (a[0] - b[0]);
                    if(s1 == s2) {
                        cnt++;
                    }
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
    // 2. 枚举点对
    // 哈希表保存 [斜率:点数]对，当心+0/-0 +∞/-∞
    public int maxPoints1(int[][] points) {
        int ans = 1;
        int n = points.length;
        for(int i = 0; i < n; i++) {
            int[] a = points[i];
             // 由当前点 i 发出的直线所经过的最多点数量
            Map<Double, Integer> map = new HashMap<>();
            for(int j = i + 1; j < n; j++) {
                int[] b = points[j];
                double dy = (a[1] - b[1]) * 1.0;
                double dx = (a[0] - b[0]) * 1.0;
                double k;
                if(dy == 0) {
                    k = 0;
                } else if(dx == 0) {
                    k = Double.MAX_VALUE;
                } else {
                    k = dy / dx;
                }
                if(map.containsKey(k)) {
                    map.put(k, map.get(k) + 1);
                } else {
                    map.put(k, 2);
                }
                ans = Math.max(ans, map.get(k));
            }
        }
        return ans;
    }

    // 避免精度问题
    public int maxPoints2(int[][] ps) {
        int n = ps.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            // 由当前点 i 发出的直线所经过的最多点数量
            int max = 0;
            for (int j = i + 1; j < n; j++) {
                int x1 = ps[i][0], y1 = ps[i][1], x2 = ps[j][0], y2 = ps[j][1];
                int a = x1 - x2, b = y1 - y2;
                int k = gcd(a, b);
                String key = (a / k) + "_" + (b / k);
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
            ans = Math.max(ans, max + 1);
        }
        return ans;
    }
    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println((1.0 / 3.0));
    }
}
