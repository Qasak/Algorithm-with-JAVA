package leetcode.contest.NiceProblem;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/27 22:58
 */
public class Q909_蛇梯棋 {
    public int snakesAndLadders(int[][] board) {
        int N = board.length;
        Set<Integer> vis = new HashSet<>();
        Map<Integer, int[]> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        int a = N - 1, b = 0;
        int flag = 1;
        for(int i = 1; i <= N * N; i++) {
            if(b == N || b == -1) {
                flag = -flag;
                a--;
                b += flag;
            }
            map1.put(i, new int[]{a, b});
            b += flag;
        }
        // System.out.println(Arrays.toString(map1.get(1)));
        for(int k : map1.keySet()) {
            StringBuilder sb = new StringBuilder();
            int[] idx = map1.get(k);
            sb.append(idx[0]);
            sb.append("_");
            sb.append(idx[1]);
            map2.put(sb.toString(), k);
        }

        Deque<Integer> q = new LinkedList<>();
        q.offer(1);
        int step = 0;
        while(!q.isEmpty()) {
            int n = q.size();
            // System.out.println(q);
            for(int i = 0; i < n; i++) {
                int id = q.poll();
                if(id == N * N) {
                    return step;
                }
                if(vis.contains(id)) {
                    continue;
                }
                vis.add(id);
                int[] idx = map1.get(id);
                int x = idx[0], y = idx[1];
                for(int j = 1; j <= 6 && id + j <= N * N; j++) {
                    StringBuilder sb = new StringBuilder();
                    int nextId = id + j;
                    int xx = map1.get(nextId)[0], yy = map1.get(nextId)[1];
                    // System.out.println(xx + " " + yy + " " + board[xx][yy]);
                    if(board[xx][yy] == -1) {
                        q.offer(nextId);
                    } else {
                        nextId = map2.get(sb.append(map1.get(board[xx][yy])[0]).append('_').append(map1.get(board[xx][yy])[1]).toString());
                        q.offer(nextId);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
