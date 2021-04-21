/*
你有一个日志数组 logs。每条日志都是以空格分隔的字串。

对于每条日志，其第一个字为字母与数字混合的 标识符 ，除标识符之外的所有字为这一条日志的 内容 。

除标识符之外，所有字均由小写字母组成的，称为 字母日志
除标识符之外，所有字均由数字组成的，称为 数字日志
题目所用数据保证每个日志在其标识符后面至少有一个字。

请按下述规则将日志重新排序：

所有 字母日志 都排在 数字日志 之前。
字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序；
数字日志 应该按原来的顺序排列。
返回日志的最终顺序。



示例 ：

输入：["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
输出：["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]

作者：力扣 (LeetCode)
链接：https://leetcode-cn.com/leetbook/read/2020-top-interview-questions/xrmsb5/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。




["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"]
*/
def cmp(s1):
    s1=(s1[s1.find(' ')+1:]+s1[0:s1.find(' ')])
    return s1



class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        num=[]
        alpha=[]
        for log in logs:
            if(log.split()[1].isalpha()):
                alpha.append(log)
            else:
                num.append(log)
        alpha=sorted(alpha, key=cmp)
        return alpha+num



    
    
    
    
    
    
    