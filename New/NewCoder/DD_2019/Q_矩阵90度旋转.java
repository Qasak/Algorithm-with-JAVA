package NewCoder.DD_2019;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/2 9:52
 */

class Solution {
    public static int[][] rotateP(int[][] matrix) {
        int n = matrix.length;
        int[][] tmp = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                tmp[j][n - i - 1] = matrix[i][j];
            }
        }
        return tmp;
    }
    public static int[][] rotateN(int[][] matrix) {
        int n = matrix.length;
        int[][] tmp = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                tmp[n - j - 1][i] = matrix[i][j];
            }
        }
        return tmp;
    }
    public static int[][] exchangeRowCol(int[][] matrix) {
        int n = matrix.length;
        int[][] tmp = new int[n][n];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[n - i - 1][j] = matrix[i][j];
            }
        }
        return tmp;
    }
    public static int[][] matrixAdd(int[][] matrix, int x) {
        int n = matrix.length;
        int[][] tmp = new int[n][n];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[i][j] = matrix[i][j] + x;
            }
        }
        return tmp;
    }
    public static int[][] generate(int[][] matrix) {
        int n = matrix.length;
        int nn = n * 2;
        int[][] tmp = new int[nn][nn];

        int[][] tmp1 = exchangeRowCol(rotateP(matrix));
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                tmp[i + nn / 2][j] = tmp1[i][j];
            }
        }
        int[][] tmp2 = matrixAdd(matrix, n * n);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                tmp[i][j] = tmp2[i][j];
            }
        }

        int[][] tmp3 = matrixAdd(matrix, n * n * 2);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                tmp[i][j + nn / 2] = tmp3[i][j];
            }
        }

        int[][] tmp4 = exchangeRowCol(matrixAdd(rotateN(matrix), n * n * 3));
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                tmp[i + nn / 2][j + nn / 2] = tmp4[i][j];
            }
        }
        return tmp;
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][]
                {{2, 3},
                        {1, 4}};
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        if(k == 0) {
            return;
        }
        if(k == 1) {
            System.out.print(1);
            return;
        }
        int n = (int) (Math.log(k) / Math.log(2));

        for(int i = 0; i < n - 1; i++) {
            matrix = generate(matrix);
        }
        for(int[] t : matrix) {
            for(int i = 0; i < t.length; i++) {
                System.out.print(t[i]);
                if(i != t.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}