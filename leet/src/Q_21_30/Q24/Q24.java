package Q_21_30.Q24;

/**
 * @author bockey
 *
 * 执行用时 : * 0 ms * , 在所有 java 提交中击败了 * 100.00% * 的用户
 * 内存消耗 : * 34.2 MB * , 在所有 java 提交中击败了 * 87.11% * 的用户
 *
 *
 */
public class Q24 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

}
