package leetcode.template.UnionFind;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/13 9:39
 */
public class Q684_RedundantConn {
    int[] parent;
    // 直到下标和值相等
    private int find(int x) {
        if(x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private void union (int x, int y) {
        int px = find(x);
        int py = find(y);
        // x的集合标记改成y的集合标记
        // [1,2] [2,3]
        //  parent:
        // 1 2 3
        // 2 2 3
        // 2 3 3

        // p[1] = 2
        // p[2] = 3
        // p[3] = 4
        // p[1] = 4
        // p[1] = 5

        // 1 2 3 4 5
        // 4 3 4 4 5
        //

        // 1 2 3
        // 2 3 3
        parent[px] = py;

    }
    public int[] findRedundantConnection(int[][] edges) {
        // 如果有多个答案，则返回二维数组中最后出现的边
        int n = edges.length;

        int[] ans = new int[2];
        parent = new int[n + 1];
        for(int i = 1; i <= n ; i++) {
            parent[i] = i;
        }
        for(int i = 0; i < n; i++) {
            if(find(edges[i][0]) != find(edges[i][1])) {
                union(edges[i][0], edges[i][1]);
            } else {
                return edges[i];
            }
        }
        return ans;
    }
    public int[] findRedundantConnection1(int[][] edges) {
        // 如果有多个答案，则返回二维数组中最后出现的边
        int n = edges.length;

        int[] ans = new int[2];
        // p:总标记
        for(int j = n - 1; j >= 0; j--) {
            parent = new int[n + 1];
            for(int i = 1; i <= n ; i++) {
                parent[i] = i;
            }
            for(int i = 0; i < n; i++) {
                if(j != i) {
                    union(edges[i][0], edges[i][1]);
                }
            }
            int p = find(1);
            boolean flag = false;
            for(int i = 2; i <= n; i++) {
                if(find(i) != p) {
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                ans[0] = edges[j][0];
                ans[1] = edges[j][1];
                return ans;
            }
        }
        return ans;
    }

}
