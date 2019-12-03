package Q_11_20.Q15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bockey
 *
 *
 * 执行用时 : 31 ms  , 在所有 java 提交中击败了  98.36%  的用户
 * 内存消耗 :  47.3 MB  , 在所有 java 提交中击败了  94.73%  的用户
 */
public class Q15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) return ans;
        int len = nums.length;

        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break;// 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if ((i > 0 && nums[i] == nums[i - 1])) continue;// 去重，对i
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;// 去重对 l
                    while (l < r && nums[r] == nums[r - 1]) r--;// 去重对 r
                    l++;
                    r--;
                } else if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] ss = {1, 2, 3, 4};
        int[] ss =  {-1, 0, 1, 2, -1, -4};
        System.out.println(new Q15().threeSum(ss));
    }
}

