package Mitsuha.序列DP;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/12 0:22
 */
class A {
    public int num;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a = (A) o;
        return num == a.num;
    }

    @Override
    public String toString() {
        return "A{" +
                "num=" + num +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }

    public A(int n) {
        num = n;
    }
}
public class test {
    public static void main(String[] args) {
        Set<A> set = new HashSet<>();
        A o = new A(2);
        set.add(o);
        System.out.println(set);
//        o.num = 1;
        System.out.println(set);
    }
}
