package Q_11_20.Q14;

/**
 * @author bockey
 */
public class Q14 {
//    执行用时 : 1 ms, 在所有 Java 提交中击败了99.89% 的用户
//    内存消耗 : 35.7 MB, 在所有 Java 提交中击败了89.08% 的用户
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String c = strs[0];
        for (int i = 0; i < strs.length; i++) {
            c = getCommonTwo(strs[i], c);
        }
        return c;
    }

    private String getCommonTwo(String s1, String s2) {
        if (s1.equals(s2)) return s1;
        int end = 0;
        while (end <= s1.length() - 1 && end <= s2.length() - 1) {
            if (s1.charAt(end) == s2.charAt(end)) {
                end++;
            } else {
                break;
            }
        }
        return s1.substring(0, end);
    }


    public static void main(String[] args) {
//        String[] ss = {"flower", "flow", "flight"};
        String[] ss = {"caa", "", "a", "acb"};
        System.out.println(new Q14().longestCommonPrefix(ss));
    }

}
