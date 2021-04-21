package leetcode.template.Greedy;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/24 13:07
 */
public class Q135_Candy {
    public int candy(int[] arr) {
        //  1 2 2 3
        //  1 2 1 2

        // 1 2 3 4
        // 1 2 3 4

        // 4 3 2 1
        // 4 3 2 1

        // 4 3 0 1 3
        // 3 2 1 2 3

        // 1 2 1
        // 1 2 1

        // 0 9 2 8 3 7 1 6 4 8 0
        // 0 2 1 2 1 2 1 2 1 2
        //

        // 1 2 2
        // 1 2 1

        // 0 2 9 3 8 7 4 6 0
        // 0 1 2 1 2 1 1 2 0

        // 0 1 2 3 4 0
        // 0 1 2 3 4 0

        // 0 1 2 2 0
        // 0 1 2 1 0

        // 0 1 2 2 2 0
        // 0 1 2 1 1 0

        // 0 1 2 3 4 0
        // 0 1 2 3 4 0
        //
        // 9 8 9 8 9
        // 2 1 2 1 2
        int n = arr.length;
        if(n == 0) {
            return 0;
        }
        int[] cnt = new int[n];
        Arrays.fill(cnt, 1);
        for(int i = 1; i < n; i++) {
            if(arr[i] > arr[i - 1]) {
                cnt[i] = cnt[i - 1] + 1;
            }
        }
        for(int i = n - 2; i >= 0; i--) {
            if(arr[i] > arr[i + 1] && cnt[i] <= cnt[i + 1]) {
                cnt[i] = cnt[i + 1] + 1;
            }
        }
        int ans = 0;
        for(int i : cnt) {
            ans += i;
        }
        return ans;
    }
}
