package Q_21_30.Q25;

/**
 * @author bockey
 */
public class Q25 {
    public int removeDuplicates(int[] nums) {
        int lenth = nums.length;
        int current = nums[0];
        int next = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] == nums[i]) {
            }
        }

        return lenth;
    }

    public static void main(String[] args) {
        int[] c = {1, 1, 1, 2, 3, 3, 4, 4, 4};
        new Q25().removeDuplicates(c);
        for (int i : c) {
            System.out.println(i);
        }
    }
}
