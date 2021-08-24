package leetcode.template.queue;

import java.util.PriorityQueue;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/21 12:28
 */
public class Q5710_积压订单中的订单总数 {
    class Solution {
        private final int mod = (int) (1e9 + 7);
        public int getNumberOfBacklogOrders(int[][] orders) {
            int ans = 0;
            PriorityQueue<int[]> buy = new PriorityQueue<> ((int []a, int []b) -> {
                return b[0] - a[0];
            });
            PriorityQueue<int[]> sell = new PriorityQueue<> ((int[] a, int[] b) -> {
                return a[0] - b[0];
            });
            for(int[] o : orders) {
                deal(buy, sell, o);
            }
            while(!buy.isEmpty()) {
                int[] t = buy.poll();
                ans = (ans + t[1]) % mod;
            }
            while(!sell.isEmpty()) {
                int[] t = sell.poll();
                ans = (ans + t[1]) % mod;

            }
            return ans;
        }
        public void deal(PriorityQueue<int[]> buy, PriorityQueue<int[]> sell, int[] order) {
            if(order[2] == 0) {
                while(!sell.isEmpty() && order[1] > 0 && sell.peek()[0] <= order[0]) {
                    int[] t = sell.poll();
                    if(order[1] >= t[1]) {
                        order[1] -= t[1];
                    } else {
                        sell.offer(new int[]{t[0], t[1] - order[1], 1});
                        order[1] = 0;
                    }

                }
                if(order[1] != 0) {
                    buy.offer(order);
                }
            } else {
                while(!buy.isEmpty() && order[1] > 0 && buy.peek()[0] >= order[0]) {
                    int[] t = buy.poll();
                    if(order[1] >= t[1]) {
                        order[1] -= t[1];
                    } else {
                        buy.offer(new int[]{t[0], t[1] - order[1], 0});
                        order[1] = 0;
                    }
                }
                if(order[1] != 0) {
                    sell.offer(order);
                }
            }
        }
    }

}
