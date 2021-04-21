package leetcode.template.heap;

import java.util.PriorityQueue;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/27 12:00
 *
 * 有一棵特殊的苹果树，一连 n 天，每天都可以长出若干个苹果。
 * 在第 i 天，树上会长出 apples[i] 个苹果，这些苹果将会在 days[i] 天后（也就是说，第 i + days[i] 天时）腐烂，变得无法食用。
 * 也可能有那么几天，树上不会长出新的苹果，此时用 apples[i] == 0 且 days[i] == 0 表示。
 *
 * 你打算每天 最多 吃一个苹果来保证营养均衡。注意，你可以在这 n 天之后继续吃苹果。
 *
 * 给你两个长度为 n 的整数数组 days 和 apples ，返回你可以吃掉的苹果的最大数目。
 *
 * 输入：apples = [1,2,3,5,2], days = [3,2,1,4,2]
 * 输出：7
 */
public class Q5638_EatenApples {
    public int eatenApples(int[] apples, int[] days) {
        // 优先队列，队首是最早过期的  int[0]:苹果个数  int[1]:过期时间
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int cnt = 0;
        int n = apples.length;
        for(int i = 0; i < n || !pq.isEmpty(); i++) {
            // 放入新生成的苹果及过期日期
            if(i < n) {
                pq.add(new int[]{apples[i], i + days[i]});
            }
            // 过期一批苹果
            while(!pq.isEmpty() && pq.peek()[1] <= i) {
                pq.poll();
            }
            // 吃一个未过期的苹果
            // 若吃完，把它淘汰
            if(!pq.isEmpty()) {
                int[] a = pq.peek();
                if(a[0] > 0) {
                    a[0]--;
                    cnt++;
                }
                if(a[0] == 0) {
                    pq.poll();
                }

            }
        }
        return cnt;
    }
}
