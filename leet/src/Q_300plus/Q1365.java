package Q_300plus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 执行用时：4 ms, 在所有 Java 提交中击败了73.11% 的用户
 * 内存消耗：38.3 MB, 在所有 Java 提交中击败了98.58% 的用户
 */
public class Q1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        //sort the array
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        //prepare a map
        HashMap m = new HashMap();

        //put key with sorted value, put value with the position after sort,
        //which means when  i in position 4, it means
        //there is 4 elements smaller than i
        for (int i = 0; i < sorted.length; i++) {
            m.putIfAbsent(sorted[i], i);
        }
        // get ret
        int[] ret = new int[nums.length];
        for (int i = 0; i < ret.length; i++) {
            int k = nums[i];
            ret[i] = (int) m.get(k);
        }
        return ret;
    }

    public static void main(String[] args) {
        String a = "ssaa0022";
        System.out.println(a.substring(a.length() - 4));
        System.out.println(a.substring(0,a.length() - 4));
        System.out.println(Integer.parseInt(a.substring(a.length() - 4, a.length() - 1)));

        int[] nums = {8, 1, 2, 2, 3};

        new Q1365().smallerNumbersThanCurrent(nums);
    }
}
