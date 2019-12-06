package Q_21_30.Q21;


/**
 * @author bockey
 * <p>
 * 执行用时 : * 1 ms * , 在所有 java 提交中击败了 * 84.34% * 的用户
 * 内存消耗 : * 35.8 MB * , 在所有 java 提交中击败了 * 87.69% * 的用户
 */
public class Q21 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        ListNode res = new ListNode(0);
        ListNode orgin = res;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                res.next = new ListNode(l2.val);
                l2 = l2.next;
                res = res.next;
            } else {
                res.next = new ListNode(l1.val);
                l1 = l1.next;
                res = res.next;
            }
        }
        ListNode rest = l2 == null ? l1 : l2;
        while (rest != null) {
            res.next = rest;
            res = res.next;
            rest = rest.next;
        }
        return orgin.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new Q21.ListNode(-9);
        ListNode l2 = new Q21.ListNode(3);
//        ListNode l3 = new Q21.ListNode(4);
        ListNode l4 = new Q21.ListNode(5);
        ListNode l5 = new Q21.ListNode(7);
        ListNode l6 = new Q21.ListNode(9);
        l1.next = l2;
//        l2.next = l3;
        l4.next = l5;
        l5.next = l6;
        ListNode node = new Q21().mergeTwoLists(l1, l4);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }
}
