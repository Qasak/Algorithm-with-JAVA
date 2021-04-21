class Solution:
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        mp={"M":1000,"D":500,"C":100,"L":50,"X":10,"V":5,"I":1}
        res=0
        for i in range(len(s)-1):
                res= res-mp[s[i]] if mp[s[i]]<mp[s[i+1]] else res+mp[s[i]]
        return res+mp[s[-1]]