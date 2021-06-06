package Q_51_60;

/**
 * 执行用时：1 ms, 在所有 Java 提交中击败了95.46% 的用户
 * 内存消耗：37.8 MB, 在所有 Java 提交中击败了99.36% 的用户
 */
public class Q53 {
    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
