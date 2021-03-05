package leetcode.template.Window;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/15 2:28
 */
public class Q1004 {
    public int longestOnes(int[] A, int K) {
        int n = A.length;
        int l = 0;
        int cnt = 0;
        int ans = 0;
        for(int r = 0; r < n; r++) {
            if(A[r] == 0) {
                cnt++;
            }
            while(l <= r && cnt == K + 1) {
                if(A[l] == 0) {
                    cnt--;
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
