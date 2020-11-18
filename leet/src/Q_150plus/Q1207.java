package Q_150plus;

import java.util.HashMap;
import java.util.HashSet;

/**
 执行用时：2 ms, 在所有 Java 提交中击败了91.43% 的用户
 内存消耗：36.1 MB, 在所有 Java 提交中击败了97.04% 的用户
 */
public class Q1207 {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> m1 = new HashMap();
        for (int i : arr) {
            m1.put(i, m1.getOrDefault(i, 0) + 1);
        }
        HashSet hs = new HashSet();
        for (Integer value : m1.values()) {
            if (!hs.add(value)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(true||false||false);
        int[] arr = {1, 2, 2, 1, 1, 3};
        System.out.println(new Q1207().uniqueOccurrences(arr));
    }
}
