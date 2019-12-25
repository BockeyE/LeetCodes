package Q_31_40.Q35;

/**
 * @author bockey
 * <p>
 * 执行用时 :0 ms, 在所有 java 提交中击败了100.00% 的用户
 * 内存消耗 :38.8 MB, 在所有 java 提交中击败了59.01%的用户
 */
public class Q35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (nums[right] < target) return right + 1;
        while (left <= right) {
            //尽量避免不必要的越界问题
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}


