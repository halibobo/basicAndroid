package dahei.me.compute.exam.medium.java013;

/**
 * created by yubosu
 * 2019年01月31日5:46 PM
 */
public class Solution {
    public int numberOfArithmeticSlices(int[] A) {

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(getArithmeticSize(5, 0));

    }

    static int size = 0;

    public static int getArithmeticSize(int len, int count) {
        size++;
        int temp = len / size;
        int y = len % temp;
        if (temp >= 3) {
            count += getArithmeticSize(len / 2, count);
        }

        if (len >= 3) {
            count += (len - 2) * (len - 1) / 2;
            if (count % 2 == 0) {
                count += getArithmeticSize(len / 2, count);
            } else {

            }
        } else {
            return count;
        }
        return 0;
    }
}
