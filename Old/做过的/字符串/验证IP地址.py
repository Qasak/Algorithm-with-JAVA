from ipaddress import ip_address, IPv6Address
class Solution:
    def validIPAddress(self, IP: str) -> str:
        try:
            return "IPv6" if type(ip_address(IP)) is IPv6Address else "IPv4" # 默认前导0有效
        except ValueError:
            return "Neither"

/*
块只包含一位数字，范围是 0 到 9。

块包含两位数字，第一位的范围是 1 到 9，第二位是 0 到 9。

块包含三位数字，且第一位为 1。第二、三位可以是 0 到 9。

块包含三位数字，且第一位为 2，第二位为 0 到 4。那么第三位可以是 0 到 9。

块包含三位数字，且第一位为 2，第二位为 5，那么第三位可以是 0 到 5。

创建包含这 5 种情况的正则表达式。

*/
import re
class Solution:
    chunk_IPv4 = r'([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])'
    patten_IPv4 = re.compile(r'^(' + chunk_IPv4 + r'\.){3}' + chunk_IPv4 + r'$') # ():子表达式，(ab){1,3}表示ab一起连续出现最少1次，最多三次，ab{1,3}表示a，后面紧跟的b出现最少1次，最多3次
    
    chunk_IPv6 = r'([0-9a-fA-F]{1,4})'
    patten_IPv6 = re.compile(r'^(' + chunk_IPv6 + r'\:){7}' + chunk_IPv6 + r'$')

    def validIPAddress(self, IP: str) -> str:        
        if '.' in IP:
            return "IPv4" if self.patten_IPv4.match(IP) else "Neither" 
        if ':' in IP:
            return "IPv6" if self.patten_IPv6.match(IP) else "Neither" 
        return "Neither"