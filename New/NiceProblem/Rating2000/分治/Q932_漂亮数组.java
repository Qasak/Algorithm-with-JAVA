package leetcode.contest.Rating2000.分治;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/19 10:17
 */
public class Q932_漂亮数组 {
    public int[] beautifulArray(int N) {
        int[] ans = new int[N];
        if(N == 1) {
            ans[0] = 1;
            return ans;
        }
        // 1 2 3 -> 1 3 5
        // 1 2 -> 2 4
        int[] l = beautifulArray((N + 1) / 2);
        int[] r = beautifulArray(N / 2);
        int idx = 0;
        for(int i : l) {
            ans[idx++] = i * 2 - 1;
        }
        for(int i : r) {
            ans[idx++] = i * 2;
        }
        return ans;
    }
}
