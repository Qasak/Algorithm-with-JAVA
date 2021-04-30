package Others;

import leetcode.contest.WeekContest_218.B;
import leetcode.zuo.EqualProbability;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/30 11:52
 */

// 最小单位：分 保留两位小数
    // 120的红包 最大值31.24
    // 一共10个

    // 最大值多少？
    // 单个200块
    // 最多100个
    // 最多20000元
public class RedPack {
    private int remainSize;
    private double remainMoney;
    public RedPack(int size, double money) {
        remainSize = size;
        remainMoney = money;
    }
    // 二倍均值法：每次抢的金额 = [0.01, 2 * (money / size))
    public double getRandomMoney() {
        if(remainSize == 1) {
            remainSize--;
            return (double) Math.round(remainMoney * 100) / 100;
        }
        Random rand = new Random();
        double min = 0.01;
        double max = (remainMoney / remainSize) * 2;
        double ret = rand.nextDouble() * max;
        ret = Math.max(ret, min);

        // 两种舍入均可
        //
        ret = Math.floor(ret * 100) / 100;
//        ret = (double) Math.round(ret * 100) / 100;
        remainSize--;
        remainMoney -= ret;
        return ret;
    }
}
