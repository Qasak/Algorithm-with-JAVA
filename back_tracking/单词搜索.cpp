
class Solution {
private:
	const vector<pair<int ,int>> a{{0,-1}, {-1, 0}, {0, 1}, {1, 0}};
	bool used[201][201]={false};
	int n;
	int m;
    bool dfs(int i, int j, int k, vector<vector<char>>& board, string& word) {
		if(used[i][j]) return false;
		if(k==word.size()-1 && board[i][j]==word[k]) return true; 
		if(board[i][j]==word[k]) {
			used[i][j]=true;
			for(auto &p:a) {
				int ii=i+p.first, jj=j+p.second;
				if(ii>=0 && ii<n && jj>=0 && jj <m)
					if(dfs(ii, jj, k+1, board, word)) return true;
			}

		}
		used[i][j]=false;
		return false;
	}
public:
    bool exist(vector<vector<char>>& board, string word) {
        int n=board.size();
		if(!n) return false;
		int m= board[0].size();
		if(!m) return false;
		this->n=n;
		this->m=m;
        for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(dfs(i, j, 0, board, word)) return true;
			}
		}
        return false;
    }
};
