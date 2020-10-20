package Q_140_149.Q143;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class Q143 {


    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode zero = head;
        LinkedList<ListNode> copy = new LinkedList<>();
        int i = 1;
        int count = 0;
        while (head.next != null) {
            head = head.next;
            copy.addLast(head);
            count++;
        }
        while (i <= count) {
            if (i % 2 == 0) {
                zero.next = copy.removeFirst();
            } else {
                zero.next = copy.removeLast();
            }
            zero = zero.next;
            i++;
        }
        zero.next = null;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode n4 = new ListNode(5);

        ListNode n3 = new ListNode(4, n4);

        ListNode n2 = new ListNode(3, n3);

        ListNode n1 = new ListNode(2, n2);

        ListNode n0 = new ListNode(1, n1);

        new Q143().reorderList(n0);
        System.out.println(">>>>>>>>");
//        while (n0.next != null) {
//            System.out.println(n0.val);
//            n0 = n0.next;
//        }
//        System.out.println(n0.val);

    }
}
