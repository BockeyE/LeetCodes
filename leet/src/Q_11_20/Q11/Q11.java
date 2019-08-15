package Q_11_20.Q11;

/**
 * @author bockey
 */
public class Q11 {
//    执行用时 : 4 ms, 在所有 Java 提交中击败了95.71%    的用户
//    内存消耗 : 44.6 MB, 在所有 Java 提交中击败了64.91%    的用户

    public int maxArea(int[] height) {
//直接使用双指针法
        int start = 0;
        int end = height.length - 1;
        int tem1 = 0;
        int max = 0;
        while (start != end) {
            tem1 = ((height[start] <= height[end]) ? height[start] : height[end]) * (end - start);
            max = (tem1 >= max) ? tem1 : max;
            if ((height[start] <= height[end])) {
                start++;
            } else {
                end--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//        int[] a = {2, 3, 10, 5, 7, 8, 9};
        int[] a = {1, 1};
        System.out.println(new Q11().maxArea(a));
    }
}
