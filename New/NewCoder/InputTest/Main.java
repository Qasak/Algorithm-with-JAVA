package NewCoder.InputTest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/11 11:31
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String[] t = sc.nextLine().split(",");
            Arrays.sort(t);
            System.out.println(String.join(",", t));
        }
    }
}
