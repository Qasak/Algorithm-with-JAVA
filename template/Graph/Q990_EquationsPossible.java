package leetcode.template.Graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/6 14:46
 */
public class Q990_EquationsPossible {
    private int[] uf;
    int find(int x) {
        if(uf[x] == x) {
            return x;
        }
        return uf[x] = find(uf[x]);
    }
    void union(int x, int y) {

        int px = find(x);
        int py = find(y);
        uf[px] = py;
    }
    public boolean equationsPossible(String[] eqs) {
        Map<Character, Integer> map = new HashMap<>();
        int idx = 0;
        for(String s : eqs) {
            if(!map.containsKey(s.charAt(0))) {
                map.put(s.charAt(0), idx++);
            }
            if(!map.containsKey(s.charAt(3))) {
                map.put(s.charAt(3), idx++);
            }
        }
        int n = map.size();
        uf = new int[n];
        for(int i = 0; i < n; i++) {
            uf[i] = i;
        }
        Arrays.sort(eqs, (a, b) -> b.charAt(1) - a.charAt(1));
        for(String s : eqs) {
            if(s.charAt(1) == '=') {
                union(map.get(s.charAt(0)), map.get(s.charAt(3)));
            } else {
                if(find(map.get(s.charAt(0))) == find(map.get(s.charAt(3)))) {
                    return false;
                }
            }
        }
        return true;
    }
    // 简化代码
    public boolean equationsPossible1(String[] eqs) {
        uf = new int[26];
        for(int i = 0; i < 26; i++) {
            uf[i] = i;
        }
        // Arrays.sort(eqs, (a, b) -> b.charAt(1) - a.charAt(1));
        for(String s : eqs) {
            if(s.charAt(1) == '=') {
                union(s.charAt(0) - 'a', s.charAt(3) - 'a');
            }
        }
        for(String s : eqs) {
            if(s.charAt(1) == '!') {
                if(find(s.charAt(0) - 'a')  == find(s.charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }
}
