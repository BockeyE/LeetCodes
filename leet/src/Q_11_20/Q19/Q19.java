package Q_11_20.Q19;


/**
 * @author bockey
 *
 *
 * 执行用时 : * 0 ms * , 在所有 java 提交中击败了 * 100.00% * 的用户
 * 内存消耗 : * 35 MB * , 在所有 java 提交中击败了 * 86.66% * 的用户
 */
public class Q19 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //    这个题目要找倒数第n个节点，单向遍历的话，就直接做一个n+1长度的尺子，当一头走到最后时，另一头就正好在位置上
//    在代码中就是使用一个双指针实现即可
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode origin = new ListNode(0);
        origin.next = head;
        ListNode first = origin;
        ListNode second = origin;

        for (int i = 0; i <= n ; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return origin.next;
    }

    public static void main(String[] args) {

    }


}
