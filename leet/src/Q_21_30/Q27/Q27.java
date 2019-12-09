package Q_21_30.Q27;

/**
 * @author bockey
 *
 * 执行用时 : * 0 ms * , 在所有 java 提交中击败了 * 100.00% * 的用户
 * 内存消耗 : * 35.9 MB * , 在所有 java 提交中击败了 * 84.18% * 的用户
 */
public class Q27 {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;

    }

    public static void main(String[] args) {
//        int[] c = {1, 1, 1, 2, 3, 3, 4, 4, 4};
        int[] c = {1, 1};
        new Q27().removeElement(c, 1);
        for (int i : c) {
            System.out.println(i);
        }

    }
}
