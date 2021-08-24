package leetcode.template.Simulation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/22 18:41
 */
public class Q66_PlusOne {
    public int[] plusOne(int[] digits) {
        // 999
        // 1000
        List<Integer> list = new ArrayList<>();
        int n = digits.length;
        int c = 0;
        digits[n - 1]++;
        for(int i = n - 1; i >= 0; i--) {
            int sum = digits[i] + c;
            list.add(sum % 10);
            c = sum / 10;
        }
        if(c > 0) {
            list.add(1);
        }
        // 4 2 1
        int m = list.size();
        int[] ans = new int[m];
        for(int i = 0; i < m; i++) {
            ans[i] = list.get(m - i - 1);
        }
        return ans;
    }
}
