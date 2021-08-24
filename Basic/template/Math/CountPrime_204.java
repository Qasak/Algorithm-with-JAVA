package leetcode.template.Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/3 13:35
 *
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 *
 */
public class CountPrime_204 {
    /**
     * 枚举：质数的定义：在大于 1 的自然数中，除了 1 和它本身以外不再有其他因数的自然数
     *
     * 判断某一个数是否是质数：
     * 从小到大枚举 [2,x-1]  中的每个数 y, 判断 y 是否为x 的因数
     * (10: 2,3,4,5,6,7,8,9)
     * 如果 y 是 x 的因数，那么 x/y也必然是 x 的因数
     * 2 是 10 的因数，那么 5也是x 的因数
     * 如果我们每次选择校验两者中的较小数
     * 较小数一定落在 [2,sqrt(x)]的区间中
     * */
    public static int countPrimes(int n) {
        int cnt = 0;
        for(int i = 2; i < n; i++) {
            cnt += isPrime(i) ? 1 : 0;
        }
        return cnt;
    }
    //
    private static boolean isPrime(int x) {
        // 9: 2,3 有等号
        for(int i = 2; i * i <= x; i++) {
            if(x % i == 0) {
                return false;
            }
        }
        return true;
    }
    /**
     *  * 埃式筛：如果 x 是质数，那么大于 x 的 x 的倍数 2x,3x,… 一定不是质数
     *  * 设 isPrime[i] 表示数 i 是不是质数，如果是质数则为 1，否则为 0
     *  * 从小到大遍历每个数，如果这个数为质数，则将其所有的倍数都标记为合数（除了该质数本身）
     *  * 这样在运行结束的时候我们即能知道质数的个数。
     *  *
     *  * 对于一个质数 x，如果按上文说的我们从 2x 开始标记其实是冗余的，应该直接从 x⋅x 开始标记，
     *  因为 2x,3x… 这些数一定在 x 之前就被其他数的倍数标记过了
     *  *O(nloglogn)
     * */
    public static int countPrimes1(int n) {
        int cnt = 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        // 2[4,6,8]
        // 3[9]
        // 5[]
        // 7[]
        for(int i = 2; i < n; i++) {
            if(isPrime[i]) {
                cnt += 1;
                if((long)i * i < n) {
                    for(int j = i * i; j < n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
        }
        return cnt;
    }
    /**
     * 线性筛 O(n)
     *
     * 多维护一个 primes 数组表示当前得到的质数集合。
     * 我们从小到大遍历，如果当前的数 x 是质数，就将其加入 primes 数组。
     *
     * */
    public static int countPrimes2(int n) {
        boolean[] isPrime = new boolean[n];
        List<Integer> primes = new ArrayList<>();
        Arrays.fill(isPrime, true);
        for(int i = 2; i < n; i++) {
            if(isPrime[i]) {
                primes.add(i);
            }
            /**
             * 对每个整数 x 都进行标记
             * 对于整数 xx，我们不再标记其所有的倍数 x * x,x*(x+1)…，而是只标记质数集合中的数与 x 相乘的数，
             * 即 x*primes_0,x*primes_1
             * 且在发现 x % primes_i =0 的时候结束当前标记。
             *
             * 如果 x 可以被 primes_i整除，那么对于合数 y=x⋅primes_i+1而言
             * 它一定在后面遍历到 x/primes_i * primes_i+1这个数的时候会被标记
             * 这保证了每个合数只会被其「最小的质因数」筛去，即每个合数被标记一次。
             * */
            for(int j = 0; j < primes.size() && i * primes.get(j) < n; j++){
                isPrime[i * primes.get(j)] = false;
                if(i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        return primes.size();
    }
    public static void main(String[] args) {
        System.out.println(CountPrime_204.isPrime(9));
    }
}
