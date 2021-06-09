package leetcode.contest.NiceProblem;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/8 15:48
 */
public class Q347_前k个高频元素 {
    // 快速选择
    Random rand = new Random();
    int cnt = 0;
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();


        // [num: freq]
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[][] tmp = new int[map.size()][2];
        int idx = 0;
        // [freq, num]
        for(int i : map.keySet()) {
            tmp[idx][0] = map.get(i);
            tmp[idx][1] = i;
            idx++;
        }
        // freq 从大到小排序
        // quickSelect
        quickSelect(tmp, 0, map.size() - 1, k - 1);
        // Arrays.sort(tmp, (a, b) -> (b[0] - a[0]));
        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            ans[i] = tmp[i][1];

        }
        return ans;
    }
    public void quickSelect(int[][] tmp, int l, int r, int k) {
        if(l >= r) {
            return;
        }
        int[] p = partition(tmp, l, r);
        if(p[0] <= k) {
            cnt += p[1] - p[0] + 1;
        }
        if(cnt == k + 1) {
            return;
        }
        quickSelect(tmp, l, p[0] - 1, k);
        quickSelect(tmp, p[1] + 1, r, k);
    }
    public int[] partition(int[][] tmp, int l, int r) {
        swap(tmp, rand.nextInt(r - l + 1) + l, r);
        int i = l - 1;
        int k = r;
        int j = l;
        while(j < k) {
            if(tmp[j][0] > tmp[r][0]) {
                swap(tmp, ++i, j++);
            } else if(tmp[j][0] < tmp[r][0]){
                swap(tmp, --k, j);
            } else {
                j++;
            }
        }
        swap(tmp, j, r);
        return new int[]{i + 1, j};
    }
    public void swap(int[][] tmp, int i, int j) {
        int tfreq = tmp[i][0];
        int tnum = tmp[i][1];
        tmp[i][0] = tmp[j][0];
        tmp[i][1] = tmp[j][1];
        tmp[j][0] = tfreq;
        tmp[j][1] = tnum;
    }


    // 优先队列
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // [num: freq]
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for(int i : map.keySet()) {
            pq.offer(new int[]{i, map.get(i)});
        }
        int[] ans = new int[k];
        int idx = 0;
        while(k-- > 0) {
            ans[idx++] = pq.poll()[0];
        }
        return ans;
    }
    public static void main(String[] args) {
        Random rand = new Random();
        rand.nextInt();
    }
}
