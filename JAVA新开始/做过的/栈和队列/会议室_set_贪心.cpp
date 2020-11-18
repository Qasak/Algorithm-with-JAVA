struct edge {
    int l;
    int r;
};

bool operator<(const edge &a, const edge &b) {
    return a.r<=b.l;
}

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
        if(intervals.empty())
            return 0;
        int n=intervals.size();
        vector<set<edge> > rooms;

		vector<pair<int,int>> meeting;
        for(auto interval:intervals){
            meeting.push_back(pair<int,int>(interval[0],interval[1]));
        }
        sort(meeting.begin(), meeting.end(), cmp);


        for(int i=0; i<n; i++) {
            edge tmp={meeting[i].first, meeting[i].second};
            set<edge>::iterator it;
            bool flag=false;
            for(auto &room: rooms) {
                it=room.find(tmp);
                if(it==room.end()) {
                    room.insert(tmp);
                    flag=true;
                    break;
                }
            }
            if(!flag) {
                set<edge> new_room;
                new_room.insert(tmp);
                rooms.push_back(new_room);
            }
        }
        return rooms.size();

    }
};