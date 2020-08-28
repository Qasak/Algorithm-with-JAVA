/*
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]

从坐下角开始
这个元素处于最后一行的最小值，第一列的最大值位置
*/
// 若一行第一个元素比target大，这一行可以剪掉
// 若一列最后一个元素比target小，这一列可以剪掉

class Solution {
public:
    vector<int> line_last;
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if(matrix.empty()) return false;

        int row=matrix.size()-1;
        int col=0;

        while(row>=0 && col<matrix[0].size()) {
            if(matrix[row][col]>target)
                row--;
            else if(matrix[row][col]<target) {
                col++;
            } else 
                return true;
        }

        return false;
    }
};