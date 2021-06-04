package Q_41_50;

import java.util.Arrays;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,0]
 * 输出：3
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 * <p>
 * <p>
 * 实际上，对于一个长度为 N 的数组，其中没有出现的最小正整数只能在 [1,N+1] 中。
 * * 这是因为如果 [1,N] 都出现了，那么答案是 N+1，
 */
public class Q41 {
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        int limit = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = limit + 1;
            }
        }
        for (int i = 0; i < limit; i++) {
            int num = Math.abs(nums[i]);
            if (num <= limit) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < limit; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return limit + 1;
    }
}
