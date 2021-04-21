package leetcode.template.BinCalc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/11 22:31
 */
public class Q751_IP到CIDR {
    public List<String> ipToCIDR(String in, int n) {
        List<String> ans = new ArrayList<>();
        String[] tmp = in.split("\\.");
        long ip = 0;
        for(String num : tmp) {
            ip = ip * 256 + Long.valueOf(num);
        }
        if(ip == 0) {
            for(int i = 0; i < n; i++) {
                ans.add(ipToString(ip) + "/32");
                ip++;
            }
            return ans;
        }
        // 10 : 1010
        while(n > 0) {
            int sft = Math.min(bitLen(n), bitLen(ip & -ip));
            ans.add(ipToString(ip) + "/" + String.valueOf(33 - sft));
            ip += 1 << (sft - 1);
            n -= 1 << (sft - 1);
        }
        return ans;

    }
    int bitLen(long n) {
        int ans = 0;
        while(n > 0) {
            ans++;
            n >>= 1;
        }
        return ans;
    }
    public String ipToString(long ip) {
        long mask = 255;
        return String.format("%d.%d.%d.%d", (ip >> 24) & mask, (ip >> 16) & mask, (ip >> 8) & mask, ip & mask);
    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("11", 3));
        System.out.println(Integer.valueOf("11"));

    }
}
