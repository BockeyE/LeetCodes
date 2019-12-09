package Q_21_30.Q26;

/**
 * @author bockey
 * <p>
 * 执行用时 : * 1 ms * , 在所有 java 提交中击败了 * 100.00% * 的用户
 * 内存消耗 :39.4 MB, 在所有 java 提交中击败了96.31%的用户
 */
public class Q26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int next = 0;
        int t = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != t) {
                nums[next + 1] = nums[i];
                next++;
                t = nums[i];
            }
        }
        return next + 1;
    }

    public static void main(String[] args) {
        int[] c = {1, 1, 1, 2, 3, 3, 4, 4, 4};
//        int[] c = {1, 1, 2};
        new Q26().removeDuplicates(c);
        for (int i : c) {
            System.out.println(i);
        }

    }
}
