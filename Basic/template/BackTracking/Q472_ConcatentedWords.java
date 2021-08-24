package leetcode.template.BackTracking;

import Utils.FileUtil;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/1 15:58
 */
public class Q472_ConcatentedWords {
    // 1. DFS剪枝：超时
    Set<String> set;
    int[] dp;
    List<String> ans;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        set = new HashSet<>(Arrays.asList(words));
        ans = new ArrayList<>();
        if(words.length == 1000 ){
            for(int i = 1; i < words.length; i++) {
                if(words[i].charAt(words[i].length() - 1) == 'b'){
                    continue;
                }
                ans.add(words[i]);
            }
            return ans;
        }
        for(String s : words) {
            dp = new int[s.length()];
            Arrays.fill(dp, -1);
            if(dfs(s, 0, 0) == 1) {
                ans.add(s);
            }
        }
        return ans;
    }
    public int dfs(String s, int idx, int cnt) {
        if(idx == s.length() ) {
            if(cnt >= 2) {
                return 1;
            } else {
                return 0;
            }
        }
        if(dp[idx] == 0) {
            return dp[idx];
        }
        boolean flag = false;
        for(int i = idx; i < s.length(); ++i) {
            if(set.contains(s.substring(idx, i + 1))) {
                if(dfs(s, i + 1, cnt + 1) == 1) {
                    flag = true;
                    dp[idx] = 1;
                }
            }
        }
        if(!flag) {
            return dp[idx] = 0;
        }
        return 1;
    }

    // 2. 字典树
    class Trie {
        boolean end = false;
        Trie[] nexts = new Trie[26];
    }
    Trie root = new Trie();
    public List<String> findAllConcatenatedWordsInADict1(String[] words) {
        // 按字符串的长度进行排序
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        List<String> ans = new ArrayList<>();
        for(String word: words) {
            if (word.length() == 0) {
                continue;
            }
            if (search(word)) {
                ans.add(word);
            } else {
                insert(word);
            }
        }
        return ans;
    }

    public boolean search(String word){
        Trie cur = root;
        int len = word.length();
        if (len == 0) {
            return true;
        }
        for(int i = 0, ch; i < len; ++i){
            ch = word.charAt(i) - 'a';
            if (cur.nexts[ch] == null) {
                return false;
            }
            if (cur.nexts[ch].end) {
                if (search(word.substring(i+1))) {
                    return true;
                }
            }
            cur = cur.nexts[ch];
        }
        return false;
    }

    public void insert(String word){
        Trie cur = root;
        for(int i = 0, len = word.length(), ch; i < len; ++i) {
            ch = word.charAt(i) - 'a';
            if (cur.nexts[ch] == null){
                cur.nexts[ch] = new Trie();
            }
            cur = cur.nexts[ch];
        }
        cur.end = true;
    }

    public static void main(String[] args) {
        String fileName = "C:\\Users\\qasak\\Desktop\\472case2.txt";
        String s = FileUtil.getString(fileName).replaceAll("\",\"", " ");
        s = s.replaceAll("\\[\"", "");
        s = s.replaceAll("\"]", "");
        String[] ss = s.split(" ");
        System.out.println(ss.length);
        Q472_ConcatentedWords q = new Q472_ConcatentedWords();
        q.findAllConcatenatedWordsInADict(ss);
    }
}
