package dahei.me.compute.exam.medium.java008;


import java.util.HashMap;

/**
 * created by yubosu
 * 2018年12月11日2:26 PM
 */
public class Solution {

    public static int maxSubarraySumCircular(int[] A) {
        int len = A.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max = 0;
        int startPos = 0;
        int endPos = 0;
        for (int i = 0; i < len * 2; i++) {
            sum += A[i % len];//求和
            if (endPos - startPos == len + 1) {
                sum -= A[i - len];
            }
            if (sum < 0) {
                sum = 0;
                startPos = i + 1;
            }

            while (A[startPos] <= 0 && startPos < endPos) {
                sum = sum - A[startPos];
                startPos++;
            }

            if (sum > max) {
                max = sum;
                endPos = i + 1;
            }

        }
        return max;
    }

    public static void main(String[] args) {
//        System.out.println(maxSubarraySumCircular(new int[]{1,1,-1,3,-2,4,-1,2}));
//        System.out.println(smallestRangeI(new int[]{3, 2, 4, 2}, 1));
//        System.out.println(smallestRangeI(new int[]{3,2,4,2}, 1));
//        System.out.println(smallestRangeI(new int[]{7,8,8,5,2}, 4));
        System.out.println(smallestRangeI(new int[]{
                8038,9111,5458,8483,5052,9161,8368,2094,8366,9164,53,7222,9284,5059,4375,
                2667,2243,5329,3111,5678,5958,815,6841,1377,2752,8569,1483,9191,4675,6230,
                1169,9833,5366,502,1591,5113,2706,8515,3710,7272,1596,5114,3620,2911,8378,8012
                ,4586,9610,8361,1646,2025,1323,5176,1832,7321,1900,1926,5518,8801,679,3368,2086
                ,7486,575,9221,2993,421,1202,1845,9767,4533,1505,820,967,2811,5603,574,6920
                ,5493,9490,9303,4648,281,2947,4117,2848,7395,930,1023,1439,8045,5161,2315,5705
                ,7596,5854,1835,6591,2553,8628}, 4643)); //8870
    }

    public static int smallestRangeI(int[] A, int K) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int len = A.length;
        for (int i = 0; i < len; i++) {
            if (A[i] > max) {
                max = A[i];
            }
            if (A[i] < min) {
                min = A[i];
            }
        }
        if (max - min > 3 * K) {
            return max - min - 2 * K;
        }
        if (max - min <= K) {
            return max - min;
        }
        int newMax = Integer.MIN_VALUE;
        int newMin = Integer.MAX_VALUE;
        double medium = (min + max) / 2d;
        boolean hasEqual = false;
        for (int i = 0; i < len; i++) {
            if (A[i] < medium) {
                A[i] += K;
            }else if(A[i] > medium){
                A[i] -= K;
            }else{
                hasEqual = true;
            }
            if (A[i] > newMax) {
                newMax = A[i];
            }
            if (A[i] < newMin) {
                newMin = A[i];
            }
        }
        int diff = newMax - newMin;
        if (hasEqual) {
            if (newMax - medium < medium - newMin) {
                diff = newMax - Math.min((int) (medium - K), max);
            }else if(newMax - medium >= medium - newMin){
                diff = Math.max(newMax, (int) (medium + K)) - newMin;
            }
        }
        return Math.min(diff, max - min);
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
}