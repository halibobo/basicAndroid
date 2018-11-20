package dahei.me.compute;

/**
 * created by yubosu
 * 2018年10月23日2:46 PM
 */
public class STCompare {

    public static void main(String[] args) {
        System.out.println(backspaceCompare("123", "11#23"));
    }

    public static boolean backspaceCompare(String S, String T) {
        return getSplitStr(S).equals(getSplitStr(T));
    }

    public static String getSplitStr(String str) {
        if (!str.contains("#")) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (c == '#') {
                if (stringBuilder.length() > 0) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
            }else{
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

}
