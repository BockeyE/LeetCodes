package questions;

import java.util.ArrayList;

public class ReversList {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode head = a1;
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        a1.next = a2;
        a2.next = a3;
        while (a1 != null) {
            System.out.println(a1.val);
            a1 = a1.next;
        }
        a1 = ReverseList(head);
        System.out.println("ssss");
        System.out.println(a1);
        while (a1 != null) {
            System.out.println(a1.val);
            a1 = a1.next;
        }

    }


    public static ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ArrayList<ListNode> arr = new ArrayList<>();
        while (head != null) {
            arr.add(head);
            head = head.next;
        }
        ListNode newHead = arr.get(arr.size() - 1);
        ListNode pointer = arr.get(arr.size() - 1);
        if (arr.size() < 2) {
            return head;
        }
        for (int i = arr.size() - 2; i >= 0; i--) {
            pointer.next = arr.get(i);
            pointer = pointer.next;
        }
        pointer.next = null;
        return newHead;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

    }
}
