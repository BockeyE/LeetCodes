package Q_1_10.Q9;

import java.math.BigInteger;

/**
 * @author bockey
 * 判断回文数字，取余法倒转数字，然后自身比较即可
 */
public class Q9 {
//    执行用时 : 12 ms, 在所有 Java 提交中击败了98.08% 的用户
//    内存消耗 : 37.7 MB, 在所有 Java 提交中击败了86.41% 的用户

    public boolean isPalindrome(int x) {
//        2147483647  2147447412
        if (x < 0 || x > 2147447412) {
            return false;
        }
        int orig = x;
        int t = 0;
        int ret = 0;
        while (x > 0) {
            t = x % 10;
            x = x / 10;
            ret = ret * 10;
            ret = ret + t;
        }
        return ret == orig;
    }

    public static void main(String[] args) {
        System.out.println(new Q9().isPalindrome(2333));
    }
}
