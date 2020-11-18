package Q_150plus;

/**
 * 执行用时：1 ms, 在所有 Java 提交中击败了86.83% 的用户
 * 内存消耗：36.4 MB, 在所有 Java 提交中击败了93.14% 的用户
 **/
public class Q925 {
    public boolean isLongPressedName(String name, String typed) {
        if (name == null || typed == null) {
            return false;
        }
        if (name.length() > typed.length()) {
            return false;
        }
        if (name.length() == typed.length() && name.equals(typed)) {
            return true;
        }
        int n = 0;
        int t = 0;
        while (n < name.length()) {
            int repeatCount = 0;
            while (t < typed.length() && name.charAt(n) == typed.charAt(t)) {
                t++;
                repeatCount++;
            }
            n++;
            repeatCount--;

            while (n < name.length() && name.charAt(n) == name.charAt(n - 1)) {
                n++;
                repeatCount--;
            }
            if (repeatCount < 0) {
                return false;
            }
            if (n >= name.length()) {
                break;
            }
            if (t >= typed.length()) {
                return false;
            }
            if (name.charAt(n) != typed.charAt(t)) {
                return false;
            }
        }
        while (t < typed.length() && typed.charAt(t) == name.charAt(name.length() - 1)) {
            t++;
        }
        return t == typed.length() && typed.charAt(t - 1) == name.charAt(name.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Q925().isLongPressedName("ex", "eex"));
    }
}
