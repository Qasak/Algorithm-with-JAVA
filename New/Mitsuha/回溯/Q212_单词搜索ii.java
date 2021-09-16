package Mitsuha.回溯;

import java.util.ArrayList;
import java.util.List;

public class Q212_单词搜索ii {
    //给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。
//
//
//
// 示例 1：
//
//
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f",
//"l","v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
//
//
// 示例 2：
//
//
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
//
//
//
//
// 提示：
//
//
// m == board.length
// n == board[i].length
// 1 <= m, n <= 12
// board[i][j] 是一个小写英文字母
// 1 <= words.length <= 3 * 10⁴
// 1 <= words[i].length <= 10
// words[i] 由小写英文字母组成
// words 中的所有字符串互不相同
//
// Related Topics 字典树 数组 字符串 回溯 矩阵 \U0001f44d 455 \U0001f44e 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] vis;
        List<String> ans;
        int n;
        int m;
        int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        public List<String> findWords(char[][] board, String[] words) {
            n = board.length;
            m = board[0].length;
            vis = new boolean[n][m];
            ans = new ArrayList<>();
            for(String word : words) {
                char first = word.charAt(0);
                boolean wordFound = false;
                for(int i = 0; i < n ; i++) {
                    for (int j = 0; j < m; j++) {
                        if(board[i][j] == first) {
                            vis[i][j] = true;
                            if(dfs(i, j, word, 0, board) || (word.length() == 1 && first == board[i][j])) {
                                // System.out.println(i + " " + j);
                                ans.add(word);
                                wordFound = true;
                                vis[i][j] = false;
                                break;
                            }
                            vis[i][j] = false;
                        }
                    }

                    if(wordFound) {
                        break;
                    }
                }
            }
            return ans;
        }

        public boolean dfs(int i, int j, String word, int idx, char[][] board) {
            if(idx == word.length()) {
                return false;
            }
            if(board[i][j] != word.charAt(idx)) {
                return false;
            }
            if(idx == word.length() - 1) {
                // System.out.println(idx);
                return true;
            }
            boolean found = false;
            for(int[] d : dir) {
                int ii = i + d[0], jj = j + d[1];
                if(ii >= 0 && ii < n && jj >= 0 && jj < m && !vis[ii][jj]) {
                    vis[ii][jj] = true;
                    if(dfs(ii, jj, word, idx + 1, board)) {
                        found = true;
                    }
                    vis[ii][jj] = false;
                    if(found) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
