package Q_150plus;

/**
 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
 内存消耗：34.9 MB, 在所有 Java 提交中击败了95.53% 的用户
 */
public class Q347 {
    static int tar = 2;

    public static void main(String[] args) {
        System.out.println(guessNumber(3));
    }

    public static int guessNumber(int n) {
        int left = 1;
        int right = n;
        if (guess(left) == 0) {
            return left;
        }
        if (guess(right) == 0) {
            return right;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) == -1) {
                right = mid;
            } else if (guess(mid) == 1) {
                left = mid;
            } else {
                return mid;
            }
        }
        return left;
    }

    public static int guess(int n) {
        if (n - tar > 0) {
            return 1;
        } else if (n - tar < 0) {
            return -1;
        }
        return 0;
    }
}
