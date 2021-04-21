package leetcode.template.Window;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/23 10:34
 */
public class Q1052 {
    //
    public int maxSatisfied1(int[] customers, int[] grumpy, int X) {
        int ans = 0;
        int n = customers.length;
        for(int i = 0; i < n; i++) {
            if(grumpy[i] == 0 ) {
                ans += customers[i];
            }
        }
        int extra = 0;
        int window = 0;
        int l = 0;
        for(int r = 0; r < n; r++) {
            if(r - l + 1 > X) {
                window -= customers[l] * grumpy[l];
                l++;
            }
            window += customers[r] * grumpy[r];
            extra = Math.max(extra, window);
        }
        ans += extra;
        return ans;
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int ans = 0;
        int n = customers.length;
        int l = 0;
        int window = 0;
        int start = 0;
        int[] pre = new int[n + 1];
        boolean flag = true;
        boolean[] isAngry = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(grumpy[i] == 1) {
                int j = 0;
                while(i - j >= 0 && j < X) {
                    isAngry[i - j] = true;
                    j++;
                }
                j = 0;
                while(i + j < n && j < X) {
                    isAngry[i + j] = true;
                    j++;
                }
            }
        }
        for(int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + (grumpy[i] == 1 ? customers[i] : 0);
        }

        for(int r = 0; r < n; r++) {
            if(isAngry[r] && r + X <= n) {
                if(pre[r + X] - pre[r] > window) {
                    flag = false;
                    start = r;
                    window = pre[r + X] - pre[r];
                }
            }
        }
        for(int i = 0; i < n; i++) {
            if(grumpy[i] == 0 ) {
                ans += customers[i];
            }
        }
        ans += window;
        return ans;
    }

}
