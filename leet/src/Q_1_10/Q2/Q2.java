package Q_1_10.Q2;

/**
 * @author bockey
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Q2 {
//    执行用时 :5 ms, 在所有 Java 提交中击败了95.27% 的用户
//    内存消耗 :41.7 MB, 在所有 Java 提交中击败了93.73% 的用户
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int tempValue = 0;
        int promote = 0;
        tempValue = l1.val + l2.val;
        if (tempValue > 9) {
            promote = 1;
            tempValue = tempValue % 10;
        }
        ListNode res = new ListNode(tempValue);
        ListNode org = res;
        while (true) {
            tempValue = 0;
            if (l1.next == null && l2.next == null) {
                if (promote == 1) {
                    res.next = new ListNode(1);
                }
                break;
            }
            res.next = new ListNode(0);
            res = res.next;
            if (promote == 1) {
                res.val = 1;
            }
            if (l2.next == null) {
                l1 = l1.next;
                tempValue = l1.val;
            } else if (l1.next == null) {
                l2 = l2.next;
                tempValue = l2.val;
            } else {
                l1 = l1.next;
                l2 = l2.next;
                tempValue = l1.val + l2.val;
            }
            int sum = res.val + tempValue;
            if (sum > 9) {
                promote = 1;
                sum = sum % 10;
            } else {
                promote = 0;
            }
            res.val = sum;
        }
        return org;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        ListNode org1 = l1;
        l1.next = new ListNode(4);
        l1 = l1.next;
        l1.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        ListNode org2 = l2;
        l2.next = new ListNode(6);
        l2 = l2.next;
        l2.next = new ListNode(4);


        ListNode listNode = Q2.addTwoNumbers(org1, org2);

        System.out.println(listNode.val);
        System.out.println(listNode.next.val);
        System.out.println(listNode.next.next.val);
    }
    /**
     * 土思路解法
     * 先在外部计算一次，如果有进位，则promote量为1，否则为0.
     * 之后进入循环，循环里，最外部先判断l1l2是否都为null；如果是，再判断一下
     * promote是否进位，如果进位，则new一个节点1在最头上。
     * 这一步的意思是，在两个目标链都遍历完之后，这时候如果加和的结果有一个进位，那么首位需要多一位1，要考虑这种情况。
     *
     * 在非null时，也就是目标链至少有一个还有数字，则进入循环主内容部分，
     * new一个节点，如果有promote，则先把其基准值设为1.
     * 然后去l1或者l2，不为null的部分，加到tem中间量中，再加到节点值里。
     * 这里就分类判断不同情况即可，都有，或者只有一个链还有数字。
     *
     * 如果进位，则改变promote为1，然后取余数，设置结果即可，
     * 这样一个节点就设置完成，进入下一次循环
     */
}