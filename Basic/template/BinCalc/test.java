package leetcode.template.BinCalc;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/30 23:13
 */
public class test {
    public static void main(String[] args) {
        int a = -127;
        int b = a & 0xff;
        int[] bin = new int[32];
        for(int i = 0; i < 32; i++) {
            bin[31 - i] = (a >> i) & 1;
        }
        System.out.println(Arrays.toString(bin));
        System.out.println(b);
    }
}
