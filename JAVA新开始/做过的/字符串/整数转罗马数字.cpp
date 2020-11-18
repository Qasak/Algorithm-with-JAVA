class Solution {
public:
    string intToRoman(int num) {
        unordered_map<int, string> mp{
        {1,"I"}, {4, "IV"}, {5,"V"},{9, "IX"},
        {10,"X"}, {40, "XL"},{50, "L"},{90, "XC"}, 
        {100, "C"}, {400, "CD"},{500, "D"},{900, "CM"},
        {1000, "M"}};
        string ans;
        int t;
        //k
        for(int i=0;i<num/1000;i++)
            ans+=mp[1000];
        //hundred
        t=(num%1000)/100;
        if(t<=3) 
            for(int i=0; i<t; i++)
                ans+=mp[100];
        else if(t==4)
            ans+=mp[400];
        else if(t==5)
            ans+=mp[500];
        else if(t>5 && t<9) {
            ans+=mp[500];
            for(int i=0; i<t-5; i++)
                ans+=mp[100];
        } else
            ans+=mp[900];
        //dec
        t=(num%100)/10;
        if(t<=3) 
            for(int i=0; i<t; i++)
                ans+=mp[10];
        else if(t==4)
            ans+=mp[40];
        else if(t==5)
            ans+=mp[50];
        else if(t>5 && t<9) {
            ans+=mp[50];
            for(int i=0; i<t-5; i++)
                ans+=mp[10];
        } else
            ans+=mp[90];
        //dig
        t=num%10;
        if(t<=3) 
            for(int i=0; i<t; i++)
                ans+=mp[1];
        else if(t==4)
            ans+=mp[4];
        else if(t==5)
            ans+=mp[5];
        else if(t>5 && t<9) {
            ans+=mp[5];
            for(int i=0; i<t-5; i++)
                ans+=mp[1];
        } else
            ans+=mp[9];
        return ans;
    }
};

class Solution {
public:
    string intToRoman(int num) {
        int values[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        string reps[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        
        string res;
        for(int i=0; i<13; i++){
            while(num>=values[i]){
                num -= values[i];
                res += reps[i];
            }
        }
        return res;
    }
};
