package Q_21_30.Q29;

/**
 * @author bockey
 * <p>
 * 执行用时 : * 2 ms * , 在所有 java 提交中击败了 * 68.63% * 的用户
 * 内存消耗 : * 33.8 MB * , 在所有 java 提交中击败了 * 76.25% * 的用户
 */
public class Q29 {
    public int divide(int dividend, int divisor) {
//        判断为负数的情况
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;
        if (divisor == Integer.MIN_VALUE && dividend == Integer.MIN_VALUE) return 1;
        if (divisor == Integer.MIN_VALUE) return 0;
        boolean isMinus = false;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) isMinus = true;
        int ret = 0;
        if (dividend == Integer.MIN_VALUE) {
            dividend = dividend + (divisor > 0 ? divisor : (0 - divisor));
            ret++;
        }
        if (dividend < 0) dividend = (0 - dividend);
        if (divisor < 0) divisor = (0 - divisor);
//        if (dividend < divisor) return ret;
        int movep = 0;
        int originDivisor = divisor;
        //这里用移位操作提升速度，如果x2（左移）依然小于被除数，则可以移动，缩小被除数计算的次数
        while (divisor << 1 < dividend && divisor << 1 > 0) {
            divisor = divisor << 1;
            movep++;
        }
        while (dividend >= divisor) {
            dividend -= divisor;
            int time = 1 << movep;
            ret += time;
            while (divisor > dividend && movep > 0) {
                divisor = divisor >> 1;
                movep--;
            }
            if (dividend == 0) break;
        }
        if (isMinus) ret = 0 - ret;
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Q29().divide(Integer.MAX_VALUE, 1));
//        System.out.println(1 << 3);
    }
}
