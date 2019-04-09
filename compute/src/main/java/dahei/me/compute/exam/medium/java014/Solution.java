package dahei.me.compute.exam.medium.java014;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * created by yubosu
 * 2019年01月31日5:46 PM
 */
public class Solution {
    public static String longestPalindrome(String s) {
        if(s.length() == 1||s.length() == 0){
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        sb = sb.reverse();
        char[] aChars = s.toCharArray();
        char[] bChars = sb.toString().toCharArray();
        int zlastIndex = 0;
        int zlastLen = 0;
        int zcurIndex = -1;

        int flastIndex = 0;
        int flastLen = 0;
        int fcurIndex = -1;
        int len = aChars.length;
        for(int i=0;i<len;i++){
            zcurIndex = -1;
            fcurIndex = -1;
            for(int j=i;j<len;j++){
                if(bChars[j-i] == aChars[j]){
                    if(fcurIndex == -1){
                        fcurIndex = j;
                    }else if(j == len-1){
                        if (j - fcurIndex >= 1) {
                            if (j - fcurIndex > flastLen) {
                                flastLen = j - fcurIndex + 1;
                                flastIndex = fcurIndex;
                            }
                        }
                    }
                }else{
                    if(fcurIndex != -1 && j-fcurIndex >=2){
                        if (j - fcurIndex > flastLen) {
                            flastLen = j - fcurIndex;
                            flastIndex = fcurIndex;
                        }
                    }
                    fcurIndex = -1;
                }

                if(aChars[j-i] == bChars[j]){
                    if(zcurIndex == -1){
                        zcurIndex = j-i;
                    }else if(j == len-1){
                        if (j - zcurIndex >= 1) {
                            if (j - zcurIndex > zlastLen) {
                                zlastLen = j - i  - zcurIndex + 1;
                                zlastIndex = zcurIndex;
                            }
                        }
                    }
                }else{
                    if (zcurIndex != -1 && j - zcurIndex >= 2) {
                        if (j - zcurIndex > zlastLen) {
                            zlastLen = j - i - zcurIndex;
                            zlastIndex = zcurIndex;
                        }
                    }
                    zcurIndex = -1;
                }
            }
        }

        System.out.println("zlastLen="+zlastLen);
        System.out.println("flastLen="+flastLen);
        System.out.println("flastIndex="+flastIndex);
        System.out.println("zlastIndex="+zlastIndex);

        if(zlastLen <2 && flastLen < 2){
            return s.substring(0, 1);
        }
        if(zlastLen >= flastLen){
            return s.substring(zlastIndex, zlastIndex+zlastLen);
        }else{
            return s.substring(flastIndex, flastIndex+flastLen);
        }

    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.length()<=1){
            return s.length();
        }
        int start = 0;
        int end =0 ;
        int sum = 0;
        char[] chars = s.toCharArray();
        int len = chars.length;
        for(int i=0;i<len;i++){
            OUT:
            for(int j = i;j<len;j++){
                for(int c=i;c<j;c++){
                    if(chars[c] == chars[j]){
                        sum = j - i > sum ? j-i : sum;
                        break OUT;
                    }
                }
                if(j == len-1){
                    sum = j -i+1 > sum ? j-i+1 : sum;
                }
            }
        }
        return sum;
    }

    @TargetApi(Build.VERSION_CODES.N)
    public static String largestNumber(int[] num) {
        if (num.length == 0) {
            return "";
        }
        if (num.length == 1) {
            return Integer.toString(num[0]);
        }
        String[] str = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            str[i] = Integer.toString(num[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Long.parseLong(o1 + o2) > Long.parseLong(o2 + o1) ? 1 : -1;
            }
        });
        StringBuilder sb = new StringBuilder("");
        for (int i = num.length - 1; i >= 0; i--) {
            sb.append(str[i]);
        }
        if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }

    public static void bubbleSort(int[] arr) {
        int temp;
        int index = arr.length - 1;
        for (int i = 0; i < arr.length ; i++) {
            boolean sort = true;
            int tempIndex = index;
            for (int j = 0; j < index; j++) {
                if (Long.parseLong(arr[j] + "" + arr[j + 1]) < Long.parseLong(arr[j + 1] + "" + arr[j])) {
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

    @TargetApi(Build.VERSION_CODES.N)
    public static void main(String[] args) {
//        System.out.println(longestPalindrome("aacdefcaa"));
        System.out.println(lengthOfLongestSubstring("aacdefcaa")+"");
        System.out.println(lengthOfLongestSubstring("aab")+"");
        System.out.println(largestNumber(new int[]{3,1,22,4}));
    }

}
