package dahei.me.compute.exam.medium.java012;

import java.math.BigDecimal;
import java.util.HashSet;

/**
 * created by yubosu
 * 2019年01月31日2:58 PM
 */
public class Solution {

    public boolean judgePoint24(int[] nums) {
        HashSet<Double> hashSet = new HashSet<>();
        judgePoints(nums[0], nums[1], nums[2], nums[3], hashSet).contains(24d);
        for (Double d : hashSet) {
            if (Math.abs(d - 24) < 0.000000001) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        HashSet<Double> hashSet = new HashSet<>();
        judgePoints(4,1,8,7, hashSet);
        for (Double d : hashSet) {
            if (Math.abs(d - 24) < 0.000000001) {
                System.out.println("true");
            }
        }
    }


    private static HashSet<Double> judgePoints(int a, int b, int c, int d, HashSet<Double> hashSet) {
        hashSet.addAll(judgePoints(a, judgePoints(b, c, d)));
        hashSet.addAll(judgePoints(b, judgePoints(a, c, d)));
        hashSet.addAll(judgePoints(c, judgePoints(a, b, d)));
        hashSet.addAll(judgePoints(d, judgePoints(a, b, c)));

        hashSet.addAll(judgePoints(judgePoints(a, b), judgePoints(c, d)));
        hashSet.addAll(judgePoints(judgePoints(a, c), judgePoints(b, d)));

        hashSet.addAll(judgePoints(judgePoints(a, d), judgePoints(b, c)));

        return hashSet;
    }

    private static HashSet<Double> judgePoints(int i,int j,int n) {
        HashSet<Double> hashSet = new HashSet<>();

        for (Double inter : judgePoints(i, j)) {
            hashSet.addAll(judgePoints(inter, n));
        }
        for (Double inter : judgePoints(i, n)) {
            hashSet.addAll(judgePoints(inter, j));
        }
        for (Double inter : judgePoints(n, j)) {
            hashSet.addAll(judgePoints(inter, i));
        }

        return hashSet;
    }

    private static HashSet<Double> judgePoints(HashSet<Double> hashSet1, HashSet<Double> hashSet2) {
        HashSet<Double> hashSet = new HashSet<>();
        for (Double inter : hashSet1) {
            for (Double inter1 : hashSet2) {
                hashSet.addAll(judgePoints(inter, inter1));
            }
        }
        return hashSet;
    }

    private static HashSet<Double> judgePoints(int m, HashSet<Double> hashSet) {
        HashSet<Double> h = new HashSet<>();
        for (Double inter : hashSet) {
            h.addAll(judgePoints(m, inter));
        }
        return h;
    }

    private static HashSet<Double> judgePoints(double m, double n) {
        HashSet<Double> hashSet = new HashSet<>();
        hashSet.add(m + n);
        hashSet.add(m >= n ? m - n : n - m);
        hashSet.add(n * m);
        if (n != 0) {
            hashSet.add(m / n);
        }
        if (m != 0) {
            hashSet.add((n / m));
        }
        return hashSet;
    }

}

