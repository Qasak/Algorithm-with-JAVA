package leetcode.template.Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/7 17:57
 */
public class Q253_会议室2 {
    public int minMeetingRooms(int[][] nums) {
        Arrays.sort(nums, (a, b) -> (a[0] - b[0]));
        int ans = 1;
        int l = nums[0][0];
        int r = nums[0][1];
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(r);
        for(int i = 1; i < n; i++) {
            // System.out.println(pq);
            if(pq.peek() > nums[i][0]) {
                ans++;
            } else {
                pq.poll();
            }
            pq.offer(nums[i][1]);
        }
        return ans;
    }
}
