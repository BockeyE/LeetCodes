package Q_1_10.Q6;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bockey
 */
public class Q6 {
//执行用时 :31 ms, 在所有 Java 提交中击败了40.62%的用户
// 内存消耗 :48.9 MB, 在所有 Java 提交中击败了62.04%的用户

    public String convert(String s, int numRows) {
        if (numRows==1){
            return s;
        }
        List<ArrayList> arrlist = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            ArrayList arr = new ArrayList();
            arrlist.add(arr);
        }
        StringBuilder retsb=new StringBuilder();
        char[] chars = s.toCharArray();
        int i = 0;
        while (i < chars.length) {
                for (int j = 0; j < numRows && i < chars.length; ) {
                    arrlist.get(j).add(chars[i]);
                    j++;
                    i++;
                }
                for (int j = numRows - 2; j > 0 && i < chars.length; ) {
                    arrlist.get(j).add(chars[i]);
                    i++;
                    j--;
                }
        }
        for (int k = 0; k < arrlist.size();k++ ) {
            ArrayList ar = arrlist.get(k);
            for (int j = 0; j < ar.size(); j++) {
                retsb.append(ar.get(j));
            }
        }
        return retsb.toString();
    }

    public static void main(String[] args) {
        Q6 q = new Q6();
//        String s = q.convert("A", 1);
        String s = q.convert("LEETCODEISHIRING", 4);
//        LDREOEIIECIHNTSG
//        LDREOEIIECIHNTSG
        System.out.println(s);
    }

    /**
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     *
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     *
     * 先根据输入的数字，new出对应数量的list，然后把这些list也存在一个list里，这样可以通过一个游标数字
     * 直接get到存放char的list。
     *
     * 然后进行遍历，遍历的时候，以numRow -1 为半个周期，2*（numRow-1）为一个周期， 图示例子的 L-D-R是周期点，
     * 每个周期里，先单列向下，然后折返。
     * 周期的起始点是  %numRow =0 的点，也就是LDR几个点
     * 然后顺序执行遍历，添加到对应位置的list里，
     * 最后用stringbuilder依次拿出来即可。
     *
     */
}
