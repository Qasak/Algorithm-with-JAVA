package leetcode.template.Simulation;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/11 23:23
 */
public class Q468_验证IP地址 {
    public String validIPAddress(String IP) {
        if(check4(IP)) {
            return "IPv4";
        }
        if(check6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }
    public boolean check4(String IP) {
        int dot = 0;
        for(char c : IP.toCharArray()) {
            if(c == '.') {
                dot++;
            }
        }
        if(dot != 3) {
            return false;
        }
        String[] tmp = IP.split("\\.");
        if(tmp.length != 4) {
            return false;
        }
        for(String num : tmp) {
            int n = num.length();
            if(n == 0 || n > 3) {
                return false;
            }

            for(char c : num.toCharArray()) {
                if(!Character.isDigit(c)) {
                    return false;
                }
            }
            if(n > 1 && num.charAt(0) == '0') {
                return false;
            }
            if(Integer.valueOf(num) > 255) {
                return false;
            }
        }
        return true;
    }
    public boolean check6(String IP) {
        int dot = 0;
        for(char c : IP.toCharArray()) {
            if(c == ':') {
                dot++;
                continue;
            }
            if(!Character.isDigit(c)) {
                if(!(c >= 'a' && c <= 'f') && !(c >= 'A' && c <= 'F')) {
                    // System.out.println(c);
                    return false;
                }
            }
        }
        if(dot != 7) {
            return false;
        }
        String[] tmp = IP.split(":");
        if(tmp.length != 8) {
            return false;
        }
        for(String num : tmp) {
            int n = num.length();
            if(n == 0 || n > 4) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String a = "2001:0db8:85a3::0:8A2E:0370:7334:";
        String[] tmp = a.split(":");
        System.out.println(Arrays.toString(tmp));
    }
}
