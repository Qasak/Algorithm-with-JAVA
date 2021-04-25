package leetcode.SpringRecruit.Search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/25 17:48
 */
public class Q1539_第K个缺失的正整数 {
    // 1.暴力
    public int findKthPositive(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1, j = 0; i <= 2000; i++) {
            if(j < arr.length && i == arr[j]) {
                j++;
            } else {
                list.add(i);
            }
        }
        return list.get(k - 1);
    }
    // 2.不开list枚举
    public int findKthPositive1(int[] arr, int k) {
        int i = 1, j = 0;
        while(k > 0) {
            if(j < arr.length && i == arr[j]) {
                j++;
            } else {
                k--;
            }
            i++;
        }
        return i - 1;
    }
    // 3. 二分
    // 1 <= arr[i] <= 1000
    // 没有缺失的情况下 值 - 下标 = 1
    // 二分的 target: 找到缺失位置的下标

    // [2,3,4,7,11]
    // 2 - 0 - 1 == 1 前面缺失了一个
    // 11 - 4 - 1 == 6 前面缺失的6个

    int findKthPositive2(int[] arr, int k) {
        if (arr[0] - 1 >= k) {
            return k;
        }
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) >> 1;
            if(arr[m] - m - 1 < k) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        // arr[l] : 缺失数量 >= k 的第一个元素
        // System.out.println(l);
        return k - (arr[l - 1] - (l - 1) - 1) + arr[l - 1];
    }
}
