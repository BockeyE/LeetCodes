package Q_11_20.Q12;

/**
 * @author bockey
 */
public class Q12 {

//    执行用时 :8 ms, 在所有 Java 提交中击败了96.75% 的用户
//    内存消耗 :39.2 MB, 在所有 Java 提交中击败了93.78% 的用户

    public String intToRoman(int num) {

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            if (num / values[i] == 0) continue;
            int k = num / values[i];
            while (k != 0) {
                sb.append(strs[i]);
                k--;
            }
            num = num % values[i];
            if (num == 0) {
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Q12().intToRoman(1994));
    }
}
/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 */