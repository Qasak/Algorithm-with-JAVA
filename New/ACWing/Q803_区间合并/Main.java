package ACWing.Q803_区间合并;

import java.beans.IntrospectionException;
import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/10 20:45
 */
class Main {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 2);
        map.put(2, 2);
        System.out.println(map.lastKey());
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(2);
        set.add(-3);
        System.out.println(set.first());
    }
}