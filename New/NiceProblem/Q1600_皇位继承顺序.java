package leetcode.contest.NiceProblem;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/20 21:49
 */
public class Q1600_皇位继承顺序 {
    // (嫡长子继承制)
    String king;
    Map<String, List<String>> map = new HashMap<>();
    Set<String> set = new HashSet<>();
    public Q1600_皇位继承顺序(String kingName) {
        king = kingName;
        map.put(king, new ArrayList<>());
    }

    public void birth(String parentName, String childName) {
        List<String> children = map.getOrDefault(parentName, new ArrayList<>());
        children.add(childName);
        map.put(parentName, children);
    }

    public void death(String name) {
        set.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> ans = new ArrayList<>();
        preorder(ans, king);
        return ans;
    }

    public void preorder(List<String> ans, String cur) {
        if(!set.contains(cur)) {
            ans.add(cur);
        }
        List<String> children = map.getOrDefault(cur, new ArrayList<>());
        for(String child : children) {
            preorder(ans, child);
        }
    }
}
