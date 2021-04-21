package leetcode.template.UnionFind;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/14 0:41
 */
public class Q765 {
    // 1. 并查
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
            if(uf[x] == x) {
                return x;
            }
            return uf[x] = find(uf[x]);
        }
        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if(px == py) {
                return;
            }
            uf[px] = py;
            cnt--;
        }
    }
    public int minSwapsCouples(int[] row) {
        int n = row.length / 2;
        UF uf = new UF(n);
        for(int i = 0; i < row.length; i += 2) {
            uf.union(row[i] / 2, row[i + 1] / 2);
        }
        return n - uf.cnt;
    }
    // 2. 贪心
    public int minSwapsCouples1(int[] row) {
        int ans = 0;
        int n = row.length;
        for (int i = 0; i < n; ++i) {
            int a = row[i];
            int b = a ^ 1;
            if (i + 1 >= n - 1 || row[i + 1] == b) {
                continue;
            }
            for (int j = i + 1; j < n; ++j) {
                if (row[j] == b) {
                    swap(row, j, i + 1);
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
    public int minSwapsCouples2(int[] row) {
        int ans = 0;
        int n = row.length;
        for (int i = 0; i < n; i += 2) {
            if(row[i] / 2 == row[i + 1] / 2) {
                continue;
            }
            int j = i + 1;
            while (j < n && row[j] / 2 != row[i] / 2) {
                j++;
            }
            ans++;
            swap(row, j, i + 1);
        }
        return ans;
    }
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
