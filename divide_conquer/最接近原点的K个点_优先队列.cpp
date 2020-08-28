struct Gt{
    bool operator()(pair<vector<int>, int> &a, pair<vector<int>, int> &b) {
        return a.second > b.second;
    }
};

class Solution {
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int K) {
        vector<vector<int>> ans;
        priority_queue<pair<vector<int>, int>, vector<pair<vector<int>, int>>, Gt> pq;
        for(auto &p:points) {
            pq.push(pair{p, p[0]*p[0]+p[1]*p[1]});
        }
        while(K){
            K--;
            ans.push_back(pq.top().first);
            pq.pop();
        }
        return ans;
    }
};