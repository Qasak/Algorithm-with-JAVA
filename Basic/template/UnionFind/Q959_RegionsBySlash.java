package leetcode.template.UnionFind;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/25 13:18
 */
public class Q959_RegionsBySlash {
    class UF {
        int[] uf;
        int cnt;
        public UF(int n) {
            uf = new int[n];
            for(int i = 0 ; i < n; i++) {
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
            int px = find(x); int py = find(y);
            if(px != py) {
                cnt--;
            }
            uf[px] = py;
        }
    }
    public int regionsBySlashes(String[] grid) {
        int m = grid.length;
        // n : 可划分的区域总数
        int n = m * m * 2;
        UF uf = new UF(n);
        for(int i = 0 ; i < m; i++) {
            for(int j = 0; j < m; j++) {
                int x = i * m * 2 + j * 2;
                int y = x + 1;
                if(grid[i].charAt(j) == ' ') {
                    uf.union(x, y);
                }
            }
        }
        for(int i = 0 ; i < m; i++) {
            for(int j = 0; j < m; j++) {
                int x = i * m * 2 + j * 2;
                int y = x + 1;
                if(grid[i].charAt(j) == ' ') {
                    if(j + 1 < m) {
                        uf.union(y, uf.find(y + 1));
                    }
                    if(i + 1 < m) {
                        if(grid[i + 1].charAt(j) == '/') {
                            uf.union(y, (i + 1) * m * 2 + j * 2);
                        } else {
                            uf.union(y, uf.find((i + 1) * m * 2 + j * 2 + 1));
                        }
                    }
                }
                if(grid[i].charAt(j) == '/') {
                    if(j + 1 < m) {
                        uf.union(y, uf.find(y + 1));
                    }
                    if(i + 1 < m) {
                        if(grid[i + 1].charAt(j) == '/') {

                            uf.union(y, (i + 1) * m * 2 + j * 2);
                        } else {
                            uf.union(y, uf.find((i + 1) * m * 2 + j * 2 + 1));
                        }
                    }
                }
                if(grid[i].charAt(j) == '\\') {
                    if(j + 1 < m) {
                        uf.union(y, y + 1);
                    }
                    if(i + 1 < m) {
                        if(grid[i + 1].charAt(j) == '/') {
                            uf.union(x, (i + 1) * m * 2 + j * 2);
                        } else {
                            uf.union(x, uf.find((i + 1) * m * 2 + j * 2 + 1));
                        }
                    }
                }
            }
        }
        return uf.cnt;
    }
}
