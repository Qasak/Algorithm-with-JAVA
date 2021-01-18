package leetcode.template.Array;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/17 10:26
 */
public class Q1232_PointLine {
    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        if(n == 2) {
            return true;
        }
        Double k = (double)(coordinates[1][1] - coordinates[0][1]) / (double) (coordinates[1][0] - coordinates[0][0]);
        for(int i = 1; i < n - 1; i++) {
            Double k1 = (double)(coordinates[i + 1][1] - coordinates[i][1]) / (double) (coordinates[i + 1][0] - coordinates[i][0]);
            if(!k.equals(k1)) {
                return false;
            }
        }
        return true;
    }
}
