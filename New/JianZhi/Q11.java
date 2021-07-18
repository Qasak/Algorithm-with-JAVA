package leetcode.JianZhi;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/12 21:09
 */
public class Q11 {
    public int minArray(int[] numbers) {
        if(numbers == null || numbers.length == 0) {
            return -1;
        }
        int n = numbers.length;
        int max = numbers[0];

        if(n == 1) {
            return max;
        }
        for(int i = 1; i < n ;i++) {
            if(numbers[i] >= max) {
                max = numbers[i];
            } else {
                return numbers[i];
            }
        }
        return numbers[0];
    }
}
