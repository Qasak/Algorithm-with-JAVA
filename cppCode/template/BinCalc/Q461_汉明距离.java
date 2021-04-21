package leetcode.template.BinCalc;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/22 13:43
 */
public class Q461_汉明距离 {
    public int hammingDistance(int x, int y) {
        int ans = 0;
        int z = x ^ y;
        while(z != 0) {
            z -= z & -z;
            ans++;
        }
        return ans;
    }
    public int hammingDistance1(int x, int y) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            if((((x >>> i) ^ (y >>> i)) & 1) == 1) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(3 < Math.sqrt(32));
    }
}
