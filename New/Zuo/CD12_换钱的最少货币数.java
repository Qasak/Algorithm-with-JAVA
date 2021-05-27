package NewCoder.Zuo;
import java.util.*;


/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/5/13 17:40
 */
public class CD12_换钱的最少货币数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int aim = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int MAX = 0x3f3f3f3f;
        // f[i] : 组成i的最小货币数
        int[] f = new int[aim + 1];
        Arrays.fill(f, MAX);
        f[0] = 0;
        for(int i = 1; i <= aim; i++) {
            for(int coin : arr) {
                f[i] = Math.min(f[i], (i - coin >= 0 ? f[i - coin] + 1 : MAX));
            }
        }
        System.out.println(f[aim]);
    }
}
