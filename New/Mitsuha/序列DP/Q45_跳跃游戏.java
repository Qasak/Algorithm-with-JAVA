package Mitsuha.序列DP;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/11 17:14
 */
public class Q45_跳跃游戏 {
    // BFS
    // 循环入队操作（由于 st 的存在，不一定都能入队，但是每个点都需要被循环一下）。复杂度为 O(n^2)O(n
    //2
    // )
    //空间复杂度：队列中最多有 n - 1n−1 个元素。复杂度为 O(n)O(n)

    public int jump(int[] nums) {
        //BFS
        int n = nums.length;
        if(n <= 1) {
            return 0;
        }
        boolean[] vis = new boolean[n];
        vis[0] = true;
        Deque<Integer> q = new LinkedList<>();
        q.offer(0);
        int dist = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int i = q.poll();
                int len = nums[i];
                if(i + len >= n - 1) {
                    return dist + 1;
                }
                for(int j = 1; j <= len; j++) {
                    int v = i + j;
                    if(vis[v]) {
                        continue;
                    }
                    vis[v] = true;
                    q.offer(i + j);
                }
            }
            dist++;
        }
        return dist;
    }
    public int jump1(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return 0;
        }
        // f[i] : 能一步跳到i点的最小步数
        int[] f = new int[n];
        for(int i = 1, j = 0; i < n; i++) {
            while(j < i && j + nums[j] < i) {
                j++;
            }
            // j + nums[j] >= i
            // 能跳到i的j点集合中的最小的[j];
            f[i] = f[j] + 1;
        }
        return f[n - 1];
    }

}
