package leetcode.template.Simulation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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




    Set<Character> set = new HashSet<>();
    public String validIPAddress1(String IP) {
        if(IP == null || IP.length() == 0) {
            return "Neither";
        }
        for(int i = 0; i < 6; i++) {
            set.add((char) ('a' + i));
            set.add((char) ('A' + i));
        }
        for(int i = 0; i <= 9; i++) {
            set.add((char) (i + '0'));
        }
        return isI4(IP) ? "IPv4" : (isI6(IP) ? "IPv6" : "Neither");
    }
    public boolean isI4(String IP) {
        if(!set.contains(IP.charAt(0)) || !set.contains(IP.charAt(IP.length() - 1))){
            return false;
        }
        String[] t = IP.split("\\.");
        if(t.length != 4) {
            return false;
        }
        for(String num : t) {
            if(num.length() == 0 || num.length() > 3) {
                return false;
            }
            for(char c : num.toCharArray()) {
                if(!Character.isDigit(c)) {
                    return false;
                }
            }
            if((num.length() > 1 && num.charAt(0) == '0') || Integer.valueOf(num) > 255) {
                return false;
            }
        }
        return true;
    }
    public boolean isI6(String IP) {
        if(!set.contains(IP.charAt(0)) || !set.contains(IP.charAt(IP.length() - 1))){
            return false;
        }
        String[] t = IP.split(":");
        if(t.length != 8) {
            return false;
        }
        for(String num : t) {
            if(num.length() == 0 || num.length() > 4) {
                return false;
            }
            for(char c : num.toCharArray()) {
                if(!set.contains(c)) {
                    return false;
                }
            }
        }
        return true;
    }


    public String validIPAddress2(String IP) {
        String p1 = "(\\d|[1-9]\\d|1\\d\\d|25[0-5]|2[0-4]\\d)";
        String p2 = "([\\da-fA-F]{1,4})";
        String IPv4Pattern =  p1 + "(\\." + p1 + "){3}" ;
        String IPv6Pattern =  p2 + "(\\:" + p2 + "){7}" ;
        return IP.matches(IPv4Pattern) ? "IPv4" : (IP.matches(IPv6Pattern) ? "IPv6" : "Neither");
    }



    public static void main(String[] args) {
        String IP = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        String[] t = IP.split(":");
        System.out.println(Arrays.toString(t));
    }
}
