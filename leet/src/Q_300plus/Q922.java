package Q_300plus;

/**
 * 执行用时：3 ms, 在所有 Java 提交中击败了78.68% 的用户
 * 内存消耗：41.1 MB, 在所有 Java 提交中击败了40.69% 的用户
 */
public class Q922 {
    public int[] sortArrayByParityII(int[] A) {
        int[] ret = new int[A.length];
        int num2 = 0;
        int num1 = 1;
        for (int i = 0; i < A.length; i++) {
            int target = A[i];
            if (target % 2 == 0) {
                ret[num2] = target;
                num2 = num2 + 2;
            } else {
                ret[num1] = target;
                num1 = num1 + 2;
            }
        }
        return ret;

    }

    /**
     * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
     *
     * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
     *
     * 你可以返回任何满足上述条件的数组作为答案。
     *
     * 示例：
     *
     * 输入：[4,2,5,7]
     * 输出：[4,5,2,7]
     * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
     *
     */
}
