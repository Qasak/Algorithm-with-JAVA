package leetcode.template.Greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/5 0:29
 *
 * 输入：tasks = ["A","A","A","B","B","B"], n = 2
 * 输出：8
 * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
 *
 *输入：tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
 * 输出：16
 * 解释：一种可能的解决方案是：
 *      (A -> B -> C) -> (A -> D -> E) -> (A -> F -> G) ->
 *      (A -> (待命) -> (待命)) -> (A -> (待命) -> (待命)) -> A
 *
 * tasks = [A,A,A,A,A,A,A] n = 0
 * out: 7
 */
public class Task_621 {
    // 计算完成所有任务所需要的 最短时间
    // 两个相同类型任务之间必须间隔长度为 n 的冷却时间
    int ans = 0;
    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        int maxCnt = 0;
        for(char c : tasks) {
            int t = map.getOrDefault(c, 0) + 1;
            map.put(c, t);
            maxCnt = Math.max(maxCnt, t);
        }

        int k = 0;
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if(value == maxCnt) {
                k++;
            }
        }
        return Math.max((maxCnt - 1) * (n + 1) + k, tasks.length);
    }
    public static int leastInterval1(char[] tasks, int n) {
        //填桶思路
        //https://leetcode-cn.com/problems/task-scheduler/solution/tian-tong-si-lu-you-tu-kan-wan-jiu-dong-by-mei-jia/
        int[] counts = new int[26];
        for(char task : tasks){
            counts[task-'A'] += 1;
        }

        int max = 0;
        for(int count : counts){
            max = Math.max(count, max);
        }

        int maxCount = 0;
        for(int count : counts){
            if(count == max){
                maxCount++;
            }
        }
        return Math.max(tasks.length, (n+1) * (max - 1) + maxCount);
    }
    public static void main(String[] args) {
        char[] t = new char[]{'A','A','A','B','B','B','C','C','C','D','D','D'};
        // A B
        int n = 4;
        System.out.println(Task_621.leastInterval(t, n));
    }
}
