class Solution {
public:
    vector<string> ans;
    void dfs(string tmp, int left,  int right, int n) {
        if(left+right==2*n) {
            ans.push_back(tmp);
            return;
        }
        if(left<n) {
            tmp.push_back('(');
            dfs(tmp, left+1, right, n);
            tmp.pop_back();
        }
        if(right<left) {
            tmp.push_back(')');
            dfs(tmp, left, right+1, n);
            tmp.pop_back();
        }
    }
    vector<string> generateParenthesis(int n) {
        
        dfs("", 0, 0, n);
        return ans;
    }
};