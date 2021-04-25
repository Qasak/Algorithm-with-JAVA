package leetcode.SpringRecruit.Tree;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/14 9:28
 */
public class Q208_实现Trie {
    // 这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
    // 递归版
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
            char c = word.charAt(0);
            if(children[c - 'a'] == null) {
                children[c - 'a'] = new Trie();
            }
            root = children[c - 'a'];
            String w = word.substring(1);
            if(w.length() == 0) {
                root.isEnd = true;
            } else {
                root.insert(w);
            }

        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie root = this;
            char c = word.charAt(0);
            if(children[c - 'a'] == null) {
                return false;
            }
            root = children[c - 'a'];
            String w = word.substring(1);
            if(w.length() == 0) {
                return root.isEnd;
            } else {
                return root.search(w);
            }
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Trie root = this;
            char c = prefix.charAt(0);
            if(children[c - 'a'] == null) {
                return false;
            }
            root = children[c - 'a'];
            String w = prefix.substring(1);
            if(w.length() == 0) {
                return true;
            } else {
                return root.startsWith(w);
            }
        }
    }

}
// for-each版
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
