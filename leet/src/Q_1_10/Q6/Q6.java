package Q_1_10.Q6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bockey
 */
public class Q6 {
    public String convert(String s, int numRows) {
        List<ArrayList> arrlist = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            ArrayList arr = new ArrayList();
            arrlist.add(arr);
        }
        char[] chars = s.toCharArray();
        ArrayList ret = new ArrayList();
        int i = 0;
        int period = numRows * 2;
        while (i < chars.length) {
            if (i % period == 0) {
                for (int j = 0; j < numRows; ) {
                    System.out.println("position i : " + i + " >> value: " + chars[i]);
                    arrlist.get(j).add(chars[i]);
                    j++;
                    i++;
                }
                for (int j = numRows - 2; j > 0; ) {
                    System.out.println("position i : " + i + " >> value: " + chars[i]);
                    arrlist.get(j).add(chars[i]);
                    i++;
                    j--;
                }
            }
            i++;

        }
        System.out.println(arrlist);
        for (ArrayList arrayList : arrlist) {
            for (Object o : arrayList) {
                for (Object o1 : arrayList) {
                    ret.add(o1);
                }
            }
        }
        char[] rets = s.toCharArray();
        for (int m = 0; m < rets.length; m++) {
            rets[m] = (char) ret.get(m);
        }
        return String.copyValueOf(rets);


    }

    public static void main(String[] args) {
        Q6 q = new Q6();
        String s = q.convert("LEETCODEISHIRING", 4);
//        LDREOEIIECIHNTSG
        System.out.println(s);
    }
}
