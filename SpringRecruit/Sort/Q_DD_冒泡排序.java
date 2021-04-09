package leetcode.SpringRecruit.Sort;

import java.util.Scanner;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/30 18:35
 */
public class Q_DD_冒泡排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] nums = line.split(",");
        int n = nums.length;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(nums[i]);
        }
        bubbleSort(arr);
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if(i != n - 1) {
                System.out.print(" ");
            }
        }
    }
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n - 1; i++) {
            // System.out.println(Arrays.toString(arr));
            boolean flag = true;
            for(int j = 0; j < n - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    flag = false;
                    swap(arr, j, j + 1);
                }
            }
            if(flag) {
                return;
            }
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
