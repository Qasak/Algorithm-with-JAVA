package NewCoder.Zuo;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/5/13 18:14
 */
public class CD54_容器盛水问题 {

    // 单调栈

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Deque<Integer> stk = new LinkedList<>();
        long ans = 0;
        for(int i = 0; i < n; i++) {
            while(!stk.isEmpty() && arr[i] > arr[stk.peek()]) {
                long cur = arr[stk.pop()];
                if(!stk.isEmpty()) {
                    ans += (Math.min(arr[i], arr[stk.peek()]) - cur) * (i - stk.peek() - 1);
                }
            }
            stk.push(i);
        }
        System.out.println(ans);
    }
    // 双指针
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long ans = 0;
        int l = 0, r = n - 1;
        int lh = arr[l], rh = arr[r];
        while(l <= r) {
            lh = Math.max(lh, arr[l]);
            rh = Math.max(rh, arr[r]);
            if(lh <= rh) {
                ans += lh - arr[l++];
            } else {
                ans += rh - arr[r--];
            }
        }
        System.out.println(ans);
    }
}
