package Q_1_10.Q8;

import java.math.BigInteger;

/**
 * @author bockey
 */
public class Q8 {
    public int myAtoi(String str) {
        str = str.trim();
        if(str.startsWith("+-")){
            return 0;
        }
        if (str.startsWith("+")) {
            str = str.substring(1);
        }
        if (str.isEmpty()) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int start = 0;
        int end = chars.length;
        if (!(chars[0] == 45 || (chars[0] >= 48 && chars[0] <= 57))) {
            return 0;
        }
        for (int k = start + 1; k < chars.length; k++) {
            if (!(chars[k] >= 48 && chars[k] <= 57)) {
                end = k;
                break;
            }
        }
        String sub = str.substring(start, end);
        if (sub.length() == 1 && sub.equals("-")) {
            return 0;
        }
        BigInteger b = new BigInteger(sub);
        BigInteger zero = new BigInteger("0");
        BigInteger max = new BigInteger(Integer.MAX_VALUE + "");
        BigInteger min = new BigInteger(Integer.MIN_VALUE + "");
        if (b.compareTo(zero) == 1 && b.compareTo(max) == 1) {
            return Integer.MAX_VALUE;
        }
        if (b.compareTo(zero) == -1 && b.compareTo(min) == -1) {
            return Integer.MIN_VALUE;
        }
        return b.intValue();
//- -45,0-48,9-57
    }

    public static void main(String[] args) {
        Q8 q = new Q8();
        System.out.println(q.myAtoi("+"));
        int c = '+';
        System.out.println("c :" + c);
    }
}
