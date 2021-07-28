package leetcode.contest.Rating1400.滑动窗口;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/28 23:21
 */
public class Q978_最长湍流子数组 {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if(n == 1 ) {
            return n;
        }
        if(n == 2) {
            if(arr[0] == arr[1]) {
                return 1;
            } else {
                return 2;
            }
        }
        boolean flag = false;
        int ans = 1;
        int l = 0;
        for(int r = 1; r < n - 1; r++) {
            if(arr[l] == arr[r]) {
                l++;
                continue;
            }
            flag = arr[l] < arr[r];
            while(r < n - 1) {
                if(flag) {
                    if(arr[r] > arr[r + 1]) {
                        flag = !flag;
                        r++;
                    } else {
                        ans = Math.max(ans, r - l + 1);
                        l = r;
                        break;
                    }
                } else  {
                    if(arr[r] < arr[r + 1]) {
                        flag = !flag;
                        r++;
                    } else {
                        ans = Math.max(ans, r - l + 1);
                        l = r;
                        break;
                    }
                }
                ans = Math.max(ans, r - l + 1);
            }
        }
        return ans;
    }
}
