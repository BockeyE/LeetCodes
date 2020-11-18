package Q_150plus;

import java.util.HashSet;

/**
 执行用时：2 ms, 在所有 Java 提交中击败了99.48% 的用户
 内存消耗：38.5 MB, 在所有 Java 提交中击败了94.10% 的用户
 */
public class Q349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] toSet = nums1.length < nums2.length ? nums1 : nums2;
        int[] tar = nums1.length > nums2.length ? nums1 : nums2;
        HashSet<Integer> sets = new HashSet<>();
        for (int i : toSet) {
            sets.add(i);
        }
        HashSet<Integer> ret = new HashSet<>(tar.length);
        for (int i : tar) {
            if (sets.contains(i)) {
                ret.add(i);
            }
        }
        int[] d = new int[ret.size()];
        int i = 0;
        for (Integer integer : ret) {
            d[i] = integer;
            i++;
        }
        return d;
    }

}
