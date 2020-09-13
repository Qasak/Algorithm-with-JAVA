class Solution {
private:
	int dx[4]={-1,0,1,0};
    int dy[4]={0,1,0,-1};
	bool used[201][201];
	int n;
	int m;
    bool dfs(int x, int y, int k, vector<vector<char>>& board, string& word) {
		if(used[x][y]) return false;
		if(k==word.size()-1 && word[k]==board[x][y]) return true; 
		if(board[x][y]==word[k]) {
			used[x][y]=true;
			for(int i=0;i<4;i++) {
				int xx=x+dx[i], yy=y+dy[i];
				if(xx>=0 && xx<n && yy>=0 && yy <m)
					if(dfs(xx, yy, k+1, board, word)) return true;
			}

		}
		used[x][y]=false;
		return false;
	}
public:
    bool exist(vector<vector<char>>& board, string word) {
        n=board.size();
		if(!n) return false;
		m=board[0].size();
		if(!m) return false;
        for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(board[i][j]==word[0] && dfs(i, j, 0, board, word)) return true;
			}
		}
        return false;
    }
};