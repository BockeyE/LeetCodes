package Q_1_10.Q7;

/**
 * @author bockey
 */
public class Q7 {

    public int reverse(int x) {
        if (x == Integer.MAX_VALUE || x == Integer.MIN_VALUE) {
            return 0;
        }
        if (x < 0) {
            return -mainact(-x);
        }
        return mainact(x);
    }

    int mainact(int x) {
        int t = 0;
        int head = 0;
        while (x != 0) {
            head = x % 10;
            x /= 10;
            //这里的判断，第一个，判断max容易理解
            //第二个，实际上是在判断末位数字，int 正数极大值是2147483647
            //也就是说，在需要执行第二步判断时，已经到了t=214748364，此时只剩最后一个数字，这个数字必须<=7
            //实际上java程序是不会走到这里的，因为输入的数字，在java里不会输入成7463xxxx，但是其他语言没有这个限制，因此要在这里做限制
            if (t > Integer.MAX_VALUE / 10 || (t == Integer.MAX_VALUE / 10 && head >= 7)) {
                return 0;
            }
            t *= 10;
            t += head;
        }
        return t;
    }

    public static void main(String[] args) {
        Q7 q = new Q7();
        int c = -2147483648;
        System.out.println(c);

        int reverse = q.reverse(-2147483648);
        System.out.println(reverse);
    }

}
