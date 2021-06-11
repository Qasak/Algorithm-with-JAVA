package leetcode.contest.NiceProblem;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/11 15:55
 */
public class Q364_加权嵌套序列和2 {
//    int ans = 0;
//    int depth = 1;
//    public int depthSumInverse(List<NestedInteger> nestedList) {
//        for(NestedInteger ni : nestedList) {
//            depth = Math.max(depth, getDepth(ni, 1));
//        }
//        for(NestedInteger ni : nestedList) {
//            dfs(ni, 1);
//        }
//        return ans;
//    }
//    private void dfs (NestedInteger ni, int cur) {
//        int res = 0;
//        if(ni.isInteger()) {
//            ans += ni.getInteger() * (depth - cur + 1);
//        } else {
//            for(NestedInteger nii : ni.getList()) {
//                dfs(nii, cur + 1);
//            }
//        }
//    }
//    private int getDepth(NestedInteger ni, int cur) {
//        if(ni.isInteger()) {
//            return cur;
//        }
//        int res = 1;
//        for(NestedInteger nii : ni.getList()) {
//            res = Math.max(res, getDepth(nii, cur + 1));
//        }
//        return res;
//    }

}
