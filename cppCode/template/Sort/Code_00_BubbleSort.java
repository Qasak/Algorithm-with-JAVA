package leetcode.template.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/22 18:51
 */
public class Code_00_BubbleSort {
    static int[] idx;
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // [0, end)
        // 外层循环控制有边界
        // 每趟把最大的放在最后
        for (int end = arr.length - 1; end > 0; end--) {
            boolean flag = false;
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    flag = true;
                    swap(arr, i, i + 1);
                }
            }
            if(!flag) {
                break;
            }
        }
    }
    public static void binSort(int[] arr) {
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int idx = lowerBound(list, arr[i]);
            list.add(idx, arr[i]);
        }
        for(int i = 0; i < n; i++) {
            arr[i] = list.get(i);
        }
    }
    public static int lowerBound(List<Integer> a, int target) {
        int l = 0, r = a.size();
        while(l < r) {
            int m = (l + r) >>> 1;
            if(a.get(m) < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
    public static void advanceInsertSortWithBinarySearch(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int low = 0, high = i - 1;
            int mid = -1;
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (arr[mid] > temp) {
                    high = mid - 1;
                } else { // 元素相同时，也插入在后面的位置
                    low = mid + 1;
                }
            }
            for(int j = i - 1; j >= low; j--) {
                arr[j + 1] = arr[j];
            }
            arr[low] = temp;
        }
    }
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 1;
        int maxSize = 1000000;
        int maxValue = 0x3f3f3f3f;
        boolean succeed = true;
//        idx = new int[]
        long startTime=System.currentTimeMillis();
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);

//            bubbleSort(arr1);
//            binSort(arr1);
            advanceInsertSortWithBinarySearch(arr1);
//            Code_04_QuickSort.quickSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        long endTime=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

//        int[] arr = generateRandomArray(maxSize, maxValue);
//        idx = new int[arr.length];
//        printArray(arr);
//        bubbleSort(arr);
//        binSort(arr);
//        printArray(arr);
    }
}
