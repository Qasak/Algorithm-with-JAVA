package leetcode.template.UnionFind;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/18 9:43
 */
public class Q721_AccountMerge {
    int[] parant;
    private int find(int x) {
        if(x == parant[x]) {
            return x;
        }
        return parant[x] = find(parant[x]);
    }
    private void union(int x, int y) {
        parant[find(y)] = find(x);
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<>();
        // 其余元素是按顺序排列的邮箱地址
        int n = accounts.size();
        // 字符: 集合
        Map<String, Integer> mailToIdx = new HashMap<>();
        // 集合：字符串列表
        Map<Integer, Set<String>> idxToSet = new HashMap<>();
        // init
        parant = new int[n];
        for(int i = 0; i < n; i++) {
            parant[i] = i;
        }
        for(int i = 0; i < n; i++) {
            List<String> list = accounts.get(i);
            for(int j = 1; j < list.size(); j++) {
                // 当前集合是否加入之前的集合
                if(!mailToIdx.containsKey(list.get(j))) {
                    mailToIdx.put(list.get(j), i);
                    if(!idxToSet.containsKey(i)) {
                        idxToSet.put(i, new HashSet<>());
                    }
                    idxToSet.get(i).add(list.get(j));
                } else {
                    union(mailToIdx.get(list.get(j)), i);
                }
            }
        }
        for(int i = 0; i < n; i++) {
            // 集合合并后，其中字符串合并
            if(find(i) != i) {
                List<String> list = accounts.get(i);
                for(int j = 1; j < list.size(); j++) {
                    idxToSet.get(find(i)).add(list.get(j));
                }
                // 当前集合已合并，删除
                idxToSet.remove(i);
            }
        }
        // 扫描所有集合
        for(int i : idxToSet.keySet()) {
            List<String> list = new ArrayList<>(idxToSet.get((i)));
            list.add(0, accounts.get(i).get(0));
            list.sort(String::compareTo);
            ans.add(list);
        }
        return ans;
    }
}
