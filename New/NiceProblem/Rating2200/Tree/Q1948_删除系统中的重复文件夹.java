package leetcode.contest.Rating2200.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/27 16:54
 */
public class Q1948_删除系统中的重复文件夹 {
    class Solution {
        public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
            TrieNode root = new TrieNode();
            for (List<String> path : paths) {
                TrieNode curr = root;
                for (String folder : path) {
                    if (!curr.children.containsKey(folder)) {
                        curr.children.put(folder, new TrieNode());
                    }
                    curr = curr.children.get(folder);
                }
            }
            delete(root, new HashMap<>());
            List<List<String>> ans = new ArrayList<>();
            dfs(root, new ArrayList<>(), ans);
            return ans;
        }
        // (a(b)) (b(b)) (d(a))

        // ( a(x(y))(z) ) ( b(x(y))(z)(w) )
        String delete(TrieNode root, Map<String, TrieNode> map) {
            if (root.children.isEmpty()) return "";
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, TrieNode> e : root.children.entrySet()) {
                String folder = e.getKey();
                TrieNode child = e.getValue();
                sb.append('(').append(folder).append(delete(child, map)).append(')');
            }
            String serialized = sb.toString();
            if (map.containsKey(serialized)) {// 已经存在此序列化值，两者都删除
                map.get(serialized).deleted = true;
                root.deleted = true;
            } else {
                map.put(serialized, root);
            }
            return serialized;
        }

        void dfs(TrieNode root, List<String> path, List<List<String>> ans) {
            for (Map.Entry<String, TrieNode> e : root.children.entrySet()) {
                String folder = e.getKey();
                TrieNode child = e.getValue();
                if (child.deleted) continue;
                path.add(folder);
                dfs(child, path, ans);
                path.remove(path.size() - 1);
            }
            if (!path.isEmpty()) ans.add(new ArrayList<>(path));
        }
    }

    class TrieNode {
        Map<String, TrieNode> children = new HashMap<>();
        boolean deleted;
    }
}
