package leetcode.SpringRecruit.Recursion;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/25 17:44
 */
public class Q932_漂亮数组 {
    // 分治 O(nlogn)
    // 如果一个数组是漂亮数组，那么其线性变换之后的数组也是漂亮数组
    public int[] beautifulArray(int N) {
        int[] ans = new int[N];
        if(N == 1) {
            ans[0] = 1;
            return ans;
        }
        // 1 2 3
        // 1 2
        int[] l = beautifulArray((N + 1) / 2);
        int[] r = beautifulArray(N / 2);
        // System.out.println(Arrays.toString(l) + " " + Arrays.toString(r));
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
