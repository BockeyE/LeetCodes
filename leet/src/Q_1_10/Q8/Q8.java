package Q_1_10.Q8;

import java.math.BigInteger;

/**
 * @author bockey
 * 字符串变整数，先判断特殊情况，然后取符号，然后在int 范围内操作即可
 *
 *执行用时 :  7 ms  , 在所有 Java 提交中击败了  89.26%  的用户
 *内存消耗 :  36 MB  , 在所有 Java 提交中击败了  86.20%  的用户
 */
public class Q8 {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.startsWith("+-")) {
            return 0;
        }
        if (str.startsWith("+")) {
            str = str.substring(1);
        }
        if (str.isEmpty()) {
            return 0;
        }
        int start = 0;
        int end = str.length();
        if (!(str.charAt(0) == 45 || (str.charAt(0) >= 48 && str.charAt(0) <= 57))) {
            return 0;
        }
        for (int k = start + 1; k < str.length(); k++) {
            if (!(str.charAt(k) >= 48 && str.charAt(k) <= 57)) {
                end = k;
                break;
            }
        }
        String sub = str.substring(start, end);
        if (sub.length() == 1 && sub.equals("-")) {
            return 0;
        }

        try {
            int c = Integer.parseInt(sub);
            return c;
        } catch (Exception e) {
            if (sub.startsWith("-")) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
//- -45,0-48,9-57
    }

    public static void main(String[] args) {
        Q8 q = new Q8();
        System.out.println(q.myAtoi("+"));
        int c = '+';
        System.out.println("c :" + c);
    }
}
