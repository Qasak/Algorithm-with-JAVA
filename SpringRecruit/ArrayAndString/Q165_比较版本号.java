package leetcode.SpringRecruit.ArrayAndString;

import javafx.util.Pair;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/7 12:33
 */
public class Q165_比较版本号 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split(".");
        String[] v2 = version2.split(".");
        int i = 0, j = 0, n = v1.length, m = v2.length;
        while(i < n && j < m) {
            int tag = Integer.valueOf(v1[i]).compareTo(Integer.valueOf(v2[j]));
            if(tag != 0) {
                return tag;
            }
            i++;j++;
        }
        if(i == n && j == m) {
            return 0;
        } else if(i == n) {
            return -1;
        } else {
            return 1;
        }
    }

    public int compareVersion1(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int n = Math.max(s1.length, s2.length);
        for(int i = 0; i < n; i++) {
            int a = i < s1.length ? Integer.parseInt(s1[i]) : 0;
            int b = i < s2.length ? Integer.parseInt(s2[i]) : 0;
            if(a < b) {
                return -1;
            } else if(a > b) {
                return 1;
            }
        }
        return 0;
    }
    // 双指针
    public Pair<Integer, Integer> getNextChunk(String version, int n, int p) {
        // if pointer is set to the end of string
        // return 0
        if (p > n - 1) {
            return new Pair(0, p);
        }
        // find the end of chunk
        int i, pEnd = p;
        while (pEnd < n && version.charAt(pEnd) != '.') {
            ++pEnd;
        }
        // retrieve the chunk
        if (pEnd != n - 1) {
            i = Integer.parseInt(version.substring(p, pEnd));
        } else {
            i = Integer.parseInt(version.substring(p, n));
        }
        // find the beginning of next chunk
        p = pEnd + 1;

        return new Pair(i, p);
    }

    public int compareVersion2(String version1, String version2) {
        int p1 = 0, p2 = 0;
        int n1 = version1.length(), n2 = version2.length();

        // compare versions
        int i1, i2;
        Pair<Integer, Integer> pair;
        while (p1 < n1 || p2 < n2) {
            pair = getNextChunk(version1, n1, p1);
            i1 = pair.getKey();
            p1 = pair.getValue();

            pair = getNextChunk(version2, n2, p2);
            i2 = pair.getKey();
            p2 = pair.getValue();
            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }
        // the versions are equal
        return 0;
    }

}
