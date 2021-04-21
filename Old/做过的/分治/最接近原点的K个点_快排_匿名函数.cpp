class Solution {
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int K) {
        sort(points.begin(), points.end(), [] (auto& x, auto& y) { return x[0] * x[0] + x[1] * x[1] < y[0] * y[0] + y[1] * y[1]; });
        points.resize(K);
        return points;
    }
};
