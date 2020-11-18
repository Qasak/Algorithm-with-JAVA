bool cmp(const pair<int,int> a, const pair<int,int> b) {
    if(a.first<b.first)
        return true;
    else if(a.first == b.first) {
        return a.second<b.second;
    } else {
        return false;
    }
}

class Solution {
public:
    int minMeetingRooms(vector<vector<int>>& intervals) {
        int cnt=0;
        int mxcnt=0;
        if(intervals.empty())
            return 0;
        int n=intervals.size();

		vector<pair<int,int>> meeting;
        for(auto interval:intervals){
            meeting.push_back(pair<int,int>(interval[0],1));
            meeting.push_back(pair<int,int>(interval[1],-1));
        }
        sort(meeting.begin(), meeting.end(), cmp);
        for(auto &meet:meeting) {
            cnt+=meet.second;
            mxcnt=max(mxcnt, cnt);
        }

        return mxcnt;

    }
};