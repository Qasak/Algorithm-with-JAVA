package NiceProblem.Week258;

import java.util.HashMap;
import java.util.Map;

public class Q2_可互换举行的组数 {
    class Solution {
        public long interchangeableRectangles(int[][] rectangles) {
            int n = rectangles.length;
            Map<Double, Integer> map = new HashMap<>();

            for(int i = 0 ; i < n; i++  ) {
                double r = (double)rectangles[i][0] / rectangles[i][1];
                map.put(r, map.getOrDefault(r, 0) + 1);
            }
            long ans = 0;
            for(double k : map.keySet()) {
                long m = map.get(k);
                ans += m * (m - 1) / 2;

            }
            return ans;
        }
    }
}
