package Q_131_140;

/**
 执行用时：26 ms, 在所有 Java 提交中击败了33.09% 的用户
 内存消耗：38.5 MB, 在所有 Java 提交中击败了95.61% 的用户
 */
public class Q134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < cost.length; i++) {
            if (cost[i] <= gas[i]) {
                if (checkPosition(gas, cost, i)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean checkPosition(int[] gas, int[] cost, int index) {
        int len = gas.length;
        int stock = gas[index] - cost[index];
        int pos = index == (len - 1) ? 0 : index + 1;
        while (stock >= 0) {
            stock += (gas[pos] - cost[pos]);
            pos++;
            if (pos == len) {
                if (index == 0) {
                    return stock >= 0;
                } else {
                    pos = 0;
                }
            } else {
                if (pos == index) {
                    return stock >= 0;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] ga = {3, 1, 1};
        int[] ca = {1, 2, 2};
        new Q134().canCompleteCircuit(ga, ca);
    }
}

/**
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * <p>
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * <p>
 * 说明:
 * <p>
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 * <p>
 * 输出: 3
 * <p>
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * gas  = [2,3,4]
 * cost = [3,4,3]
 * <p>
 * 输出: -1
 * <p>
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 */