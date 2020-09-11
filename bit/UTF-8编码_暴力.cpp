class Solution {
public:
    bool validUtf8(vector<int>& data) {
        int n=data.size();
        if(!n) return false;
        int i=0;
        while(i<n) {
            int low8=data[i]&0xFF;
            int low4=((low8>>4) & 0xF);
            if(!(low4>>3)) i++;      //n=1
            else if(low4==0xF) { //n=4
                if((low8>>3 & 1)) 
                    return false;
                if(i+3>=n) 
                    return false;
                for(int j=1;j<=3;j++) {
                    int t=data[i+j];
                    if((t>>6 & 3) !=2) 
                        return false;
                }
                i+=4;
            }
            else if((low4>>1)==0x7) { //n=3
                if((low8>>4 & 1)) 
                    return false;
                if(i+2>=n)
                    return false;
                for(int j=1;j<=2;j++) {
                    int t=data[i+j];
                    if((t>>6 & 3) !=2) 
                        return false;
                }
                i+=3;
            }
            else if((low4>>2)==0x3) { //n=2
                if(((low8>>5) & 1)) 
                    return false;
                if(i+1>=n) 
                    return false;
                int t=data[i+1];
                if(t>>6 & 3 !=2) 
                    return false;
                i+=2;
            }
            else 
                return false;
        }
        return true;
    }
}