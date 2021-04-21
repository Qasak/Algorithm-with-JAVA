package leetcode.template.Sort;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/13 16:01
 */
public class Q1122_RelativeSort {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        if(n == 0) {
            return new int[]{};
        }
        int m = arr2.length;
        if(m == 0) {
            return arr1;
        }
        int[] ans = new int[n];
        Arrays.fill(ans, -1);


        // 保存arr1中元素的个数
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }
        // 从小到大扫arr2, 对应个数的元素放入ans
        int idx = 0;
        for(int i = 0; i < m; i++) {
            int k = map.get(arr2[i]);
            for(int j = 0; j < k; j++) {
                ans[idx++] = arr2[i];
            }
            map.put(arr2[i], 0);
        }

        // 剩下元素是arr2没有的
        ArrayList<Integer> tmp = new ArrayList<>();
        for(int i: map.keySet()) {

            if(map.get(i) != 0) {
                int k = map.get(i);
                for(int j = 0; j < k; j++) {
                    tmp.add(i);
                }
            }
        }
        Collections.sort(tmp);
        for(int i: tmp) {
            ans[idx++] = i;
        }
        return ans;
    }

    // stream
    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        int n = arr1.length;
        if(n == 0) {
            return new int[]{};
        }
        int m = arr2.length;
        if(m == 0) {
            return arr1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < m; i++) {
            map.put(arr2[i], i);
        }
        // 流/ 封装/
        Integer[] A = Arrays.stream(arr1).boxed().toArray(Integer[]::new);
        Arrays.sort(A, (a, b) -> {
            if(map.containsKey(a) && map.containsKey(b)) {
                return map.get(a) - map.get(b);
            } else if(map.containsKey(a)) {
                return -1;
            } else if(map.containsKey(b)) {
                return 1;
            } else {
                return a - b;
            }
        });
        // 流/ 解封装
        return Arrays.stream(A).mapToInt((x) -> x).toArray();
    }
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        String[] filtered = strings.stream().filter(string -> !string.isEmpty()).toArray(String[]::new);
        System.out.println(Arrays.toString(filtered));
    }
}
