package Q_150plus;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，
 * 请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 *
 * 执行用时：1 ms, 在所有 Java 提交中击败了99.81% 的用户
 * 内存消耗：38.9 MB, 在所有 Java 提交中击败了96.52% 的用户
 */

public class Q203 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(7, l1);
        ListNode l3 = new ListNode(7, l2);

        removeElements(l3, 7);
        System.out.println(l3.val);
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head.val == val ? null : head;
        }

        ListNode cur = head.next;
        ListNode prev = head;
        while (cur != null) {
            if (cur.val == val) {
                removeCurrent(prev, cur);
                cur = prev.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        if (head.val == val) {
            return head.next;
        }
        return head;
    }

    static void removeCurrent(ListNode prev, ListNode cur) {
        if (cur != null) {
            prev.next = cur.next;
        }
    }


}

class ListNode {
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