package leetcode.template.Trie;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/19 9:31
 */
public class Q208_实现Trie前缀树 {
    class Trie {
        private final int ALPHA_SIZE = 26;
        boolean isEndOfWord = false;
        Trie[] children = new Trie[ALPHA_SIZE];
        /** Initialize your data structure here. */
        public Trie() {

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
            root.isEndOfWord = true;
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
            return root.isEndOfWord;
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
}
