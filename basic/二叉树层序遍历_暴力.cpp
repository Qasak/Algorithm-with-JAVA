/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        
        vector<vector<int> > ans;
        if(!root) return ans;
        TreeNode* p;
        p=root;
        vector<int> r;
        r.push_back(p->val);
        ans.push_back(r);
        queue<TreeNode*> q;
        q.push(p);
        vector<int> l;
        int cur_cnt=1;
        int nex_cnt=0;
        while(!q.empty()) {
            TreeNode* t=q.front();
            TreeNode* lt, * rt;
            lt=(t->left);
            rt=(t->right);
            q.pop();
            cur_cnt--;
            if(lt) {
                l.push_back(lt->val);
                q.push(lt);
                nex_cnt++;
            }
            if(rt) {
                l.push_back(rt->val);
                q.push(rt);
                nex_cnt++;
            }
            
            if(!cur_cnt) {
                if(!l.empty())
                    ans.push_back(l);
                l.clear();
                cur_cnt=nex_cnt;
                nex_cnt=0;
            }
                
        }
        return ans;
    }
};