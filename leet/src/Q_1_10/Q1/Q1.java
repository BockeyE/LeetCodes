package Q_1_10.Q1;


import java.util.HashMap;


/**
 * @author bockey
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q1 {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer k = map.put(nums[i], i);
            if (k != null) {
                if (nums[i] == target - nums[k]) {
                    int[] ret = {i, k};
                    return ret;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                if (target - nums[i] == nums[i]) {
                    continue;
                }
                int[] ret = {i, map.get(target - nums[i])};
                return ret;
            }

        }
        return null;
    }

    public static void main(String[] args) {
        int[] a = {-3, 4, 3, 90};
        int[] a2 = twoSum(a, 0);
        for (int i : a2) {
            System.out.println(i);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        Integer put = map.put(1, 1);
        Integer put2 = map.put(1, 2);
//        System.out.println(put);
//        System.out.println(put2);
    }
    /**
     * 先跑一遍数组，把结果放入hashmap中，然后再跑一遍数组，
     *
     * 需要注意的是，因为有那种重叠式的，如3，3，这样的组合，为了剔除第二遍遍历hashmap时带来的繁琐影响
     * 我们在第一步遍历到map时，就将其判断，如果他们是结果，则直接返回，如果不是结果，则不做任何操作
     * 然后在第二步，map中寻找target-i时，遇到重复的数字组，直接判断为错误，因为第一步没有成功，留下来的结果必然是错的。
     *为了说明这个问题，举例
     * 含有3，3目标是6，则第一步遇到添加3却已经存在时，就会计算，6是否等于3+3，如果是直接返回，如果不是，不做操作。
     * 这样的逻辑下，如果是只有一个4，但是目标是8，这样，在第二步，寻找8-4=4时，就会找到它本身，这时，正确的4，4组合，在第一步一定会返回，
     * 函数没有返回，所以第二步里遇到的8-4=4，必然不是结果，只是找到了本身。
     *
     *
     * 到hashmap中找target-i的值即可，注意筛选出3，3这样同数的
     * 在加入hash时就会弹回值，在此处判断，如果3，3不满足，则在第二次遍历时直接跳过即可     */
}
