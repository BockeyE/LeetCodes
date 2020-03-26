package Q_31_40.Q38;

/**
 * @author bockey
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 6.     312211
 * 7.     13112221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 */
public class Q38 {
    /**
     * 思路， 遍历当前str，设置2个标，一个记录当前起始点，一个往右走，如果当前右点字符与起始点不一样，则记录数量，并拼接成新的
     * 此时将起始点设置为右点，继续至str结束
     *
     执行用时 :     1 ms     , 在所有 Java 提交中击败了     98.70%     的用户
     内存消耗 :     37.1 MB     , 在所有 Java 提交中击败了     5.29%     的用户
     */
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String tar = "1";
        int k = 1;
        while (k < n) {
            tar = generateNext(tar);
            k++;
        }
        return tar;
    }

    public String generateNext(String tar) {
        StringBuilder sb = new StringBuilder();
        int m = 0;
        int count = 0;
        for (int i = 0; i < tar.length(); ) {
            m = i;
            while (m < tar.length() && tar.charAt(m) == tar.charAt(i)) {
                m++;
                count++;
            }
            sb.append(count).append(tar.charAt(i));
            i = m;
            count = 0;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Q38().countAndSay(5));
    }
}
