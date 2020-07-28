class Solution {
public:
    int max(int a,int b) {
        if(a>b)
            return a;
        else return b;
    }
    int min(int a, int b) {
        if(a<b)
            return a;
        else
            return b;
    }
    double findMedianSortedArrays(vector<int>& A, vector<int>& B) {
        // double median;
        if(A.size()>B.size())
            return findMedianSortedArrays(B, A); // m>=n
        int n=A.size();
        int m=B.size();
        int lo=0;
        int hi=n;
        int k=(n+m+1)/2; // 1<=k
        int c1,c2;
        int Lmax1,Rmin1,Lmax2,Rmin2;
        while(lo<=hi) {
            
            c1=(lo+hi)/2; // 0<=c1<=n-1
            c2=k-c1;//
            if(c1!=0 && c2!=m && A[c1-1]>B[c2])
                hi=c1-1;
            else if(c2!=0 && c1!=n && B[c2-1]>A[c1])
                lo=c1+1;
            else {
                int maxLeft;
                int minRight;
                if(c1==0)
                    maxLeft=B[c2-1];
                else if(c2==0)
                    maxLeft=A[c1-1];
                else
                    maxLeft=max(A[c1-1], B[c2-1]);
                if((m+n)%2)
                    return (double) maxLeft;
                
                if(c2==m)
                    minRight=A[c1];
                else if(c1==n)
                    minRight=B[c2];
                else
                    minRight=min(A[c1], B[c2]);
                return (double) (maxLeft+minRight)/2;
            
            }
        }
        return (double) 0;
    }
};