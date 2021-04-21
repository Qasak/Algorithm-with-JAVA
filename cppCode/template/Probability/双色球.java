package leetcode.template.Probability;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/30 22:42
 */
public class 双色球 {
    public static void main(String[] args) {
        int cnt = 0;
        Random rand = new Random();
        int[] bonus = new int[7];
        for(int i = 0; i < 17721089; i++) {
            List<Integer> nums = new ArrayList<>();
            for(int j = 0; j < 33; j++) {
                nums.add(j + 1);
            }
            int[] t = new int[7];
            for (int j = 0; j < 6; j++) {
                int idx = rand.nextInt(nums.size());
                t[j] = nums.get(idx);
                nums.remove(idx);
            }
            t[6] = rand.nextInt(16) + 1;
            Arrays.sort(t, 0, 6);
            if(i == 0) {
                bonus = t;
                continue;
            }
            boolean flag = true;
            for (int j = 0; j < 7; j++) {
                if (t[j] != bonus[j]) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                System.out.println(Arrays.toString(bonus));
                System.out.println(Arrays.toString(t));
                System.out.println(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
