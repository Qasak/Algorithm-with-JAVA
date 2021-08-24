package leetcode.template.Math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/25 11:12
 */
public class Q62O_Joseph {
     public int lastRemaining(int n, int m) {

         List<Integer> arr = new ArrayList<>();
         for(int i = 0; i < n; i++) {
             arr.add(i);
         }
         int i = 0;
         // 删除n - 1个元素
         for(int j = 0; j < n - 1; j++) {
             // // 0 1 2 3 4
             // // 3 4 0 1
             // // 1 3 4
             // // 1 3
             // // 3
             // 下一个开始的位置在本次已删除的元素的后一个
             // i: 当前要删除的位置+下次开始的位置
             // i : 2/3/0/2/0
             i = (i + m - 1) % arr.size();
             arr.remove(i);
         }
         return arr.get(0);
     }
     public int lastRemaining1(int n, int m) {

         return f(n, m);
     }
     //下一轮的起点就是当前删除的元素的下一个，i + m
     // 0 1 2 3 4
     // 3 4 0 1
     // 1 3 4 | 1 3 4
     // 1 3 | 1 3
     // 3
     // f(1, 3) = 0
     // f(2, 3) = 1
     // f(3, 3) = 1
     // f(4, 3) = 0
     // f(5, 3) = 3

     // f: 幸存者在该轮的下标
     private int f(int n, int m) {
         if (n == 1) {
             return 0;
         }
         // 删除：被删除的后面元素往前移
         // 倒推：幸存位置往后移
         int x = f(n - 1, m);
         return (x + m) % n;
     }

     public int lastRemaining2(int n, int m) {
         int ans = 0;
         // 最后一轮剩下2个人，所以从2开始反推
         for (int i = 2; i <= n; i++) {
             ans = (ans + m) % i;
         }
         return ans;
     }
}
