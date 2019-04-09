package dahei.me.compute.exam.medium.java002;


/**
 * created by yubosu
 * 2018年12月07日3:07 PM
 */
public class Solution {

    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int len = grid.length;
        int rowLen = grid[0].length;
        int[] grade = new int[len];
        int[] row = new int[rowLen];
        for (int i = 0; i < len; i++) {
            int max = grid[i][0];
            for (int j = 1; j < rowLen; j++) {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
            grade[i] = max;
        }

        for (int i = 0; i < rowLen; i++) {
            int max = grid[0][i];
            for (int j = 1; j < len; j++) {
                if (grid[j][i] > max) {
                    max = grid[j][i];
                }
            }
            row[i] = max;
        }

        int sum = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < rowLen; j++) {
                int min = Math.min(grade[i], row[j]);
                if(grid[i][j] < min) {
                    sum += (Math.min(grade[i], row[j]) - grid[i][j]);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        int[][] grid = new int[][]{
                {3, 0, 8, 4},
                {2, 4, 5, 7},
                {9, 2, 6, 3},
                {0, 3, 1, 0}};

        System.out.println(maxIncreaseKeepingSkyline(grid));
    }

}
