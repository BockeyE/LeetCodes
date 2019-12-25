package Q_31_40.Q33;

/**
 * @author bockey
 *
 *
 * 执行用时 : * 1 ms * , 在所有 java 提交中击败了 * 86.39% * 的用户
 * 内存消耗 : * 36.5 MB * , 在所有 java 提交中击败了 * 84.91% * 的用户
 *
 */
public class Q33 {


    // 存储数组
    int[] nums;
    // 目标字
    int target;

    public int find_rotate_index(int left, int right) {
        //如果数组左值小于数组右值则直接返回0
        if (nums[left] < nums[right])
            return 0;
//        当左不大于右时执行循环
        while (left <= right) {
//            定义一个p钉 在中位
            int pivot = (left + right) / 2;
//            如果钉的右位值大于其值，则该段还是增段，返回钉 + 1
            if (nums[pivot] > nums[pivot + 1])
                return pivot + 1;
            else {
//                否则的情况下，如果钉值小于左值，则该段是减段，更新边界值，
                if (nums[pivot] < nums[left])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return 0;
    }

//    搜索方法
    public int search(int left, int right) {
//        左右未相遇时循环
        while (left <= right) {
//            先取中位作为钉值
            int pivot = (left + right) / 2;
//            如果piv出是target，则返回其值
            if (nums[pivot] == target)
                return pivot;
            else {
                if (target < nums[pivot])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return -1;
    }


//    搜索方法入口
    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        int n = nums.length;

        if (n == 0)
            return -1;
        if (n == 1)
            return this.nums[0] == target ? 0 : -1;

        int rotate_index = find_rotate_index(0, n - 1);

        // if target is the smallest element
        if (nums[rotate_index] == target)
            return rotate_index;
        // if array is not rotated, search in the entire array
        if (rotate_index == 0)
            return search(0, n - 1);
        if (target < nums[0])
            // search in the right side
            return search(rotate_index, n - 1);
        // search in the left side
        return search(0, rotate_index);
    }
}
