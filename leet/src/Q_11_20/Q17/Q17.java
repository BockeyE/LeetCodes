package Q_11_20.Q17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bockey
 *
 * 执行用时 :  1 ms  , 在所有 java 提交中击败了  97.14%  的用户
 * 内存消耗 :  35.8  MB  , 在所有 java 提交中击败了  76.23%  的用户
 *
 */
public class Q17 {
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    List<String> output = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) backtrack("", digits);
        return output;

    }

    public void backtrack(String combi, String nextd) {
        if (nextd.length() == 0) output.add(combi);
        else {
//            输入一个数字标，在这里截取首位数字，然后去map中取出对应的字母组
            String digi = nextd.substring(0, 1);
            String letters = phone.get(digi);
//            遍历这个字母组
            for (int i = 0; i < letters.length(); i++) {
//                然后循环i，取出每个字母，每个字母再拼接到刚刚已经有的结果里，
//                然后把数字组从第二位开始截取，递归重新执行back函数
                String oneLetter = phone.get(digi).substring(i, i + 1);
                backtrack(combi + oneLetter, nextd.substring(1));
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(new Q17().letterCombinations("23"));
    }
}
