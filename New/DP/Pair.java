package leetcode.SpringRecruit.DP;

import java.util.Objects;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/2 17:42
 */
public class Pair {
        int x;
        int y;
        public Pair(int xx, int yy) {
            x = xx;
            y = yy;
        }

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return x == pair.x &&
                y == pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
