package Q_1_10.Q10;

/**
 * @author bockey
 */
public class Q10 {
//    执行用时 : 145 ms, 在所有 Java 提交中击败了36.94%    的用户
//    内存消耗 : 100.1 MB, 在所有 Java 提交中击败了5.03%    的用户

    public boolean isMatch(String s, String pattern) {

//        如果模式串中有星号，它会出现在第二个位置，
//        即pattern[1] 。
//        这种情况下，我们可以直接忽略模式串中这一部分，
//        或者删除匹配串的第一个字符，前提是它能够匹配模式串当前位置字符，
//        即 pattern[0] 。
//        如果两种操作中有任何一种使得剩下的字符串能匹配，
//        那么初始时，匹配串和模式串就可以被匹配。


//        先判断是否为空，
        if (pattern.isEmpty()) return s.isEmpty();
//        第一步匹配结果，不为空且首位字符匹配
        boolean first_match = (!s.isEmpty() &&
                (pattern.charAt(0) == s.charAt(0) || pattern.charAt(0) == '.'));
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return (isMatch(s, pattern.substring(2)) ||
                    //        后续匹配结果，长度2以上，且为*时，直接递归匹配，以第三个字符开始的pattern

                    (first_match && isMatch(s.substring(1), pattern)));
        } else {
            return first_match && isMatch(s.substring(1), pattern.substring(1));
        }
    }

    public static void main(String[] args) {

        System.out.println(new Q10().isMatch("aba", "ab*.c"));
    }
}

//"aaba"
//        "ab*a*c*a"