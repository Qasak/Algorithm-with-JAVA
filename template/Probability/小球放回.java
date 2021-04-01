package leetcode.template.Probability;

import java.util.Random;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/29 12:03
 */
public class 小球放回 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        int ans = 0;
        Random rand = new Random();
        for(int i = 0; i < 81000; i++) {
            int a = nums[rand.nextInt(9)];
            int b = nums[rand.nextInt(9)];
            if(a - 2 * b + 10 > 0) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
