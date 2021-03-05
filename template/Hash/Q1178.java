package leetcode.template.Hash;

import sun.plugin.javascript.navig.Array;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/26 12:17
 */
public class Q1178 {
    // 枚举子集
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> freq = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(String word : words) {
            int mask = 0;
            for(char c : word.toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            if(Integer.bitCount(mask) <= 7) {
                freq.put(mask, freq.getOrDefault(mask, 0) + 1);
            }
        }
        System.out.println(freq);
        for(String p : puzzles) {
            int cnt = 0;
            int head = 1 << (p.charAt(0) - 'a');
            for(int sub = 0; sub < (1 << 6); sub++) {

                int mask = 0;
                for(int i = 0; i < 6; i++) {
                    if(((sub >> i) & 1) == 1) {
                        mask |= 1 << (p.charAt(i + 1) - 'a');
                    }
                }
                cnt += freq.getOrDefault(mask | head, 0);
            }
            ans.add(cnt);
        }
        return ans;
    }
    // 字典树
    public static void main(String[] args) {
        String[] a = new String[]{"cc", "d", "aaaa", "aa", "aaaab", "c"};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
