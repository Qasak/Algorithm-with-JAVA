package leetcode.template.UnionFind;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/15 11:45
 */

// 如何建图？
    // 当石子没有相邻(上下左右)石子时，其不能移除
    // 1.这个石子是一个单独的节点
    // 2.这个石子是连通分量的根节点
    // 那么能移除的数量就是石子总数-连通分量数
public class Q947_RemoveStones {
    int[] parant;
    private int find(int x) {
        if(x == parant[x]) {
            return x;
        }
        return parant[x] = find(parant[x]);
    }
    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        parant[py] = px;
    }
    public int removeStones(int[][] stones) {
        parant = new int[10001];
        // HashSet<Integer> set = new HashSet<>();
        int n = stones.length;
        for(int i = 0; i < n; i++) {
            parant[i] = i;
        }
        for(int i = 0; i < n; i++) {
            int x = stones[i][0];
            int y = stones[i][1];
            for(int j = 0; j < n; j++) {
                if(stones[j][0] == x || stones[j][1] == y) {
                    union(i, j);
                }
            }
        }
        int ans = n;
        for(int i = 0; i < n; i++) {
            if(parant[i] == i) {
                ans--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] a = {{2,2},{0,1},{1,0},{1,2},{2,1},{0,0}};
        for(int []t : a) {
            System.out.println(Arrays.toString(t));
        }

    }
}
