class Solution {
public:
    static constexpr int MAX_N = 1000 + 5;
    static constexpr int MOD = 100000000 + 7;

    vector<bool> flag=vector<bool>(MAX_N, true);
    vector<int> p=vector<int>(MAX_N);
    void get_prime() {
        flag[0] = flag[1] = false;
        for (int i = 2; i < sqrt(MAX_N); ++i) {
            if(flag[i]) {
				for (int j = i*i; j <= MAX_N; j+=i) {
					flag[j]=false;
				}
			}
        }
		for(int i=0,j=0; i<flag.size();++i) {
			if(flag[i]) {
                p[j]=i;
                j++;
            }
		}
    }

    struct Status {
        int hash_value, tree_size; 
        Status(int val = 0, int size = 0) 
            : hash_value(val), tree_size(size) {}
    };

    unordered_map <TreeNode *, Status> hash_s, hash_t;

    void dfs(TreeNode *root, unordered_map <TreeNode *, Status> &h) {
        h[root] = Status(root->val, 1);
        if (!root->left && !root->right) return;
        if (root->left) {
            dfs(root->left, h);
            h[root].tree_size += h[root->left].tree_size;
            h[root].hash_value = (h[root].hash_value + (59LL * h[root->left].hash_value * p[h[root->left].tree_size]) % MOD) % MOD;
        }
        if (root->right) {
            dfs(root->right, h);
            h[root].tree_size += h[root->right].tree_size;
            h[root].hash_value = (h[root].hash_value + (61LL * h[root->right].hash_value * p[h[root->right].tree_size]) % MOD) % MOD;
        }
    }

    bool isSubtree(TreeNode* s, TreeNode* t) {
        get_prime();
        dfs(s, hash_s);
        dfs(t, hash_t);

        int hash_value_t = hash_t[t].hash_value;
        for (const auto &[k, v]: hash_s) {
            if (v.hash_value == hash_value_t) {
                return true;
            }
        } 

        return false;
    }
};

