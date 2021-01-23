package leetcode.template.UnionFind;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/23 0:18
 */
public class Q1319_MakeConnected {
    class UF{
        int[] uf;
        int cnt;
        public UF(int n) {
            uf = new int[n];
            for(int i = 0; i < n; i++) {
                uf[i] = i;
            }
            cnt = n;
        }
        int find(int x) {
            if(x == uf[x]) {
                return x;
            }
            return uf[x] = find(uf[x]);
        }
        void union(int x, int y) {
            uf[find(y)] = find(x);
            cnt--;
        }
    }
    public int makeConnected(int n, int[][] edges) {
        int m = edges.length;
        if(m < n - 1) {
            return -1;
        }
        UF uf = new UF(n);
        for(int[] e : edges) {
            if(uf.find(e[0]) != uf.find(e[1])) {
                uf.union(e[0], e[1]);
            }
        }
        return uf.cnt - 1;
    }
}
