class Solution {
public:
    int videoStitching(vector<vector<int>>& clips, int T) {
        int ans=0;
        int r_end=0;
        clips.push_back({T,T});
        int n=clips.size();
        int j=0;
        sort(clips.begin(), clips.end(), [](vector<int> &a, vector<int> &b){return a[0]<b[0] || (a[0]==b[0] && a[1]>b[1]);});
        while(j<n && r_end<T) {
            int cur_end=INT_MIN;
            while(j<n && clips[j][0]<=r_end) 
                cur_end=max(cur_end, clips[j++][1]);
            if(cur_end==INT_MIN)
                return -1;
            r_end=cur_end;
            ans++;
        }
        return ans;
    }
};