package leetcode.template.Trie;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/19 9:59
 */
public class Q720_词典中的最长单词 {
    // 字典树
    class Solution {
        int maxDepth = 0;
        String ans = "";
        class Trie {
            public Trie() {}
            boolean end = false;
            String word;
            Trie[] children = new Trie[26];
            public void insert(String word) {
                Trie root = this;
                for(char c : word.toCharArray()) {
                    if(root.children[c - 'a'] == null) {
                        root.children[c - 'a'] = new Trie();
                    }
                    root = root.children[c - 'a'];
                }
                root.word = word;
                root.end = true;
            }
        }
        public void dfs(Trie root, int depth) {
            if(depth > 0 && !root.end) {
                return;
            }
            if(depth > maxDepth) {
                ans = root.word;
                maxDepth = depth;
            }
            for(Trie node : root.children) {
                if(node != null) {
                    dfs(node, depth + 1);
                }
            }
        }
        public String longestWord(String[] words) {
            Trie root = new Trie();
            for(String word : words) {
                root.insert(word);
            }
            dfs(root, 0);
            return ans;

        }
    }
    // HashSet
    public String longestWord1(String[] words) {
        Arrays.sort(words);
        int len = 0;
        String ans = "";
        Set<String> set = new HashSet<>();
        set.add(ans);
        for(String word : words) {
            if(set.contains(word.substring(0, word.length() - 1))) {
                set.add(word);
                if(word.length() > ans.length()) {
                    ans = word;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String[] words = new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple", "b"};
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        System.out.println(Arrays.toString(words));
    }
}
