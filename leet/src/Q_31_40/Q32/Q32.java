package Q_31_40.Q32;

import java.util.Stack;

/**
 * @author bockey
 * 与找到每个可能的子字符串后再判断它的有效性不同，我们可以用栈在遍历给定字符串的过程中去判断到目前为止扫描的子字符串的有效性，
 * 同时能的都最长有效字符串的长度。我们首先将 -1 放入栈顶。
 * <p>
 * 对于遇到的每个 ‘(’ ，我们将它的下标放入栈中。
 * 对于遇到的每个 ‘)’ ，我们弹出栈顶的元素并将当前元素的下标与弹出元素下标作差，得出当前有效括号字符串的长度。通过这种方法，
 * 我们继续计算有效子字符串的长度，并最终返回最长有效子字符串的长度。
 *
 *
 * 执行用时 : * 8 ms * , 在所有 java 提交中击败了 * 43.67% * 的用户
 * 内存消耗 : * 37.1 MB * , 在所有 java 提交中击败了 * 85.01% * 的用户
 */
public class Q32 {

    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
//        新建一个栈，添加一个-1作为底
        for (int i = 0; i < s.length(); i++) {
//            0-lenth遍历，如果是 （ 就压入
            if (s.charAt(i) == '(') stack.push(i);
            else {
//                如果是 ） 就弹出
                stack.pop();
//                如果 此时-1已经被弹出了，就压入当前的i
                if (stack.empty()) {
                    stack.push(i);
                } else {
//                    如果不是，则把当前的长度与lenth计算后再与max比较
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

}
