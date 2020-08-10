const int len=60000;
const int mid=30000;
class Solution {
public:

    bitset<len> bs;

    int lastStoneWeightII(vector<int>& stones) {
        bs.reset();
        bs[mid]=1;
        for(int stone : stones) {
            bs=(bs<<stone|bs>>stone);
        }
        for(int i=0;i<30000;i++) {
            if(bs[mid+i])
                return i;
        }
        return -1;
    }
    
};