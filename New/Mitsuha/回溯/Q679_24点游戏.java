package Mitsuha.回溯;

import java.util.ArrayList;
import java.util.List;

public class Q679_24点游戏 {

        private static double DIFF = 1e-6;
        private static double TARGET = 24;
        public boolean judgePoint24(int[] cards) {
            return dfs(new double[]{cards[0], cards[1], cards[2], cards[3]});
        }
        boolean dfs(double[] nums) {
            int n = nums.length;
            if(n == 1 && Math.abs(nums[0] - TARGET) < DIFF) {
                return true;
            }
            for(int i = 0; i < n; i++) {
                for(int j = i + 1; j < n; j++) {
                    double[] next = new double[n - 1];
                    for(int k = 0, idx = 0; k < n; k++) {
                        if(k != i && k != j) {
                            next[idx++] = nums[k];
                        }
                    }

                    for(double cur : caculate(nums[i], nums[j])) {
                        next[n - 2] = cur;
                        if(dfs(next)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        List<Double> caculate(double a, double b) {
            List<Double> list = new ArrayList<>();
            list.add(a + b);
            list.add(a * b);
            list.add(a - b);
            list.add(b - a);
            if(!(Math.abs(b) < DIFF)) {
                list.add(a / b);
            }
            if(!(Math.abs(a) < DIFF)) {
                list.add(b / a);
            }
            return list;
        }
}
