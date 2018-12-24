package dahei.me.compute.exam.medium.java010;

import java.util.HashMap;

/**
 * created by yubosu
 * 2018年12月24日3:50 PM
 */
public class Solution {
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        HashMap<Integer, ListNode> hashMap = new HashMap<>();
        int index = 0;
        ListNode temp = head;
        hashMap.put(index, temp);
        while (temp.next != null) {
            index++;
            temp = temp.next;
            hashMap.put(index, temp);
        }
        int startIndex = index - n;
        if (startIndex < 0) {
            return head.next;
        }else if(n == 1){
            hashMap.get(startIndex).next = null;
            return head;
        }else{
            hashMap.get(startIndex).next = hashMap.get(startIndex).next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int n = 2;
        ListNode l = new ListNode(1);
        while (l.val < 10) {
            ListNode listNode1 = new ListNode(n);
            listNode1.next = l;
            l = listNode1;
            n++;
        }
        System.out.println(removeNthFromEnd(l, 3));
        System.out.println("over");
    }
}
