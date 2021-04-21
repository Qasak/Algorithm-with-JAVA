class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        for(auto &line:matrix) {
            auto it=lower_bound(line.begin(), line.end(), target);
            if(it!=line.end())
                if(*it==target)
                    return true;
        }
        return false;
    }
};