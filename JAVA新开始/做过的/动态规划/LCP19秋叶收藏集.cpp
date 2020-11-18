class Solution {
public:
    int minimumOperations(string leaves) {
        int n=leaves.size();
        int i=0;
        int j=n-1;
        int cnt=INT_MAX;
        int sum[100001]={0};
        for(int i=0;i<n;i++) 
            sum[i+1]=sum[i]+(leaves[i]=='r' ? 1 : 0);
        int Min[100001]={0};
        int cur=INT_MAX;
        for(int i=1;i<n-1;i++) {
            cur=min(cur, i-2*sum[i]);
            Min[i]=cur;
        }
        for(int j=n-1;j>1;j--)
            cnt=min(cnt, n-sum[n]+Min[j-1]-j+2*sum[j]);
        return cnt;
    }
};