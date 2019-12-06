package Q_11_20.Q20;

import java.util.Stack;

/**
 * @author bockey
 * <p>
 * 执行用时 : * 2 ms * , 在所有 java 提交中击败了 * 95.37% * 的用户
 * 内存消耗 : * 34 MB * , 在所有 java 提交中击败了 * 88.10% * 的用户
 */
public class Q20 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == ']' && !stack.empty()) {
                if (stack.peek().equals('[')) {
                    stack.pop();
                    continue;
                }
            }
            if (c == (')') && !stack.empty()) {
                if (stack.peek().equals('(')) {
                    stack.pop();
                    continue;
                }
            }
            if (c == ('}') && !stack.empty()) {
                if (stack.peek().equals('{')) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(new Q20().isValid("(})"));
    }
}
