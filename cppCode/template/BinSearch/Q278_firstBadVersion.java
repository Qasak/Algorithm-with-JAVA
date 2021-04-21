package leetcode.template.BinSearch;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/3 16:09
 */
public class Q278_firstBadVersion {
    boolean isBadVersion(int m) {
        return (m & 1) == 1;
    }
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while(l < r) {
            int m = (l + r) >>> 1;
            System.out.println(m);
            if(!isBadVersion(m)) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println((1 + 2147483647) >>> 1);
    }
}
