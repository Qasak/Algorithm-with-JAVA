package leetcode.SpringRecruit.String;

import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/14 10:04
 */
public class Q648_单词替换 {
    class Trie {
        private final int SIZE = 26;
        private Trie[] children;

        boolean isEnd = false;
        /** Initialize your data structure here. */
        public Trie() {
            children = new Trie[SIZE];
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Trie root = this;
            for(char c : word.toCharArray()) {
                if(root.children[c - 'a'] == null) {
                    root.children[c - 'a'] = new Trie();
                }
                root = root.children[c - 'a'];
            }
            root.isEnd = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie root = this;
            for(char c : word.toCharArray()) {
                if(root.children[c - 'a'] == null) {
                    return false;
                }
                root = root.children[c - 'a'];
            }
            return root.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Trie root = this;
            for(char c : prefix.toCharArray()) {
                if(root.children[c - 'a'] == null) {
                    return false;
                }
                root = root.children[c - 'a'];
            }
            return true;
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie root = new Trie();
        for(String s: dictionary) {
            root.insert(s);
        }
        String[] t = sentence.split(" ");
        String[] ans = new String[t.length];
        for(int i = 0; i < t.length; i++) {
            int idx = getIdx(root, t[i]);
            if(idx != -1) {
                ans[i] = t[i].substring(0, idx);
            } else {
                ans[i] = t[i];
            }
        }
        return String.join(" ", ans);
    }
    public int getIdx(Trie root, String t) {
        Trie cur = root;
        int j = 0;
        boolean found = false;
        for(; j < t.length(); j++) {
            char c = t.charAt(j);
            if(cur.children[c - 'a'] == null || cur.isEnd) {
                if(cur.isEnd) {
                    found = true;
                }
                break;
            }
            cur = cur.children[c - 'a'];
        }
        if(found) {
            // System.out.println(t + " " + j);
            return j;
        }
        return -1;
    }
}
