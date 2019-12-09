package Q_21_30.Q28;

/**
 * @author bockey
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1: 输入: haystack = "hello", needle = "ll" 输出: 2
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 *
 *
 * 执行用时 : * 7 ms * , 在所有 java 提交中击败了 * 20.71% * 的用户
 * 内存消耗 : * 36.7 MB * , 在所有 java 提交中击败了 * 80.11% * 的用户
 */
public class Q28 {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        int pn = 0;
        int p = 0;
        while (p < haystack.length()) {
            if (haystack.charAt(p) == needle.charAt(0)) {
                int ph = p;
                while (pn < needle.length()) {
                    if (haystack.charAt(ph) != needle.charAt(pn)) {
                        pn = 0;
                        p++;
                        break;
                    }
                    if (pn == needle.length() - 1) return p;
                    pn++;
                    ph++;
                    if (ph >= haystack.length()) {
                        return -1;
                    }
                }
            } else p++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Q28().strStr("mississippi", "issip"));
    }
}
