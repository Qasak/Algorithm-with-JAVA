package NewCoder.MaxSubArr;

import java.util.Scanner;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/13 15:22
 */
public class Main {
    private static int[] solve(int[] nums) {
        int[] ret = new int[3];
        int n = nums.length;
        int ans = nums[0];
        int dp = nums[0];
        int r = 0;
        int len = 1;
        int realLen = 1;
        for(int i = 1; i < n; i++) {
            if(dp > 0) {
                dp = dp + nums[i];
                len++;
            } else {
                dp = nums[i];
                len = 1;
            }
            // 更新全局最大值的同时， 更新长度
            if(dp > ans) {
                ans = dp;
                r = i;
                realLen = len;
            }
        }
        if(ans >= 0) {
            ret[0] = ans; ret[1] = nums[r - realLen + 1]; ret[2] = nums[r];
        } else {
            ret[0] = 0; ret[1] = nums[0]; ret[2] = nums[n - 1];
        }
        return ret;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int n = scan.nextInt();
            if(n == 0) {
                break;
            }
            int[] nums = new int[n];
            for(int i = 0; i < n; i++) {
                nums[i] = scan.nextInt();
            }
            // ans: 全局最大值
            int[] ret = solve(nums);
            System.out.printf("%d %d %d\n", ret[0], ret[1], ret[2]);
        }
    }
}
