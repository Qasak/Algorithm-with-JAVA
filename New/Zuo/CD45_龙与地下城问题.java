package NewCoder.Zuo;
import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/5/9 11:30
 */
public class CD45_龙与地下城问题 {
}
class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int[][] f = new int[n][m];
        // f[i][j] 从ij位置出发能到达右下角的最小初始hp
        f[n - 1][m - 1] = 1 + matrix[n - 1][m - 1] >= 1 ? 1 : 1 - matrix[n - 1][m - 1];
        for(int i = n - 2; i >= 0; i--) {
            f[i][m - 1] = Math.max(1, f[i + 1][m - 1] - matrix[i][m - 1]);
        }
        for(int j = m - 2; j >= 0; j--) {
            f[n - 1][j] = Math.max(1, f[n - 1][j + 1] - matrix[n - 1][j]);
        }
        for(int i = n - 2; i >= 0; i--) {
            for(int j = m - 2; j >= 0; j--) {
                f[i][j] = Math.min(Math.max(1, f[i + 1][j] - matrix[i][j]),
                        Math.max(1, f[i][j + 1] - matrix[i][j]));
            }
        }
        System.out.print(f[0][0]);
    }
}