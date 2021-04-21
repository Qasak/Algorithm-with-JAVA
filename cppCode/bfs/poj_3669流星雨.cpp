#include<cstdio>
#include<iostream>
#include<queue>
#include<string.h>

using namespace std;

typedef pair<int, int> pii;

const int INF=0x3f3f3f3f;

int d[303][303];
int ms[303][303];

int dx[5] = {-1,0,1,0,0};
int dy[5] = {0,1,0,-1,0};

int bfs() {
	if(ms[0][0]==INF) return 0;
	memset(d, -1, sizeof(d));
	queue<pii> q;
	d[0][0]=0;
	q.push(make_pair(0,0));
	while(!q.empty()) {
		pii f=q.front();
		q.pop();
		int x=f.first;
		int y=f.second;
		
		for(int i=0;i<4;i++) {
			int xx=x+dx[i];
			int yy=y+dy[i];

			if(xx>=0 && xx<302 && yy>=0 && yy<302 && d[xx][yy]==-1 && d[x][y]+1 < ms[xx][yy]) {
                d[xx][yy]=d[x][y]+1;
                if(ms[xx][yy]==INF) {
                    return d[xx][yy];
                }
				q.push(make_pair(xx,yy));
			}
		}
	}
	return -1;
}

int solve() {
	memset(ms, INF, sizeof(ms));
    int m;
	cin>>m;
	for(int i=0;i<m;i++) {
        int x,y,xx,yy,t;
		cin>>x>>y>>t;
        
		for(int j=0;j<5;j++) {
            xx=x+dx[j];
            yy=y+dy[j];
			if(xx>=0 && xx<302 && yy>=0 && yy<302)
				ms[xx][yy]=min(ms[xx][yy],t);
        }


	}
	return bfs();
}

int main() {
	cout<<solve()<<endl;
	return 0;
}