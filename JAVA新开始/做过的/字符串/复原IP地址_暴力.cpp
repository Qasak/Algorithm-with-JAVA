class Solution {
public:
    bool checkValid(string s)
    {
        if (stoi(s) <= 255) {
            if (s[0] != '0' || (s[0] == '0' && s.size() == 1)) {
                return true;
            }
        }
        return false;
    }

    vector<string> restoreIpAddresses(string s)
    {
        vector<string> result;
        
        for(int a = 1 ; a < 4 ; ++ a)
            for(int b = 1 ; b < 4 ; ++ b)
                for(int c = 1 ; c < 4 ; ++ c)
                    for(int d = 1 ; d < 4 ; ++ d)
                    {
                        if(a + b + c + d == s.length() )
                        {
                            string s1 = s.substr(0, a);
                            string s2 = s.substr(a, b);
                            string s3 = s.substr(a+b, c);
                            string s4 = s.substr(a+b+c, d);
                            if(checkValid(s1) && checkValid(s2) && checkValid(s3) && checkValid(s4))
                            {
                                string validIp = s1 + '.' + s2 + '.' + s3 + '.' + s4;
                                result.push_back(validIp);
                            }
                        }
                    }
        return result;
    }
};