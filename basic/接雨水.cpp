class Solution {
public:
    
    struct bar{
        int val;
        bool istop=false;
    };
    bar* top[1<<14];
    bar ht[1<<14]={0};
    int dp[1<<12];
    int max(int a, int b) {
        if(a>b)
            return a;
        else 
            return b;
    }
    int max(int a, int b, int c) {
        if(max(a,b)>c)
            return max(a,b);
        else 
            return c;
    }
    int sum_ij(bar* top_max, bar* top_next) {
        int s_ij=0;
        bar* start;
        bar* end;
        if(top_max<top_next) {
            start=top_max;
            end=top_next;
        } else {
            start=top_next;
            end=top_max;
        }

        int bound = min(start->val, end->val);
        // printf("bound: %d\n", bound);
        for(int i=1; i<=(end-start); i++) {
            if(start[i].istop)
                start[i].istop=false;
            // printf("start[i]: %d\n", start[i].val);
            s_ij+=(bound-start[i].val)>0?bound-start[i].val:0;
            start[i].val=top[0]->val;
        }
        

        // printf("s_ij %d\n", s_ij);
        return s_ij;
    }
    static bool cmp(bar* a, bar* b) {
        return a->val>b->val;
    }
    int trap(vector<int>& height) {
        int sum=0;
        if(height.size()<=2)
            return sum;
        int n=height.size();
        for(int i=1; i<=n; i++) {
            ht[i].val=height[i-1];
        }
        
        int cur,prev,next;
        int p=0;
        for(int i=1; i<=n; i++) {
            prev=ht[i-1].val;
            cur=ht[i].val;
            next=ht[i+1].val;
            if(cur>prev&&cur>=next) {
                // printf("top: %d\n", cur);
                ht[i].istop=true;
                top[p++]=(&ht[i]);
            }
        }
        sort(top, top+p, cmp);
        
        // for(int i=0; i<p;i++) {
        //     printf("top[%d]->val: %d\n", i, top[i]->val);
        // }
        for(int i=1; i<p;i++) {
            if(top[i]->istop) {
                // printf("top[%d]->val: %d\n", i, top[i]->val);
                sum+=sum_ij(top[0], top[i]);
            }
        }
        
        
        return sum;
    }