package leetcode.template.Hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/18 18:44
 */
public class Q178_RepeatedDNA {
    public List<String> findRepeatedDnaSequences(String s) {
        // AAAAAAAAAA
        // AAAAAAAAAAAAA
        // ACACACACAC ACACACACACAC
        Set<String> set = new HashSet<>();
        int n = s.length();
        // [0, 9]
        Set<String> ans = new HashSet<>();
        for(int i = 0; i <= n - 10; i++) {
            String t = s.substring(i, i + 10);
            if(!set.add(t)) {
                ans.add(t);
            }
        }
        return new ArrayList<>(ans);
    }
}
