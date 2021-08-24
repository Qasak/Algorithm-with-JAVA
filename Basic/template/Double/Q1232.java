package leetcode.template.Double;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/17 12:34
 */

// 由斜率公式得
//(y1-y0)/(x1-x0)=(yi-y0)/(xi-x0)
//防止除0，变换成相乘的形式
//(y1-y0)*(xi-x0)==(x1-x0)*(yi-y0)
public class Q1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        if(n == 2) {
            return true;
        }
        Double k = (double)(coordinates[1][1] - coordinates[0][1]) / (double) (coordinates[1][0] - coordinates[0][0]);
        for(int i = 1; i < n - 1; i++) {
            Double k1 = (double)(coordinates[i + 1][1] - coordinates[i][1]) / (double) (coordinates[i + 1][0] - coordinates[i][0]);
            if((k1.isInfinite() && k.isInfinite()) || (k1 * k == -0.0)) {
                continue;
            }
            if(!k.equals(k1)) {
                return false;
            }
        }
        return true;
    }
    public boolean checkStraightLine1(int[][] c) {
        // (y1 - y0) / (x1 - x0) == (yi - y0) / (xi - x0)
        // (y1 - y0) * (xi - x0) == (x1 - x0) * (yi - y0)
        int n = c.length;
        int x0 = c[0][0];
        int y0 = c[0][1];
        int x1 = c[1][0];
        int y1 = c[1][1];
        for(int i = 2; i < n; i++) {
            int xi = c[i][0];
            int yi = c[i][1];
            if((y1 - y0) * (xi - x0) != (x1 - x0) * (yi - y0)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Double k = -0.0;
        Double k1 = 0.0;
        System.out.println(k1.equals(-k));
    }
}
