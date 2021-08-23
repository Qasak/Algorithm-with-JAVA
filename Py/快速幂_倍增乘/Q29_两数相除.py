class Solution:
    def mul(self, a:int, x:int):
        ans = 0
        while(x > 0):
            if((x & 1) == 1):
                ans += a
            a += x
            x >>= 1
        return ans
    def divide(self, a: int, b: int) -> int:
        isNeg = (a < 0 and b > 0) or (a > 0 and b < 0)
        if(a < 0):
            a = -a
        if(b < 0):
            b = -b
        l = 0
        r = a
        ans = l
        while(l <= r):
            m = (l + r + 1) >> 1
            cur = mul(b, m)
            if(cur > a):
                r = m - 1
            elif(cur < a):
                ans = m
                l = m + 1
            else:
                ans = m
                break
        if(isNeg):
            ans = -ans
        if(ans > 2147483647 or ans < -2147483648):
            return 2147483647
        return ans
