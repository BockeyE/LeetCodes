package Q_1_10.Q5;

import java.util.List;

/**
 * @author bockey
 */
public class Q5 {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        String res = "";
        String tem = "";
        for (int i = 1; i < chars.length - 1; i++) {
            char a = chars[i - 1];
            char b = chars[i];
            char c = chars[i + 1];
            if (a == b) {
                tem = getSub(chars, i - 1, i);
                if (tem.length() > res.length()) {
                    res = tem;
                }
            } else if (a == c) {
                tem = getSub(chars, i - 1, i + 1);
                if (tem.length() > res.length()) {
                    res = tem;
                }
            }
        }
        return res;
    }

    String getSub(char[] chars, int i, int j) {
        while (i >= 0 && j <= chars.length - 1) {
            char t1 = chars[i];
            char t2 = chars[j];

            if (t1 == t2) {
                i--;
                j++;
            } else {
                break;
            }
        }
        i = (i + 1);
        String res2 = String.copyValueOf(chars, i, (j - i ));
        return res2;

    }

    public static void main(String[] args) {
        Q5 q = new Q5();
        String s = q.longestPalindrome("a");
        System.out.println(s);
    }

}
