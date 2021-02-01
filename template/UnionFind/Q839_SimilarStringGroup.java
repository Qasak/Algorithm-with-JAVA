package leetcode.template.UnionFind;

import Utils.StringUtil;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/31 0:08
 */
public class Q839_SimilarStringGroup {
    class UF {
        int[] uf;
        int n;
        int cnt;
        public UF(int n) {
            this.n = n;
            cnt = n;
            uf = new int[n];
            for(int i = 0; i < n; i++) {
                uf[i] = i;
            }
        }
        public int find(int x) {
            if(uf[x] == x) {
                return x;
            }
            return uf[x] = find(uf[x]);
        }
        public void union(int x, int y) {
            int px = find(x); int py = find(y);
            if(px != py) {
                cnt--;
                uf[px] = py;
            }
        }
    }
    // 列表中的每个字符串都是 strs 中其它所有字符串的一个字母异位词
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        UF uf = new UF(n);
        for(int i = 0 ; i < n ; ++i) {
            for(int j = 0; j < n; ++j) {
                // if(i == j) {
                //     continue;
                // }
                if(check(strs[i], strs[j])) {
                    uf.union(i, j);
                }
            }
        }
        return uf.cnt;
    }
    public boolean check(String a, String b) {
        int r = a.length() - 1;
        int l = 0;
        boolean flag = false;
        while(l < r) {
            if(a.charAt(l) == b.charAt(l) && a.charAt(r) == b.charAt(r)) {
                l++; r--;
            } else {
                if(flag) {
                    return false;
                } else {
                    if(a.charAt(l) == b.charAt(r) && a.charAt(r) == b.charAt(l)) {
                        flag = true;
                        l++; r--;
                    } else if(a.charAt(r) == b.charAt(r)){
                        r--;
                    } else if(a.charAt(l) == b.charAt(l)) {
                        l++;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        for(int i = 0 ; i < 10; i++) {
            System.out.println();
        }
    }
}
