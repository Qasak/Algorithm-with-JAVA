class Solution {
public:
    vector<int> line_last;
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int n=matrix.size();
        if(!n) return false;
        int m=matrix[0].size();
        for(auto &line:matrix) {
            auto it=lower_bound(line.begin(), line.begin()+m, target);
            if(it!=line.begin()+m)
                if(*it==target)
                    return true;
                else {
                    m=it-line.begin();
                }
        }
        return false;
    }
};