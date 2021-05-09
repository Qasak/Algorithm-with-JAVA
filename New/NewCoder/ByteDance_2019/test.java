package NewCoder.ByteDance_2019;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/31 15:40
 */
public class test {
    public static void main(String[] args) {
        Pair<Integer, Integer> p = new Pair<>(1,2);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.remove(new Integer(1));
        System.out.println(list);
    }
}
