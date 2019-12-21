package Q_31_40.Q34;
/**
 * @author bockey
 *
 *
   执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
   内存消耗 :42.2 MB, 在所有 java 提交中击败了74.91%的用户
 */
public class Q34 {



//    另一个改变是 left 参数的引入，它是一个 boolean 类型的变量，
//    指示我们在遇到 target == nums[mid] 时应该做什么。如果 left 为 true ，
//    那么我们递归查询左区间，否则递归右区间。考虑如果我们在下标为 i 处遇到了 target ，
//    最左边的 target 一定不会出现在下标大于 i 的位置，所以我们永远不需要考虑右子区间。
//    当求最右下标时，道理同样适用。


    //
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            //取二分位置
            int mid = (lo + hi) / 2;
//            如果mid大于target，或者在相等时，left为true
//            缩短右边界到mid
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
//            否则，缩短左边界到mid
            else {
                lo = mid+1;
            }
        }
        return lo;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};

//        通过二分查找拿到左id位置
        int leftIdx = extremeInsertionIndex(nums, target, true);

//        如果左id位置已经到达数组末尾或者，他不是target。则返回 -1，1
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }
//        都未进入时，则已经找到了左边界，继续执行找右边界即可

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

        return targetRange;
    }

}
