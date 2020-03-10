package Q_31_40.Q39;

import java.util.*;

/**
 * @author bockey
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * <p>
 * 思路：根据示例 1：输入: candidates = [2,3,6,7]，target = 7。
 * <p>
 * 候选数组里有 2 ，如果找到了 7 - 2 = 5 的所有组合，再在之前加上 2 ，就是 7 的所有组合；
 * 同理考虑 3，如果找到了 7 - 3 = 4 的所有组合，再在之前加上 3 ，就是 7 的所有组合，依次这样找下去；
 */
public class Q39 {
    /**
     * 执行用时 :     * 3 ms     * , 在所有 Java 提交中击败了     * 96.52%     * 的用户
     * 内存消耗 :     * 41.9 MB     * , 在所有 Java 提交中击败了     * 5.25%     * 的用户
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 排序是为了提前终止搜索
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null) {
            return res;
        }
        int len = candidates.length;

        Arrays.sort(candidates);
        BacktrackingWithDeepFirstSearching(candidates, len, target, 0, new Stack<>(), res);
        return res;
    }

    private void BacktrackingWithDeepFirstSearching(int[] candidates, int len, int target, int begin, Stack<Integer> pre, List<List<Integer>> res) {
//        如果当前搜索目标是0则添加后返回
        if (target == 0) {
            res.add(new ArrayList<>(pre));
            return;
            //遍历，index为本分支上一节点的减数的下标
        }
        for (int i = begin; i < len; i++) {
            //如果减数大于目标值，则差为负数，不符合结果
            if (candidates[i] <= target) {
                pre.push(candidates[i]);
                //目标值减去元素值
                BacktrackingWithDeepFirstSearching(candidates, len, target - candidates[i], i, pre, res);
                //每次回溯将最后一次加入的元素删除
                pre.pop();
            }
        }
    }
}