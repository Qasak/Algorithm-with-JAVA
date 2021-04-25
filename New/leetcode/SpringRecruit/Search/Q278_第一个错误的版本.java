package leetcode.SpringRecruit.Search;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/7 12:17
 */
public class Q278_第一个错误的版本 {
    Random rand = new Random();
    public boolean isBadVersion(int m) {
        return rand.nextBoolean();
    }
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while(l <= r) {
            int m = (l + r) >>> 1;
            if(isBadVersion(m)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }


    public int firstBadVersion1(int n) {
        int l = 1, r = n;
        while(l < r) {
            int m = (l + r) >>> 1;
            if(!isBadVersion(m)) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
    public int firstBadVersion2(int n) {
        int l = 1, r = n;
        while(l < r) {
            int m = l + (r - l) / 2;
            if(!isBadVersion(m)) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    public static void main(String[] args) {
    }
}
