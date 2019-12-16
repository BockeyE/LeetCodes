package Q_31_40.Q31;

/**
 * @author bockey
 * 我们需要找到给定数字列表的下一个字典排列，而不是由给定数组形成的数字。
 *
 * 执行用时 : * 1 ms * , 在所有 java 提交中击败了 * 100.00% * 的用户
 * 内存消耗 : * 37.8 MB * , 在所有 java 提交中击败了 * 85.69% * 的用户
 */
public class Q31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
