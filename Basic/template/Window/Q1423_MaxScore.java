package leetcode.template.Window;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/6 0:12
 */
public class Q1423_MaxScore {
    public static int maxScore(int[] nums, int k) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        return sum;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3};
        System.out.println(maxScore(a, 1));
    }
}
