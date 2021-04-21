class Solution {
public:
    vector<int> line_last;
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int n=matrix.size();
        if(!n) return false;
        int m=matrix[0].size();
        if(!m) return false;
        for(auto &line:matrix) {
            line_last.push_back(*(line.end()-1));
        }

        int line_number;
        auto it=lower_bound(line_last.begin(), line_last.end(), target);
        if(it==line_last.end())
            return false;
        line_number=it-line_last.begin();

        for(int i=line_number; i<n; i++) {
            auto it=lower_bound(matrix[i].begin(), matrix[i].begin()+m, target);
            if(it!=matrix[i].begin()+m)
                if(*it==target)
                    return true;
                else {
                    m=it-matrix[i].begin();
                }
        }
        return false;
    }
};