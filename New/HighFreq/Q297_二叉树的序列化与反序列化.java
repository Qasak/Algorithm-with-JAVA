package leetcode.HighFreq;

import leetcode.template.Tree.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/30 10:33
 */

// 两次BFS
public class Q297_二叉树的序列化与反序列化 {
    class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root == null) {
                return "[]";
            }
            Deque<TreeNode> q = new LinkedList<>();
            q.offer(root);
            boolean flag = true;
            StringBuilder ans = new StringBuilder();
            ans.append("[");
            while(!q.isEmpty() && flag) {
                flag = false;
                int size = q.size();
                for(int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    if(node != null) {
                        ans.append(node.val);
                        ans.append(",");
                        q.offer(node.left);
                        q.offer(node.right);
                        if(node.left != null || node.right != null) {
                            flag = true;
                        }
                    } else {
                        ans.append("null");
                        ans.append(",");
                    }
                }

            }
            ans.setLength(ans.length() - 1);
            ans.append("]");
            return ans.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if("[]".equals(data)) {
                return null;
            }
            String[] vals = data.substring(1, data.length() - 1).split(",");
            TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
            Deque<TreeNode> q = new LinkedList<>();
            q.offer(root);
            int i = 1;
            int n = vals.length;
            while(i < n) {
                TreeNode node = q.poll();
                if(!"null".equals(vals[i])) {
                    node.left = new TreeNode(Integer.parseInt(vals[i]));
                    q.offer(node.left);
                }
                i++;
                if(!"null".equals(vals[i])) {
                    node.right = new TreeNode(Integer.parseInt(vals[i]));
                    q.offer(node.right);
                }
                i++;
            }
            return root;
        }
    }

}


// 两次先序
class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "null";
        }
        StringBuilder ret = new StringBuilder();
        ret.append(root.val);
        // 注意逗号的数量
        ret.append(",");
        String l = serialize(root.left);
        String r = serialize(root.right);
        ret.append(l);
        ret.append(",");
        ret.append(r);
        return ret.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfs(queue);
    }

    private TreeNode dfs(Deque<String> queue) {
        // 队列为空时返回null
        String val = queue.poll();
        if("null".equals(val)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = dfs(queue);
        root.right = dfs(queue);
        return root;
    }
}
