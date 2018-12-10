package dahei.me.compute.exam.medium.java005;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * created by yubosu
 * 2018年12月07日6:18 PM
 */
public class Solution {


    public static boolean canReorderDoubled(int[] A) {

        int len = A.length;
        if (len == 0) {
            return true;
        }
        HashMap<String, String> map = new HashMap<>();
        int sum = 0;

        qSort(A, 0, len - 1);
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(String.valueOf(i))) {
                continue;
            }
            boolean success = false;
            for (int j = index; j < len; j++) {
                if (map.containsKey(String.valueOf(j))) {
                    continue;
                }
                if (i != j && A[j] == 2 * A[i]) {
                    map.put(String.valueOf(j), String.valueOf(i));
                    sum++;
                    index = j;
                    success = true;
                    break;
                } else if (i != j && A[j] * 2 == A[i]) {
                    map.put(String.valueOf(j), String.valueOf(i));
                    sum++;
                    index = j;
                    success = true;
                    break;
                }
            }
            if (!success) {
                return false;
            }
            if (sum >= len / 2) {
                return true;
            }
        }
        return false;
    }




    public static void bubbleSort(int[] arr) {
        int temp;
        int index = arr.length - 1;

        for (int i = 0; i < arr.length ; i++) {
            boolean sort = true;
            int tempIndex = index;
            for (int j = 0; j < index; j++) {
                if (Math.abs(arr[j]) > Math.abs(arr[j + 1]) || (arr[j + 1] < 0 && arr[j] == -arr[j + 1])) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    sort = false;
                    tempIndex = j;
                }
            }
            index = tempIndex;
            if (sort) {
                break;
            }
        }
    }


    public static void qSort(int[] arr, int head, int tail) {

        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }
        int i = head, j = tail, pivot =arr[(head + tail) / 2];

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i++;
                j--;
            } else if (i == j) {
                i++;
            }
        }
        qSort(arr, head, j);
        qSort(arr, i, tail);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(canReorderDoubled(new int[]{3, 1, 3, 6}));
        System.out.println(canReorderDoubled(new int[]{4, -2, 2, -4}));
        System.out.println(canReorderDoubled(new int[]{-6,2,-6,4,-3,8,3,2,-2,6,1,-3,-4,-4,-8,4}));
        System.out.println(canReorderDoubled(new int[]{2,1,2,6}));
        System.out.println(canReorderDoubled(new int[]{1,2,4,16,8,4}));
        System.out.println(canReorderDoubled(new int[]{-8,-4,-2,-1,0,0,1,2,4,8}));
        System.out.println(canReorderDoubled(new int[]{
                -62,86,96,-18,43,-24,-76,13,-31,-26,-88,-13,96,-44,9,-20,-42,100,
                -44,-24,-36,28,-32,58,-72,20,48,-36,-45,14,24,-64,-90,
                -44,-16,86,-33,48,26,29,-84,10,46,50,-66,-8,-38,92,-19
                ,43,48,-38,-22,18,-32,-48,-64,-10,-22,-48}));
        System.out.println(canReorderDoubled(new int[]{
                7,-15,-15,23,-3,80,-35,40,68
                ,22,44,98,20,0,-34,8,40,41,16
                ,46,16,49,-6,-11,35,-15,-74,72,
                -8,60,40,-2,0,-6,34,14,-16,-92,54,14,-68,82,-30,50,22,25,16,70,
                -1,-96,11,45,54,40,92,-35,29,80,46,-30,27,7,-70,-37,41,-46,-98,1,
                -33,-24,-86,-70,80,-43,98,-49,30,0,27,2,82,36,0,-48,3,-100,58,
                32,90,-22,-50,-12,36,6,-3,-66,72,8,49,-30}));

        System.out.println(canReorderDoubled(new int[]{
                -6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4,
                -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6,
                -6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4,
                -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6,
                -6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4,
                -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6,
                -6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4,
                -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6,
                -6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4,
                -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6,
                -6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4,
                -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6,
                -6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4,
                -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6,
                -6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4,
                -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6,
                -6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4,
                -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6,
                -6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4,
                -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6,
                -6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4,
                -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6,
                -6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4,
                -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6,
                -6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4,
                -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6,
                -6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4,
                -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6,
                -6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4,
                -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6,
                -6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4,
                -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6,
                -6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4,
                -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6,
                -6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4,
                -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6,
                -6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4,
                -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6,
                -6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4,
                -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6,
                -6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4,
                -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6,
                -6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4,
                -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6, 1, -3, -4, -4, -8, 4,-6, 2, -6, 4, -3, 8, 3, 2, -2, 6}));
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));

    }

    public boolean canReorderDoubled2(int[] A) {

        int len = A.length;
        if (len == 0) {
            return true;
        }
        qSort(A, 0, len - 1);
        int sum = 0;
        int index = 1;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len - 1; i++) {
            if (list.contains(i)) {
                continue;
            }
            for (int j = index; j < len; j++) {
                if (list.contains(j)) {
                    continue;
                }
                if (i != j && A[j] == 2 * A[i]) {
                    list.add(j);
                    list.add(i);
                    sum++;
                    if (Math.abs(A[j]) != Math.abs(A[j - 1])) {
                        index = j;
                    }
                    break;
                }

            }
            index = Math.max(index, i + 1);
            if (len / 2 + sum < i) {
                return false;
            }
            if (sum >= len / 2) {
                return true;
            }
        }
        return false;
    }

    public static boolean canReorderDoubled3(int[] A) {

        int len = A.length;
        if (len == 0) {
            return true;
        }
        HashMap<String, String> map = new HashMap<>();
        int sum = 0;
        int index = 1;
        bubbleSort(A);
        for (int i = 0; i < len; i++) {
            if (map.containsKey(String.valueOf(i))) {
                continue;
            }
            int tempIndex = 0;
            for (int j = index; j < len; j++) {
                if (map.containsKey(String.valueOf(j))) {
                    continue;
                }
                if (Math.abs(j) != Math.abs(j - 1)) {
                    tempIndex = j - 1;
                }
                if (i != j && A[j] == 2 * A[i]) {
                    map.put(String.valueOf(i), String.valueOf(j));
                    map.put(String.valueOf(j), String.valueOf(i));
                    sum++;
                    index = tempIndex;
                    break;
                }
            }
            index = Math.max(index, i);
            if (len / 2 + sum < i) {
                return false;
            }
            if (sum >= len / 2) {
                return true;
            }
        }
        return false;
    }
}
