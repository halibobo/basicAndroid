package dahei.me.compute.test;



import java.util.HashMap;

/**
 * created by yubosu
 * 2018年12月14日5:11 PM
 */
// TODO: 2018/12/19
public class TestLinkLoop {
    public static boolean hasLoop(Node n){
        //定义两个指针tmp1,tmp2
        Node tmp1 = n;
        Node tmp2 = n.next;
        int count = 0;
        while (tmp2 != null) {
            tmp1 = tmp1.next;  //每次迭代时，指针1走一步，指针2走两步
            tmp2 = tmp2.next.next;
            count++;
            if (tmp2 == null) return false;//不存在环时，退出
            int d1 = tmp1.val;
            int d2 = tmp2.val;
            if (d1 == d2) break;//当两个指针重逢时，说明存在环，否则不存在。

        }
        System.out.println("count1=" + count);
        return true; //如果tmp2为null，说明元素只有一个，也可以说明是存在环
    }

    //方法2：将每次走过的节点保存到hash表中，如果节点在hash表中，则表示存在环
    public static boolean hasLoop2(Node n){
        Node temp1 = n;
        HashMap<Node, Integer> ns = new HashMap<>();
        int count = 0;
        while (temp1 != null) {
            count++;
            if (ns.get(temp1) != null) {
                System.out.println("count2=" + count);
                return true;
            } else {
                ns.put(temp1, 1);
            }
            temp1 = temp1.next;
            if (temp1 == null) return false;
        }
        return true;
    }

    private static void testArray(int[] array, Node node) {

        long start = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
        }
        long end1 = System.currentTimeMillis();
        Node n = node;
        while (n != null) {
            n = n.next;
        }
        long end2 = System.currentTimeMillis();
        System.out.println("n1 = " + (end1 - start) + "\nn2 = " + (end2 - end1));
    }

    private static Node addTestNode(Node node) {
        int i = 0;
        Node n = node;
        while (n.val < 1000000) {
            Node node1 = new Node(i);
            n.next = node1;
            n = node1;
            i++;
        }
        return n;
    }



    public static void main(String[] args) {
        Node n1 = new Node(-1);
        Node n2 = new Node(-2);
        Node n3 = new Node(-3);
        n1.next = n2;
        n2.next = n3;
        Node node4 = addTestNode(n3);
        node4.next = n2;

//        int[] array = new int[1000000];
//        for (int i = 0; i < array.length; i++) {
//            array[i] = i;
//        }
//        testArray(array, n1);

        long start = System.currentTimeMillis();
        System.out.println(hasLoop(n1));
        long end1 = System.currentTimeMillis();
        System.out.println(hasLoop2(n1));
        long end2 = System.currentTimeMillis();
        System.out.println("n1 = " + (end1 - start) + "\nn2 = " + (end2 - end1));

    }
}
