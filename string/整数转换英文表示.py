# 1234567890，我们将它从低位开始每三个分成一组，得到 1,234,567,890，它的英文表示为 1 Billion 234 Million 567 Thousand 890
class Solution:
    def numberToWords(self, num: int) -> str:
        to19 = 'One Two Three Four Five Six Seven Eight Nine Ten Eleven Twelve ' \
               'Thirteen Fourteen Fifteen Sixteen Seventeen Eighteen Nineteen'.split()
        tens = 'Twenty Thirty Forty Fifty Sixty Seventy Eighty Ninety'.split()

        def helper(num):
            if num < 20:
                return to19[num-1:num]
            if num < 100:
                return [tens[num//10-2]]+helper(num%10)
            if num < 1000:
                return helper(num//100) + ['Hundred'] + helper(num%100)
            for p, w in enumerate(['Thousand', 'Million', 'Billion'], 1):
                if num < 1000**(p + 1):
                    return helper(num//(1000**p)) + [w] + helper(num % (1000**p))
        return ' '.join(helper(num)) or 'Zero'


