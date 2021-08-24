package leetcode.template.Probability;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/30 22:05
 */
public class 连续整数 {
    public static void main(String[] args) {
        int cnt = 0;
        Random rand = new Random();
        for(int i = 0; i < 100000; i++) {
            List<Integer> nums = new ArrayList<>();
            for(int j = 0; j < 10; j++) {
                nums.add(j + 1);
            }
            int[] t = new int[3];
            for (int j = 0; j < 3; j++) {
                int idx = rand.nextInt(nums.size());
                t[j] = nums.get(idx);
                nums.remove(idx);
            }
            Arrays.sort(t);
            for (int j = 1; j < 3; j++) {
                if (t[j] - t[j - 1] == 1) {
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
