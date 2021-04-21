package leetcode.template.Brutal;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/28 12:15
 */
public class Q5690 {
    int ans;
    public int closestCost(int[] A, int[] B, int target) {
        ans = -1;
        int n = A.length, m = B.length;
        for(int i = 0; i < n; i++) {
            dfs(A[i], B, 0, target);
        }
        return ans;
    }
    public void dfs(int cur, int[] B, int idx, int target) {
        if(ans == -1 || Math.abs(target - cur) < Math.abs(target - ans) ||
                ((Math.abs(target - ans) == Math.abs(target - cur)) && cur < ans)) {
            ans = cur;
        }
        if(idx == B.length) {
            return;
        }
        dfs(cur, B, idx + 1, target);
        dfs(cur + B[idx], B, idx + 1, target);
        dfs(cur + B[idx] * 2, B, idx + 1, target);
    }

    public static void main(String[] args) {
    }
}
