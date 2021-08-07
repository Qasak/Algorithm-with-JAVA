package leetcode.contest.DoubleWeek58;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/8 1:01
 */
public class Q2检查操作是否合法 {
    // 屎山
    class Solution {

        public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
            int n = 8;
            char cur;
            if(color == 'W') {
                cur = 'B';
            } else {
                cur = 'W';
            }

            // 上
            int i = rMove - 1;
            int j = cMove;
            while(i >= 0 && board[i][j] == cur) {
                i--;
            }
            if(i >= 0 && i < rMove - 1 && board[i][j] == color) {
                return true;
            }

            // 下
            i = rMove + 1;
            j = cMove;
            while(i < n && board[i][j] == cur) {
                i++;
            }
            if(i < n && i > rMove + 1 && board[i][j] == color) {
                return true;
            }

            // 左
            i = rMove;
            j = cMove - 1;
            while(j >= 0 && board[i][j] == cur) {
                j--;
            }
            if(j >= 0 && j < cMove - 1 && board[i][j] == color) {
                return true;
            }

            // 右
            i = rMove;
            j = cMove + 1;
            while(j < n && board[i][j] == cur) {
                j++;
            }
            if(j < n && j > cMove + 1 && board[i][j] == color) {
                return true;
            }
            // 左上
            i = rMove - 1;
            j = cMove - 1;
            while(i >= 0 && j >= 0 && board[i][j] == cur) {
                i--; j--;
            }
            if(i >= 0 && j >= 0 && i < rMove - 1 &&  j < cMove - 1 && board[i][j] == color) {
                return true;
            }

            // 右下
            i = rMove + 1;
            j = cMove + 1;
            while(i < n && j < n && board[i][j] == cur) {
                i++; j++;
            }
            if(i < n && j < n && i > rMove + 1 && j > cMove + 1 && board[i][j] == color) {
                return true;
            }

            // 左下
            i = rMove + 1;
            j = cMove - 1;
            while(i < n && j >= 0 && board[i][j] == cur) {
                i++; j--;
            }
            if(i < n && j >= 0 && i > rMove + 1 && j < cMove - 1 && board[i][j] == color) {
                return true;
            }

            // 右上
            i = rMove - 1;
            j = cMove + 1;
            while(i >= 0 && j < n && board[i][j] == cur) {
                i--; j++;
            }
            if(i >= 0 && j < n && i < rMove - 1 && j > cMove + 1 && board[i][j] == color) {
                return true;
            }
            return false;
        }

    }

    // DFS



}
