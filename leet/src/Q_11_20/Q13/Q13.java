package Q_11_20.Q13;

/**
 * @author bockey
 */
public class Q13 {

//    执行用时 : 10 ms, 在所有 Java 提交中击败了94.69% 的用户
//    内存消耗 : 40 MB, 在所有 Java 提交中击败了73.20% 的用户
    public int romanToInt(String s) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int start = 0;
        for (int i = 0; i < values.length; i++) {
            if (s.startsWith(strs[i])) {
                start = i;
                break;
            }
        }
        int aim = 0;
        while (start <= values.length - 1) {
            if (s.startsWith(strs[start])) {
                //依次去找，字符数组中的字符是不是目标str的startwith字符，如果不是，则数组位目标增加，继续找
                //如果是，则将这个数加上，然后将目标str的指针右移，继续判断，
                // 即匹配MMCM这种情况的MM，已经匹配了一个M，则增加一个M的距离，从第二个M开始匹配
                aim += values[start];
                s = s.substring(strs[start].length());
                continue;
            } else {
                start++;
            }
        }
        return aim;
        //从字符串左侧开始遍历，依次去匹配待匹配的数组最左侧字符，如果不是，则把起始位都右移即可
    }

    public static void main(String[] args) {
        System.out.println(new Q13().romanToInt("LVIII"));
//        1994
    }

}
