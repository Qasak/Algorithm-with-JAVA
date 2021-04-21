class Solution {
private:
    int n;
    int min_cnt=0x3f3f3f3f;
    // struct edge{int from, to, cost;};
    // edge es[n*n];
public:
    int dist(string a, string b) {
        int cnt=0;
        for(int i=0;i<a.size();i++) {
            if(a[i]!=b[i])
                cnt++;
        }
        return cnt;
    }


    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        int n=wordList.size();
        
        if(!n)
            return 0;
        this->n=n;
        vector<int> entry;
        int end_idx=-1;
        for(int i=0;i<wordList.size();i++) {
            if(dist(beginWord, wordList[i])<=1) {
                entry.push_back(i);
            }
                
            if(wordList[i]==endWord)
                end_idx=i;
        }
        if(end_idx==-1)
            return 0;

        int G[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                G[i][j]=0x3f3f3f3f;
            }
        }
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(dist(wordList[i], wordList[j])<=1) {
                    G[i][j]=1;
                }
            }
        }
        int d[n];
        for(int i=0;i<entry.size(); i++) {
            bool used[n][n];
            for(int j=0; j<n;j++) d[j]=0x3f3f3f3f;
            int s=entry[i];
            d[s]=dist(beginWord, wordList[s]);
            while(true) {
                bool update=false;
                for(int f=0;f<n;f++) {
                    for(int t=0;t<n;t++) {
                        if(G[f][t]==1 && d[f]!=0x3f3f3f3f && d[t]>d[f]+1) {
                            d[t]=d[f]+1;
                            update=true;
                        }
                    }
                }
                if(!update)
                    break;
            }
            if(d[end_idx]+1<min_cnt)
                min_cnt=d[end_idx]+1;
        }
        if(min_cnt==0x3f3f3f3f)
            min_cnt=0;
        return min_cnt;
    }
};