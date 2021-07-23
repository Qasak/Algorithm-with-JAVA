package leetcode.contest.Rating1800.二分;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/23 11:19
 */
public class Q1095_山脉数组中查找目标值 {
//    public int findInMountainArray(int target, MountainArray mountainArr) {
//        int n = mountainArr.length();
//        int l = 1, r = n - 1;
//        // 山顶
//        int m = 0;
//        int a = 0, b = 0, c = 0;
//        while(l < r) {
//            m = (l + r) >>> 1;
//            a = mountainArr.get(m - 1);
//            b = mountainArr.get(m);
//            c = mountainArr.get(m + 1);
//            if(a < b && b < c) {
//                l = m + 1;
//            } else if(a > b && b > c) {
//                r = m;
//            } else {
//                break;
//            }
//        }
//        // System.out.println(b + " " + m);
//        if(b == target) {
//            return m;
//        }
//        int ret = bsL(0, m, target, mountainArr);
//        if(ret != -1) {
//            return ret;
//        }
//        ret = bsR(m, n - 1, target, mountainArr);
//        return ret;
//    }
//    // 返回下标
//    private int bsL(int l, int r, int target, MountainArray mountainArr) {
//        while(l < r) {
//            int m = (l + r) >>> 1;
//            int val = mountainArr.get(m);
//            if(target == val) {
//                return m;
//            } else if(val < target) {
//                l = m + 1;
//            } else {
//                r = m;
//            }
//        }
//        return -1;
//    }
//    private int bsR(int l, int r, int target, MountainArray mountainArr) {
//        while(l < r) {
//            int m = (l + r + 1) >>> 1;
//            int val = mountainArr.get(m);
//            if(target == val) {
//                return m;
//            } else if(val < target) {
//                r = m - 1;
//            } else {
//                l = m;
//            }
//        }
//        return -1;
//    }
}
