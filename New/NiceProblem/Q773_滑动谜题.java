package leetcode.contest.NiceProblem;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/26 11:55
 */
public class Q773_滑动谜题 {
    public int slidingPuzzle(int[][] board) {
        int[][] target = new int[][]{{1,2,3},
                {4,5,0}};
        Deque<int[][]> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        int step = 0;
        if(Arrays.deepEquals(board, target)) {
            return step;
        }
        set.add(boardToString(board));
        q.offer(board);
        while(!q.isEmpty()) {
            int n = q.size();
            for(int i = 0 ; i < n; i++) {
                int[][] tmp = q.poll();
                int[] t = findZero(tmp);
                int x = t[0], y = t[1];
                if(x > 0) {
                    swap(tmp, x, y, x - 1, y);
                    int[][] cur = copy(tmp);
                    if(Arrays.deepEquals(cur, target)) {
                        return step + 1;
                    }
                    if(!set.contains(boardToString(cur))) {
                        q.offer(cur);
                        set.add(boardToString(cur));
                    }
                    swap(tmp, x, y, x - 1, y);
                }
                if(x < 1) {
                    swap(tmp, x, y, x + 1, y);
                    int[][] cur = copy(tmp);


                    if(Arrays.deepEquals(cur, target)) {
                        return step + 1;
                    }
                    if(!set.contains(boardToString(cur))) {
                        q.offer(cur);
                        set.add(boardToString(cur));
                    }
                    swap(tmp, x, y, x + 1, y);
                }
                if(y < 2) {
                    swap(tmp, x, y, x, y + 1);
                    int[][] cur = copy(tmp);

                    if(Arrays.deepEquals(cur, target)) {
                        return step + 1;
                    }
                    if(!set.contains(boardToString(cur))) {
                        q.offer(cur);
                        set.add(boardToString(cur));
                    }
                    swap(tmp, x, y, x, y + 1);
                }
                if(y > 0) {
                    swap(tmp, x, y, x, y - 1);
                    int[][] cur = copy(tmp);
                    if(Arrays.deepEquals(cur, target)) {
                        return step + 1;
                    }
                    if(!set.contains(boardToString(cur))) {
                        q.offer(cur);
                        set.add(boardToString(cur));
                    }
                    swap(tmp, x, y, x, y - 1);
                }
            }
            step++;
        }
        return -1;
    }
    public int[] findZero(int[][] tmp) {
        int x = 0, y = 0;
        for(;x < 2; x++) {
            for(y = 0; y < 3; y++) {

                if(tmp[x][y] == 0) {

                    return new int[]{x, y};
                }
            }
        }
        return new int[]{x, y};
    }
    public void swap(int[][] tmp, int x0, int y0, int x1, int y1) {
        int t = tmp[x0][y0];
        tmp[x0][y0] = tmp[x1][y1];
        tmp[x1][y1] = t;
    }
    public String boardToString(int[][] board) {
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 3; j++) {
                ans.append(board[i][j]);
            }
            ans.append('_');
        }
        return ans.toString();
    }
    public int[][] copy(int[][] tmp) {
        int[][] cur = new int[2][3];
        for(int i = 0 ; i < 2; i++) {
            System.arraycopy(tmp[i], 0, cur[i], 0, 3);
        }
        return cur;
    }
    public static void main(String[] args) {
        Deque<int[][]> q = new LinkedList<>();
        Set<int[][]> set = new HashSet<>();
        int[][] tmp = new int[][]{{1,2,3}, {4,5,6}};
        int[][] cur = new int[2][3];
        for(int i = 0 ; i < 2; i++) {
            System.arraycopy(tmp[i], 0, cur[i], 0, 3);
        }
        tmp[0][0] = 9;
        System.out.println(cur[0][0]);
        set.add(tmp);

        System.out.println(set.contains(cur));
    }
}
