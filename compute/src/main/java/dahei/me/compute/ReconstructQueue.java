package dahei.me.compute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * created by yubosu
 * 2018年10月21日3:20 PM
 */
public class ReconstructQueue {


    public static int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                int[] first = (int[]) o1;
                int[] second = (int[]) o2;
                if (first[0] > second[0]) {
                    return -1;
                } else if (first[0] < second[0]) {
                    return 1;
                } else {
                    if (first[1] > second[1]) {
                        return 1;
                    } else if (first[1] < second[1]) {
                        return -1;
                    } else return 0;
                }

            }
        });

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            list.add(people[i][1], people[i]);
        }
        int[][] res = new int[people.length][2];
        for(int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] a = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] array = reconstructQueue(a);
        for (int i = 0; i < array.length; i++) {
            System.out.print( ",[" + array[i][0] + "," + array[i][1] + "]");
        }
    }

}
