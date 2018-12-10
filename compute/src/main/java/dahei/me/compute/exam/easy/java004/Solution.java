package dahei.me.compute.exam.easy.java004;

import java.util.ArrayList;
import java.util.List;

/**
 * created by yubosu
 * 2018年12月07日6:18 PM
 */
public class Solution {

    public static boolean isAlienSorted(String[] words, String order) {
        int len = 0;
        for (String str : words) {
            if (str.length() > len) {
                len = str.length();
            }
        }
        for (int i = 0; i < len; i++) {
            int index = -1;
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < words.length; j++) {
                if (!list.isEmpty() && !list.contains(j)) {
                    continue;
                }
                int last = words[j].length() > i ? getWordIndex(words[j].charAt(i), order) : -1;
                if (last < index) {
                    return false;
                } else if (last == index) {
                    list.add(j - 1);
                    list.add(j);
                }
                index = last;
            }
            if (list.isEmpty()) {
                return true;
            }
        }

        return true;
    }

    private static int getWordIndex(char word,String order) {
        return order.indexOf(word);
    }

    public static void main(String[] args) {
        System.out.println(isAlienSorted(new String[]{"hello","leetcode"},  "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(isAlienSorted(new String[]{"word","world","row"},  "worldabcefghijkmnpqstuvxyz"));
        System.out.println(isAlienSorted(new String[]{"xpzurqpjimcqjp","cpoymyvqrrkw","jhvxpqgq",
                "escrktgzqpoze","tamdkoyacprfyj",
                "tcgkdjerydm","czhzgfcvrmudxd",
                "qwbegrhcavi","yvluklzflkjq","pwawsolwzognjx"},  "xchaiwgovseknjuztmrydflqbp"));
    }
}
