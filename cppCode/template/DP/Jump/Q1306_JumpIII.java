package leetcode.template.DP.Jump;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/21 10:50
 * 这里有一个非负整数数组arr，你最开始位于该数组的起始下标start处。当你位于下标i处时，你可以跳到i + arr[i] 或者 i - arr[i]。
 * 请你判断自己是否能够跳到对应元素值为 0 的 任一 下标处。
 *[4,,3,,,,]
 *
 *
 * 输入：arr = [4,2,3,0,3,1,2], start = 5
 *
 *
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 5 -> 下标 4 -> 下标 1 -> 下标 3
 * 下标 5 -> 下标 6 -> 下标 4 -> 下标 1 -> 下标 3
 *
 * 输入：arr = [3,0,2,1,2], start = 2
 * 输出：false
 * 解释：无法到达值为 0 的下标 1 处。
 */
public class Q1306_JumpIII {
    // 1.dfs
    static boolean[] vis;
    public static boolean canReach(int[] arr, int start) {
        int n = arr.length;
        vis = new boolean[n];
        dfs(arr, start);
        for(int i = 0; i < n; i++) {
            if(arr[i] == 0 && vis[i]) {
                return true;
            }
        }
        return false;
    }
    public static void dfs(int[] arr, int start) {
        if(vis[start]) {
            return;
        }
        vis[start] = true;
        if(start - arr[start] >= 0) {
            dfs(arr, start - arr[start]);
        }
        if(start + arr[start] < arr.length) {
            dfs(arr, start + arr[start]);
        }
    }
    // 2.bfs
    public static boolean canReach1(int[] arr, int start) {
        int n = arr.length;
        boolean[] vis = new boolean[n];
        Deque<Integer> q = new LinkedList<>();
        q.offerLast(start);
        while(!q.isEmpty()) {
            int cur = q.pollFirst();
            vis[cur] = true;
            if(arr[cur] == 0) {
                return true;
            }
            if(cur - arr[cur] >= 0 && !vis[cur - arr[cur]]) {
                q.offerLast(cur - arr[cur]);
            }
            if(cur + arr[cur] < arr.length && !vis[cur + arr[cur]]) {
                q.offerLast(cur + arr[cur]);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        // [0,3,0,6,3,3,4]
        //6
        int[] nums = new int[]{0,3,0,6,3,3,4};
        int start = 6;
        System.out.println(canReach1(nums, start));
    }
}
