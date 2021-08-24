package leetcode.template.BIT;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/6 15:58
 */
public class Q1649_CreateSortedArr {
    // BinSearch : 超时
    public int createSortedArray(int[] arr) {
        int ans = 0;
        int n = arr.length;
        int mod = 1000000007;
        List<Integer> list = new ArrayList<>(1000001);
        for(int i = 0; i < n; i++) {
            int idx = lowerBound(list, arr[i]);
            int idx2 = upperBound(list, arr[i]);
            ans += Math.min(idx, list.size() - idx2);
            if(ans >= mod) {
                ans -= mod;
            }
            // System.out.println(idx + " " + (list.size() - 1 - idx));
            list.add(idx, arr[i]);
        }
        return ans;
    }
    private int lowerBound(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while(l < r) {
            int m = (l + r) >>> 1;
            if(list.get(m) < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
    private int upperBound(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while(l < r) {
            int m = (l + r) >>> 1;
            if(list.get(m) <= target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }



    // BIT
    int maxn = 100010;
    int[] c = new int[100010];
    int[] a;
    private void update(int id) {
        while(id < maxn) {
            c[id] += 1;
            id += id & (-id);
        }
    }
    // query(id): 小于等于大小为id的元素个数
    // query(id - 1):小于大小为id的元素个数
    private int query(int id) {
        int ret = 0;
        while(id > 0) {
            ret += c[id];
            id -= id & (-id);
        }
        return ret;
    }
    public int createSortedArray1(int[] arr) {
        int ans = 0;
        int n = arr.length;
        int mod = 1000000007;
        a = arr;
        for(int i = 0; i < n; i++) {
            update(a[i]);
            ans += Math.min(query(a[i] - 1), query(100001) - query(a[i]));
            if(ans >= mod) {
                ans -= mod;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(10);
        System.out.println(list.size());
    }
}
