package Others;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/30 15:06
 */
public class RedPackage {
    private int remainSize;
    private BigDecimal  remainMoney;
    public RedPackage(int size, BigDecimal money) {
        remainSize = size;
        remainMoney = money;
    }
    // 二倍均值法：每次抢的金额 = [0.01, 2 * (money / size))
    public BigDecimal getRandomMoney() {
        if(remainSize == 1) {
            remainSize--;
            return remainMoney;
        }
        Random rand = new Random();
        BigDecimal min = new BigDecimal("0.01");
        BigDecimal max = remainMoney.multiply(new BigDecimal(2)).divide(new BigDecimal(remainSize), 2, BigDecimal.ROUND_HALF_UP);
        BigDecimal ret = max.multiply(new BigDecimal(String.valueOf(rand.nextDouble())));
        if(ret.compareTo(min) < 0) {
            ret = min;
        }
        BigDecimal t = ret.setScale(2, BigDecimal.ROUND_CEILING);
        System.out.println(ret + " "  + t);
        ret = t;
        remainSize--;
        remainMoney = remainMoney.subtract(ret);
        return ret;
    }
}
