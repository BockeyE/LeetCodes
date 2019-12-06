package Q_21_30.Q23;


/**
 * @author bockey
 * <p>
 * 两两合并即可
 *
 * 执行用时 : * 6 ms * , 在所有 java 提交中击败了 * 68.56%% * 的用户
 * 内存消耗 : * 43.7  MB * , 在所有 java 提交中击败了 * 59.57% * 的用户
 *
 */
public class Q23 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
//12345，15，24，3

    public ListNode mergeKLists(ListNode[] lists) {
        int lenth = lists.length;
        if (lenth == 0) return null;

        while (lenth > 1) {
            for (int i = 0; i < lenth; i++) {
                if (i != (lenth - 1 - i)) lists[i] = mergeTwoLists(lists[i], lists[lenth - 1 - i]);
            }
            lenth = (lenth + 1) / 2;
        }
        return lists[0];
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

        for (int i = 0; i < 10; i++) {
            System.out.println(i + "" + (10 - i - 1));

        }

    }
}
