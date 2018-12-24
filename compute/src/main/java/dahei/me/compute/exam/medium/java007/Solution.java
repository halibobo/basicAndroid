package dahei.me.compute.exam.medium.java007;

import java.util.ArrayList;
import java.util.List;

/**
 * created by yubosu
 * 2018年12月11日1:51 PM
 */
public class Solution {

    public static String reverseOnlyLetters(String S) {

        StringBuilder sb = new StringBuilder();
        char[] chars = S.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            int ascCode = (int) chars[i];
            if (ascCode > 122 || ascCode < 65 || (ascCode < 97 && ascCode > 90)) {
                list.add(i);
            }
        }
        for (int i = chars.length - 1; i >= 0; i--) {

            int ascCode = (int) chars[i];
            if (ascCode <= 122 && ascCode >= 97 || ascCode <= 90 && ascCode >= 65) {
                sb.append(chars[i]);
            }
            while (list.contains(sb.length())) {
                sb.append(chars[sb.length()]);
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        System.out.println(reverseOnlyLetters("qwe--qweqe"));
        System.out.println(reverseOnlyLetters("z<*zj***"));
        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
