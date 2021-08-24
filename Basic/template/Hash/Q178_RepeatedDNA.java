package leetcode.template.Hash;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/18 18:44
 */
public class Q178_RepeatedDNA {
    // 线性窗口
    // O((N−L)L)
    // O(N * M)
    public List<String> findRepeatedDnaSequences(String s) {
        // AAAAAAAAAA
        // AAAAAAAAAAAAA
        // ACACACACAC ACACACACACAC
        Set<String> set = new HashSet<>();
        int n = s.length();
        // [0, 9]
        Set<String> ans = new HashSet<>();
        for(int i = 0; i <= n - 10; i++) {
            String t = s.substring(i, i + 10);
            if(!set.add(t)) {
                ans.add(t);
            }
        }
        return new ArrayList<>(ans);
    }

    // 字符串哈希
    // Rabin-Karp算法
    // 从序列初始位置遍历序列：从 1 到 N-1。
    //如果 start==0，计算第一个序列 s[0:L] 的哈希值。
    //否则，从上一个哈希值计算旋转哈希。
    //如果哈希值在 hashset 中，则找到了重复的序列，则更新输出。
    //否则，添加到将哈希值添加到 hashset 中。
    public List<String> findRepeatedDnaSequences1(String s) {
        int L = 10;
        int base = 4;
        int hi = (int) Math.pow(base, 10);

        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0); map.put('C', 1); map.put('G', 2); map.put('T', 3);
        Set<Integer> set = new HashSet<>();
        Set<String> ans = new HashSet<>();
        int n = s.length();
        if(n <= 10) {
            return new ArrayList<>();
        }
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = map.get(s.charAt(i));
        }
        int h = 0;
        for(int i = 0; i < L; i++) {
            h = h * base + nums[i];
        }
        set.add(h);
        // [0, 9]
        // [1, 10]
        for(int i = 1; i <= n - L; i++) {
            h = h * base - nums[i - 1] * hi + nums[i + L - 1];
            if(!set.add(h)) {
                ans.add(s.substring(i, i + L));
            }
        }
        return new ArrayList<>(ans);
    }
}
