package leetcode.contest.Rating1800.BFS;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/19 9:52
 */
public class Q1345_跳跃游戏4 {
    // 1. BFS超内存
    public int minJumps(int[] arr) {
        int n = arr.length;
        // 值 ：下标
        // List<int[]> list = new ArrayList<>();
        // for(int i = 0; i < n; i++) {
        //     int[] t = new int[]{arr[i], i};
        //     list.add(t);
        // }
        // Collections.sort(list, (a, b) -> (a[0] - b[0]));
        // 值：{可到达的下标集合}
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        // System.out.println(map);
        //BFS
        Deque<int[]> q = new LinkedList<>();
        // 值：下标
        q.offer(new int[]{arr[0], 0});
        boolean[] vis = new boolean[n];
        int dist = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int[] t = q.poll();
                if(t[1] == n - 1) {
                    return dist;
                }
                vis[t[1]] = true;
                for(int idx : map.get(t[0])) {
                    if(!vis[idx]) {
                        q.offer(new int[]{arr[idx], idx});
                    }
                }
                if(t[1] - 1 >= 0 && !vis[t[1] - 1]) {
                    q.offer(new int[]{arr[t[1] - 1], t[1] - 1});
                }
                if(t[1] + 1 < n && !vis[t[1] + 1]) {
                    q.offer(new int[]{arr[t[1] + 1], t[1] + 1});
                }
            }
            dist++;
        }
        return dist;
    }


    // 双向BFS
    int dist = 0;
    public int minJumps1(int[] arr) {
        int n = arr.length;
// 创建「两个队列」分别用于两个方向的搜索；

// 创建「两个哈希表」用于「解决相同节点重复搜索」和「记录转换次数」；

// 为了尽可能让两个搜索方向“平均”，每次从队列中取值进行扩展时，先判断哪个队列容量较少；

// 如果在搜索过程中「搜索到对方搜索过的节点」，说明找到了最短路径。
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        // System.out.println(map);
        //BFS
        Deque<int[]> q1 = new LinkedList<>();
        Deque<int[]> q2 = new LinkedList<>();

        // 值：下标
        q1.offer(new int[]{arr[0], 0});
        q2.offer(new int[]{arr[n - 1], n - 1});

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        while(!q1.isEmpty() && !q2.isEmpty()) {
            if(q1.size() < q2.size()) {
                if(update(q1, set1, set2, map, arr) != -1) {
                    return dist - 1;
                }
            } else {
                if(update(q2, set2, set1, map, arr) != -1) {
                    return dist - 1;
                }
            }
            dist++;
        }
        return dist - 1;
    }
    private int update(Deque<int[]> q, Set<Integer> cur, Set<Integer> other, Map<Integer, List<Integer>> map, int[] arr) {
        int n = arr.length;
        int size = q.size();
        while(size-- > 0) {
            int[] t = q.poll();
            if(other.contains(t[1])) {
                return dist;
            }
            cur.add(t[1]);
            for(int idx : map.get(t[0])) {
                if(!cur.contains(idx)) {
                    q.offer(new int[]{arr[idx], idx});
                }
            }
            if(t[1] - 1 >= 0 && !cur.contains(t[1] - 1)) {
                q.offer(new int[]{arr[t[1] - 1], t[1] - 1});
            }
            if(t[1] + 1 < n && !cur.contains(t[1] + 1)) {
                q.offer(new int[]{arr[t[1] + 1], t[1] + 1});
            }
        }
        return -1;
    }
}
