package leetcode.contest.NiceProblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/19 18:07
 */



//  前面的决策与后面的决策有关系，没办法获得子最优解。
public class Q1239_串联字符串的最大长度 {
    int ans = 0;
    public int maxLength(List<String> arr) {
        List<Integer> list = new ArrayList<>();
        for(String s : arr) {
            int mask = 0;
            for(char c : s.toCharArray()) {
                if( ( (mask >> (c - 'a') ) & 1 ) == 1 ) {
                    mask = 0;
                    break;
                } else {
                    mask |= 1 << (c - 'a');
                }
            }
            if(mask != 0) {
                list.add(mask);
            }
        }
        dfs(list, 0, 0);
        return ans;
    }

    private void dfs(List<Integer> list, int idx, int cur) {
        if(idx == list.size()) {
            ans = Math.max(ans, Integer.bitCount(cur));
            return;
        }
        if((list.get(idx) & cur) == 0) {
            dfs(list, idx + 1, cur | list.get(idx));
        }
        dfs(list, idx + 1, cur);
    }


    StringBuilder sb=new StringBuilder();
    int res=0;
    public int maxLength1(List<String> arr) {
        dfs(arr,0);
        return res;
    }

    public void dfs(List<String> arr,int start){
        Set<Character> set=new HashSet<>();
        for(char c: sb.toString().toCharArray()){
            if(set.contains(c)){
                return;
            }else{
                set.add(c);
            }
        }
        res=Math.max(res,sb.length());
        int len = sb.length();
        for(int i=start;i<arr.size();i++){
            sb.append(arr.get(i));
            dfs(arr,i+1);
            sb.setLength(len);
        }
    }
}
