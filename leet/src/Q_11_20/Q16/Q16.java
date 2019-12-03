package Q_11_20.Q16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bockey
 * <p>
 * <p>
 * 执行用时 :6 ms, 在所有 java 提交中击败了89.47%的用户
 * 内存消耗 :36.5 MB, 在所有 java 提交中击败了84.18%的用户
 */
public class Q16 {
    public int threeSumClosest(int[] nums, int target) {
        int ans = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int ends = nums.length - 1;
            while (start < ends) {
                int sum = nums[i] + nums[start] + nums[ends];
                int tem = (Math.abs(sum - target));
                int current = (Math.abs(target - ans));
                if (tem < current) ans = sum;

                if (sum > target) ends--;
                else if (sum < target) start++;
                else return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] ss = {1, 2, 3, 4};[-1，2，1，-4]
        int[] ss = {0, 1, 2};
//        int[] ss = {-1, 1, 2, -4};
        System.out.println(new Q16().threeSumClosest(ss, 3));
    }
}

