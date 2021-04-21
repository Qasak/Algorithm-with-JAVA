package leetcode.template.Simulation;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/22 9:44
 */
public class Q989_AddArray {
    public List<Integer> addToArrayForm(int[] A, int k) {
        List<Integer> ans = new ArrayList<>();
        int idx = A.length - 1;
        int t = 0;
        // [0]
        // 23
        // [3]
        // t = 0
        // k = 2
        while(idx >= 0) {
            // 当前和
            int sum = A[idx] + k % 10 + t;
            ans.add(sum % 10);
            k /= 10;
            t = sum / 10;
            idx--;
        }
        while(k > 0) {
            // 当前值
            int sum = k % 10 + t;
            ans.add(sum % 10) ;
            // 进位
            k /= 10;
            t = sum / 10;
        }
        if(t > 0) {
            ans.add(1);
        }
        Collections.reverse(ans);
        return ans;
    }
    public List<Integer> addToArrayForm1(int[] A, int k) {
        LinkedList<Integer> ans = new LinkedList<>();
        int idx = A.length - 1;
        int t = 0;
        while(idx >= 0 || k > 0) {
            // 当前和
            int sum = t;
            sum += idx >= 0 ? A[idx] : 0;
            sum += k > 0 ? k % 10 : 0;
            ans.addFirst(sum % 10);
            k /= 10;
            t = sum / 10;
            idx--;
        }
        if(t > 0) {
            ans.addFirst(1);
        }
        return ans;
    }
    public static void main(String[] args) {
        Deque<Integer> list = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>(list);
        Collections.reverse(arr);
    }
}
