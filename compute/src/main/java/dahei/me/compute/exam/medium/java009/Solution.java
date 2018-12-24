package dahei.me.compute.exam.medium.java009;

/**
 * created by yubosu
 * 2018年12月24日3:15 PM
 */
public class Solution {

    public static boolean isPalindrome(String s) {
        char[] chars = s.trim().toLowerCase().toCharArray();
        int start = 0;
        int end = chars.length - 1;
        for (; start < end; start++, end--) {
            while (!isValidChar(chars[start])) {
                start++;
                if (start > end) {
                    break;
                }
            }
            while (!isValidChar(chars[end])) {
                end--;
                if (start > end) {
                    break;
                }
            }
            if (end < start) {
                return true;
            }
            if (chars[start] != chars[end]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidChar(char c) {
        int ascCode = (int) c;
        return ascCode <= 122 && ascCode >= 97 || (ascCode <= 90 && ascCode >= 65) ||  (ascCode <= 57 && ascCode >= 48) ;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
        System.out.println(isPalindrome(".,"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

}
