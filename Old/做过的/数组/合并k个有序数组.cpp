typedef tuple<int, int, int> tiii;

struct cmp {
    bool operator() (const tiii& a, const tiii& b) {
        return get<2>(a) > get<2>(b);
    }  
};
class Solution {
public:
    /**
     * @param arrays: k sorted integer arrays
     * @return: a sorted array
     */
    vector<int> mergekSortedArrays(vector<vector<int>> &arrays) {
        int n=arrays.size();
        priority_queue<tiii, vector<tiii>, cmp> pq;
        vector<int> ans;
        for(int i=0;i<n;i++) {
            if(!arrays[i].empty())
                pq.push(make_tuple(i, 0, arrays[i][0]));
        }
        while(!pq.empty()) {
            auto elem=pq.top();
            pq.pop();
            ans.push_back(get<2>(elem));
            if(get<1>(elem)<arrays[get<0>(elem)].size()-1) {
                int i=get<0>(elem);
                int j=get<1>(elem)+1;
                pq.push(make_tuple(i, j, arrays[i][j]));
            }
        }
        return ans;
    }
};