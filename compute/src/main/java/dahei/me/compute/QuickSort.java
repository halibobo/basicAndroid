package dahei.me.compute;

import java.util.Random;

/**
 * created by yubosu
 * 2018年10月12日10:34 AM
 */

/**
 * 快速排序
 */
public class QuickSort {
    static int times = 0;
    public static void qSort(int[] arr, int head, int tail) {

        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }
        int i = head, j = tail, pivot = arr[(head + tail) / 2];
        while (i <= j) {
            while (arr[i] < pivot) {
                times++;
                i++;
            }
            while (arr[j] > pivot) {
                times++;
                j--;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i++;
                j--;
                times++;
            } else if (i == j) {
                i++;
            }
        }
        qSort(arr, head, j);
        qSort(arr, i, tail);
    }

    /**
     * 鸡尾酒排序
     * @param arr
     */
    public static void cocktail_sort(int[] arr) {
        int times = 0;
        int i, left = 0, right = arr.length - 1;
        int temp;
        while (left < right) {
            for (i = left; i < right; i++)
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    times++;
                }
            right--;
            for (i = right; i > left; i--)
                if (arr[i - 1] > arr[i]) {
                    temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    times++;
                }
            left++;
        }
        System.out.println(" cocktail Times = " +  times);
    }

    /***
     * 冒泡排序
     */

    public static void bubbleSort(int[] arr) {
        int  bubbleTimes = 0;
        int temp;
        int index = arr.length - 1;
        for (int i = 0; i < arr.length ; i++) {
            boolean sort = true;
            int tempIndex = index;
            for (int j = 0; j < index; j++) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    sort = false;
                    tempIndex = j;
                }
                 bubbleTimes++;
            }
            index = tempIndex;
            if (sort) {
                break;
            }
        }
        System.out.println(" bubbleTimes = " +  bubbleTimes);
    }


    /***
     *堆排序
     * @param arr
     */
    public static void heapSort(int[] arr){
        /*
         *  第一步：将数组堆化
         *  beginIndex = 第一个非叶子节点。
         *  从第一个非叶子节点开始即可。无需从最后一个叶子节点开始。
         *  叶子节点可以看作已符合堆要求的节点，根节点就是它自己且自己以下值为最大。
         */
        int len = arr.length - 1;
        int beginIndex = (len - 1) >> 1;
        for(int i = beginIndex; i >= 0; i--){
            maxHeapify(arr,i, len);
        }

        /*
         * 第二步：对堆化数据排序
         * 每次都是移出最顶层的根节点A[0]，与最尾部节点位置调换，同时遍历长度 - 1。
         * 然后从新整理被换到根节点的末尾元素，使其符合堆的特性。
         * 直至未排序的堆长度为 0。
         */
        for(int i = len; i > 0; i--){
            swap(arr,0, i);
            maxHeapify(arr,0, i - 1);
        }
    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 调整索引为 index 处的数据，使其符合堆的特性。
     *
     * @param index 需要堆化处理的数据的索引
     * @param len 未排序的堆（数组）的长度
     */
    private static  void maxHeapify(int[] arr,int index,int len){
        int li = (index << 1) + 1; // 左子节点索引
        int ri = li + 1;           // 右子节点索引
        int cMax = li;             // 子节点值最大索引，默认左子节点。

        if(li > len) return;       // 左子节点索引超出计算范围，直接返回。
        if(ri <= len && arr[ri] > arr[li]) // 先判断左右子节点，哪个较大。
            cMax = ri;
        if(arr[cMax] > arr[index]){
            swap(arr,cMax, index);      // 如果父节点被子节点调换，
            maxHeapify(arr,cMax, len);  // 则需要继续判断换下后的父节点是否符合堆的特性。
        }
    }


    public static void main(String[] args) {
        System.out.println("quick sort");
        int[] arr = new int[5000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100000000);
        }
        testHeapSort(arr);
        testQuick(arr);
        testBubble(arr);
        testCocktail(arr);


    }

    private static void testQuick(int[] array) {
        int[] arr = array.clone();
        long start = System.currentTimeMillis();
        qSort(arr, 0, arr.length - 1);
        long end = System.currentTimeMillis();
        String out = "快速排序耗时：" + (end - start) + "ms  ";
        System.out.println("quick times" + times);
        System.out.println(out);
    }

    private static void testCocktail(int[] array) {
        int[] arr = array.clone();
        long start = System.currentTimeMillis();
        cocktail_sort(arr);
        long end = System.currentTimeMillis();
        String out = "鸡尾酒排序耗时：" + (end - start) + "ms  ";
        System.out.println(out);
    }

    private static void testBubble(int[] array) {
        int[] arr = array.clone();
        long start = System.currentTimeMillis();
        bubbleSort(arr);
        long end = System.currentTimeMillis();
        String out = "冒泡耗时："+(end-start)+"ms  ";
        System.out.println(out);
    }

    private static void testHeapSort(int[] array) {
        int[] arr = array.clone();
        long start = System.currentTimeMillis();
        heapSort(arr);
        long end = System.currentTimeMillis();
        String out = "堆排序耗时：" + (end - start) + "ms  ";
        System.out.println(out);
    }


}
