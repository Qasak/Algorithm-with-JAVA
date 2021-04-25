package leetcode.SpringRecruit.Greedy;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/19 14:58
 */
public class Q135_分发糖果 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] c = new int[n + 2];
        int[] r = new int[n + 2];
        r[0] = r[n + 1] = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            r[i] = ratings[i - 1];
        }
        Arrays.fill(c, 1);
        c[0] = c[n + 1] = 0;
        for(int i = 1; i <= n; i++) {
            if(r[i] > r[i - 1] && r[i] > r[i + 1]) {
                c[i] = Math.max(c[i - 1], c[i + 1]) + 1;
            } else if(r[i] > r[i - 1]) {
                c[i] = c[i - 1] + 1;
            } else if(r[i] > r[i + 1]) {
                c[i] = c[i + 1] + 1;
            }
        }
        for(int i = n; i >= 1; i--) {
            if(r[i] > r[i - 1] && r[i] > r[i + 1]) {
                c[i] = Math.max(c[i - 1], c[i + 1]) + 1;
            } else if(r[i] > r[i - 1]) {
                c[i] = c[i - 1] + 1;
            } else if(r[i] > r[i + 1]) {
                c[i] = c[i + 1] + 1;
            }
        }
        int ans = 0;
        for(int i = 1; i <= n ; i++) {
            ans += c[i];
        }
        return ans;
    }
    class Solution {
        public int candy(int[] arr) {
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
}
