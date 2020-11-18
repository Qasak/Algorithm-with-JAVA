class Solution {
public:
    vector<vector<int>> ans;
    vector<int> tmp;
    
    vector<vector<int>> combinationSum3(int k, int n) {
        dfs(1,9,k,n);
        return ans;
    }

    void dfs(int cur, int n, int k, int sum) {
        if(tmp.size()+n-cur+1<k || tmp.size()>k)
            return;
        if(tmp.size()==k && accumulate(tmp.begin(), tmp.end(), 0)==sum) {
            ans.push_back(tmp);
            return;
        }
            
        tmp.push_back(cur);
        dfs(cur+1, n, k, sum);
        tmp.pop_back();
        dfs(cur+1, n, k, sum);
    }
    
};