package leetcode.template.Brutal;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/11 16:47
 */
public class Q1307_口算难题 {
    Map<Character, Integer> map;
    Set<Character> head;
    Set<Character> charSet;
    List<Character> list;
    boolean[] used;
    // 纯暴力：TLE
    public boolean isSolvable(String[] words, String result) {
        // 10 ^ 26
        //
        map = new HashMap<>();
        head = new HashSet<>();
        charSet = new HashSet<>();
        list = new ArrayList<>();
        used = new boolean[10];
        for(String s : words) {
            for(int i = 0; i < s.length(); i++) {
                if(i == 0) {
                    head.add(s.charAt(i));
                }
                charSet.add(s.charAt(i));
            }
        }
        for(int i = 0; i < result.length(); i++) {
            if(i == 0) {
                head.add(result.charAt(i));
            }
            charSet.add(result.charAt(i));
        }
        list = new ArrayList<>(charSet);
        return dfs(0, words, result);
    }
    public boolean dfs(int idx, String[] words, String result) {
        int n = list.size();
        if(idx == n) {
            int a = 0;
            int b = word2Int(result);
            for(String s : words) {
                a += word2Int(s);
            }
            return a == b;
        }
        char ch = list.get(idx);

        if(head.contains(ch)) {
            for(int i = 1; i <= 9; i++) {
                if(used[i]) {
                    continue;
                }
                used[i] = true;
                map.put(ch, i);
                if(dfs(idx + 1, words, result)) {
                    return true;
                }
                map.remove(ch);
                used[i] = false;

            }
        } else {
            for(int i = 0; i <= 9; i++) {
                if(used[i]) {
                    continue;
                }
                map.put(ch, i);
                used[i] = true;

                if(dfs(idx + 1, words, result)) {
                    return true;
                }
                map.remove(ch);
                used[i] = false;

            }
        }
        return false;
    }
    public int word2Int(String word) {
        int num = 0;
        for(int i = 0; i < word.length(); i++) {
            num = num * 10 + map.get(word.charAt(i));
        }
        return num;
    }


    // 玄学剪枝
    Map<Character, Integer> w;
    public int pow(int n) {
        int ans = 1;
        for(int i = 0; i < n; i++) {
            ans *= 10;
        }
        return ans;
    }
    public boolean isSolvable1(String[] words, String result) {
        // 10 ^ 26
        map = new HashMap<>();
        w = new HashMap<>();

        head = new HashSet<>();
        charSet = new HashSet<>();
        list = new ArrayList<>();
        used = new boolean[10];


        int maxl = 0, maxr = result.length();

        for(String s : words) {
            int n = s.length();
            maxl = Math.max(maxl, n);
            for(int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if(i == 0 && s.length() > 1) {
                    head.add(ch);
                }
                charSet.add(ch);
                w.put(ch, w.getOrDefault(ch, 0) + pow(n - i - 1));
            }
        }
        if(maxl > maxr || maxr - maxl >= 2) {
            return false;
        }
        for(int i = 0; i < result.length(); i++) {
            char ch = result.charAt(i);
            if(i == 0 && result.length() > 1) {
                head.add(ch);
            }
            charSet.add(ch);
            w.put(ch, w.getOrDefault(ch, 0) + pow(result.length() - i - 1));
        }
        list = new ArrayList<>(charSet);
        Collections.sort(list, (a, b) -> (w.get(b) - w.get(a)));
        // System.out.println(list);
        return dfs(0, words, result);
    }
    public boolean dfs1(int idx, String[] words, String result) {
        int n = list.size();
        if(idx == n) {
            int a = 0;
            int b = word2Int(result);
            for(String s : words) {
                a += word2Int(s);
            }
            // if(a == b) {
            //     for(String s : words) {
            //         System.out.println(word2Int(s));
            //     }
            //     System.out.println(b);
            // }
            return a == b;
        }
        boolean flag = true;
        for(char c : head) {
            if(!map.containsKey(c)) {
                flag = false;
            }
        }
        if(flag) {
            int a = 0;
            for(String s : words) {
                char ch = s.charAt(0);
                if(!map.containsKey(ch)) {
                    continue;
                }
                a += map.get(ch) * pow(s.length() - 1);
            }

            int b = map.getOrDefault(result.charAt(0), 0) * pow(result.length() - 1);
            if(Math.abs(a - b) > pow(result.length() - 1)) {
                return false;
            }
        }

        char ch = list.get(idx);

        if(head.contains(ch)) {
            for(int i = 1; i <= 9; i++) {
                if(used[i]) {
                    continue;
                }
                used[i] = true;
                map.put(ch, i);
                if(dfs(idx + 1, words, result)) {
                    return true;
                }
                map.remove(ch);
                used[i] = false;

            }
        } else {
            for(int i = 0; i <= 9; i++) {
                if(used[i]) {
                    continue;
                }
                map.put(ch, i);
                used[i] = true;

                if(dfs1(idx + 1, words, result)) {
                    return true;
                }
                map.remove(ch);
                used[i] = false;

            }
        }
        return false;
    }

    public static void main(String[] args) {
        Set<Character> charSet = new HashSet<>();
        List<Character> list = new ArrayList<>(charSet);
    }
}
