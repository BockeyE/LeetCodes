package Q_150plus;


/**
 *
 * 执行用时：1 ms, 在所有 Java 提交中击败了96.63% 的用户
 * 内存消耗：35.1 MB, 在所有 Java 提交中击败了89.10% 的用户
 *
 *
 *
 * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 * <p>
 * 示例 1：
 * <p>
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 */
public class JZOffer15 {

    public static void main(String[] args) {

        System.out.println(hammingWeight(6));

    }

    public static int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            n = n & (n - 1);
            ret++;
        }
        return ret;
    }

}
