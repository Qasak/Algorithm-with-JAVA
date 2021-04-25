package leetcode.HighFreq.old;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/10 18:25
 *
 *给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 *
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 *
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 *
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 *
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
    0 <= s.length <= 3000
    s 仅由数字组成
 */
public class RestoreIp_93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        for(int a = 1; a < 4; a++) {
            for(int b = 1; b < 4; b++) {
                for(int c = 1; c < 4; c++) {
                    for(int d = 1; d < 4; d++) {
                        if(a + b + c + d == s.length()) {
                            String s1 = s.substring(0, a);
                            String s2 = s.substring(a, a + b);
                            String s3 = s.substring(a + b, a + b + c);
                            String s4 = s.substring(a + b + c, a + b + c + d);
                            if(checkValid(s1) && checkValid(s2) && checkValid(s3) && checkValid(s4)) {
                                String ip = s1 + s2 + s3 + s4;
                                ans.add(ip);
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
    private boolean checkValid(String s) {
        if(Integer.parseInt(s) <= 255) {
            return s.charAt(0) != '0' || s.charAt(0) == 0 && s.length() == 1;
        }
        return false;
    }
}
