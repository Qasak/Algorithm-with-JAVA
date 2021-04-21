package leetcode.template.Random;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/10 21:16
 */
public class Q470_rand7实现rand10_拒绝采样 {
    public int rand7() {
        return 1;
    }
    public int rand10() {
        int col, row, idx;
        do {
            col = rand7();
            row = rand7();
            idx = col + (row - 1) * 7;
        } while(idx > 40);
        // [1, 40]
        return (idx % 10) + 1;
    }
}
