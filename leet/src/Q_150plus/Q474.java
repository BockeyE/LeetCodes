package Q_150plus;

/**
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * <p>
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 * <p>
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * 示例 1：
 * <p>
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1
 * 输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q474 {


    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        findMaxForm(strs, 3, 3);
    }

    public static int findMaxForm(String[] strs, int m, int n) {

        int[] mcount = new int[strs.length];
        int[] ncount = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                if ('0' == (strs[i].charAt(j))) {
                    mcount[i]++;
                } else {
                    ncount[i]++;
                }
            }
        }
        int length = strs.length;
        int[][][] dp = new int[length + 1][m + 1][n + 1];
        for (int i = 1; i < length; i++) {
            int zeros = mcount[i], ones = ncount[i];
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= zeros && k >= ones) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    }
                }
            }
        }
        return dp[length][m][n];
    }

//    [1,3,2,0,1]    5;
//    [1,1,4,1,0]    3;

/**

 */
}
