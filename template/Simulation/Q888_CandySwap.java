package leetcode.template.Simulation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/1 10:22
 */
public class Q888_CandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int diff = sumA - sumB;
        Set<Integer> set = new HashSet<>(Arrays.asList(Arrays.stream(B).boxed().toArray(Integer[] :: new)));

        // A + -diff / 2;
        // B - -diff / 2;
        diff /= 2;
        if(diff < 0) {
            diff = -diff;
            for(int i: A) {
                if(set.contains(i + diff)) {
                    return new int[]{i, i + diff};
                }
            }
        } else {
            for(int i: A) {
                if(set.contains(i - diff)) {
                    return new int[]{i, i - diff};
                }
            }
        }
        return new int[]{};
    }
    public int[] fairCandySwap1(int[] A, int[] B) {
        int diff = (Arrays.stream(A).sum() - Arrays.stream(B).sum()) / 2;
        Set<Integer> set = new HashSet<>(Arrays.asList(Arrays.stream(B).boxed().toArray(Integer[] :: new)));
        for(int i: A) {
            if(set.contains(i - diff)) {
                return new int[]{i, i - diff};
            }
        }
        return new int[]{};
    }
    public static void main(String[] args) {
        int[] a = {1,2,3};
        System.out.println(Arrays.stream(a).sum());
        Set<Integer> set = new HashSet<>(Arrays.asList(Arrays.stream(a).boxed().toArray(Integer[] :: new)));

    }
}
