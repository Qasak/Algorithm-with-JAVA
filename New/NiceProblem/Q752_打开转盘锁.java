package leetcode.contest.NiceProblem;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/25 9:25
 */
public class Q752_打开转盘锁 {
    // BFS
    // 为什么DFS不行？
    // 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
    //输出：6
    //解释：
    //可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
    // 遍历完最后一个位置后又改了第一个位置
    Set<String> set = new HashSet<>();
    public int openLock(String[] deadends, String target) {
        for(String s : deadends) {
            set.add(s);
        }
        String start = "0000";
        if(set.contains(start)) {
            return -1;
        }
        if(target.equals(start)) {
            return 0;
        }
        Deque<String> q = new LinkedList<>();
        q.offer(start);
        set.add(start);
        int step = 1;
        while(!q.isEmpty()) {
            int n = q.size();
            for(int i = 0; i < n; i++) {
                String tmp = q.poll();
                char[] cs = tmp.toCharArray();

                for(int j = 0; j < 4; j++) {
                    char p = cs[j];
                    String cur;
                    if(cs[j] < '9') {
                        cs[j]++;

                    } else {
                        cs[j] = '0';
                    }
                    cur = new String(cs);
                    if(!set.contains(cur)) {
                        if(target.equals(cur)) {
                            return step;
                        }
                        q.offer(cur);
                        set.add(cur);
                    }
                    cs[j] = p;
                    if(cs[j] > '0') {
                        cs[j]--;
                    } else {
                        cs[j] = '9';
                    }
                    cur = new String(cs);
                    if(!set.contains(cur)) {
                        if(target.equals(cur)) {
                            return step;
                        }
                        q.offer(cur);
                        set.add(cur);
                    }
                    cs[j] = p;
                }
            }
            step++;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println((-2 % 10));
    }
}
