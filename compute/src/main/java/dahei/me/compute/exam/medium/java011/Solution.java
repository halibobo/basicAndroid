package dahei.me.compute.exam.medium.java011;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by yubosu
 * 2019年01月07日2:21 PM
 */
public class Solution {

    public static int[] numsSameConsecDiff(int N, int K) {

        if (N == 1) {
            list.add(0);
        }
        for (int i = 1; i <= 9; i++) {
            addDigital(Arrays.asList(i), N, K);
        }

        int[] arrs = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arrs[i] = list.get(i);
        }
        return arrs;
    }

    private static List<Integer> list = new ArrayList<>();

    private static void addDigital(List<Integer> starts, int N, int k) {
        if (starts.size() == N) {
            int num = 0;
            for (int i = 1; i <= N; i++) {
                num += starts.get(i-1) * Math.pow(10, N - i);
            }
            list.add(num);
        }else{
            int last = starts.get(starts.size() - 1);
            if (last + k < 10) {
                List<Integer> list1 = new ArrayList<>();
                list1.addAll(starts);
                list1.add(last + k);
                addDigital(list1, N, k);
            }
            if (k !=0 && last - k >= 0) {
                List<Integer> list2 = new ArrayList<>();
                list2.addAll(starts);
                list2.add(last - k);
                addDigital(list2, N, k);
            }
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        numsSameConsecDiff(9, 3);
        long end = System.currentTimeMillis();
        System.out.println("数组耗时：" + (end - start));
        numsSameConsecDiff2(9, 3);
        long end2 = System.currentTimeMillis();
        System.out.println("字符串耗时：" + (end2 - end));
    }


    public static int[] numsSameConsecDiff2(int N, int K) {

        if (K == 0 && N == 1) {
            list2.add(0);
        }
        for (int i = 1; i <= 9; i++) {
            addDigital2(String.valueOf(i), N, K);
        }
        int[] arrs = new int[list2.size()];
        for (int i = 0; i < list2.size(); i++) {
            arrs[i] = list2.get(i);
        }
        return arrs;
    }

    private static List<Integer> list2 = new ArrayList<>();

    private static void addDigital2(String starts, int N, int k) {
        if (starts.length() == N) {
            list2.add(Integer.parseInt(starts));
        }else{
            int last = (int) (starts.charAt(starts.length() - 1)) - 48;
            if (last + k < 10) {
                addDigital2(starts + String.valueOf(last + k), N, k);
            }
            if (k != 0 && last - k >= 0) {
                addDigital2(starts + String.valueOf(last - k), N, k);
            }
        }
    }


}
