package leetcode.template.MonotonousStack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/5 1:28
 *
 *
 * 请根据每日 气温 列表，重新生成一个列表。
 * 对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
 * 如果气温在这之后都不会升高，请在该位置用0 来代替。
 *
 * 例如，给定一个列表temperatures =
 *
 * [73, 74, 75, 71, 69, 72, 76, 73] ->
 * [1, 1, 4, 2, 1, 1, 0, 0]
 *
 */
public class Temperature_739 {
    public static int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(T[i] < T[j]) {
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;
    }
    public static int[] dailyTemperatures1(int[] T) {
        int n = T.length;
        int[] ans = new int[n];
        // 单减栈
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            while(!deque.isEmpty() && T[deque.peek()] < T[i]) {
                int idx = deque.pop();
                ans[idx] = i - idx;
            }
            deque.push(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] t = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(Temperature_739.dailyTemperatures(t)));
    }
}
