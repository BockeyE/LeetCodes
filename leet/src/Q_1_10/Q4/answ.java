package Q_1_10.Q4;

/**
 * @author bockey
 */
public class answ {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m;
        int n;
        int[] shorts;
        int[] longs;
        if (nums1.length <= nums2.length) {
            shorts = nums1;
            longs = nums2;
        } else {
            shorts = nums2;
            longs = nums1;
        }
        int[] A = shorts;
        int[] B = longs;
        m = shorts.length;
        n = longs.length;
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = i - 1;
                // 左组最大B ，比 右组最小A 大，因此需要调整，增加i值
                // i is too small ,j要边小，i要变大
            } else if (i > iMin && A[i - 1] > B[j]) {
                // 左组最大A ，比 右组最小B 大，因此需要调整，增加i值
                // j is too small ，i要边小，j要变大
                iMax = i - 1;
            } else {
                //两种情况都不是时，接近终点
                int maxLeft = 0;
                //左侧最小值
                if (i == 0) {
                    //如果i是0，则左侧最大值是B组的
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    //如果j是0，则左侧最大值是B组的
                    maxLeft = A[i - 1];
                } else {
                    //都不是时，比较一下AB组末尾的值
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    //如果是奇数总数时，返回这个即可
                    return maxLeft;
                }
                //右侧最小值
                int minRight = 0;
                if (i == m) {
                    //如果i是A组总长，则右侧组全由B组组成
                    minRight = B[j];
                } else if (j == n) {
                    //如果j是A组总长，则右侧组全由B组组成
                    minRight = A[i];
                } else {
                    //都不是时，对比即可
                    minRight = Math.min(B[j], A[i]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0;
    }

}
/**
 * 方法：递归法
 * 首先，让我们在任一位置 i 将 A 划分成两个部分：
 * left_A             |        right_A
 * A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
 * 由于 A 中有 m 个元素， 所以我们有 m+1 种划分的方法（i=0∼m）。
 * B也做同样处理，
 * 将 left_A 和 left_B 放入一个集合，并将right_A 和 right_B 放入另一个集合。 left_part 和 right_part：
 * 如果我们可以确认：
 * len(left_part)=len(right_part)
 * max(left_part)≤min(right_part)
 * 那么，我们已经将 {A,B} 中的所有元素划分为相同长度的两个部分，
 * 且其中一部分中的元素总是大于源于同组的，另一部分中的元素。那么：
 * <p>
 * median=(max(left_part)+min(right_part))/2
 * <p>
 * 要确保这两个条件，我们只需要保证：
 * 条件 C1
 * >>>>> A组长度 m，B组长度 n <<<<<
 * i+j=m−i+n−j（或：m−i+n−j+1）
 * （解释，意思是说，保证切分出来的结果，i+j总数正好等于剩下的总数）
 * 如果 n≥m，只需要使  i=0∼m, j= (m+n+1)/2−i
 * (解释，这里的意思是，如果n比m大，也就是说，如3 和 8 个数，中位数在6，是超出A组范围的，
 * 于是，中位数的总序在m+n+1/2，因此j总位序是再减去i)
 * 条件 C2
 * B[j−1]≤A[i] 以及 A[i−1]≤B[j]
 * （解释，B j-1，意思是分组中，左组B最大元素，要小于等于 A i，也就是右组A最小元素，换句话说保证左组必然都小于等同于右组min值）
 * （因为AB组内的ij分组，已经确保小于同组的另一半，这里要对比端点值，得到也小于另一组的结论）
 * ps.1 为了简化分析，我假设 A[i−1],B[j−1],A[i],B[j] 总是存在，哪怕出现 i=0，i=m，j=0，或是j=n 这样的临界条件。
 * 我将在最后讨论如何处理这些临界值。
 * <p>
 * ps.2 为什么 n≥m？由于 0≤i≤m 且 j= [（m+n+1）/2]−i，
 * 我必须确保 j 不是负数。如果n<m，那么 j 将可能是负数，而这会造成错误的答案。
 * 所以，我们需要做的是：在 [0，m] 中搜索并找到目标对象 i，以使：
 * <p>
 * B[j−1]≤A[i] 且 A[i−1]≤B[j], 其中 j= [（m+n+1）/2]−i，
 * 接着，我们可以按照以下步骤来进行二叉树搜索：
 * 设 imin=0，imax=m, 然后开始在 [imin,imax] 中进行搜索。
 * <p>
 * 令 i = (imin+imax)/2
 * j= [（m+n+1）/2]−i，
 * 现在我们有 len(left_part)=len(right_part)。 而且我们只会遇到三种情况：
 * 1,
 * B[j−1]≤A[i] 且 A[i−1]≤B[j]：
 * 这意味着我们找到了目标对象 i，所以可以停止搜索。
 * 2,
 * B[j−1]>A[i]：
 * 这意味着A[i] 太小，我们必须调整 i 以使B[j−1]≤A[i]。
 * 我们可以增大 i 吗？
 *       是的，因为当 i 被增大的时候，j 就会被减小。
 *       因此 B[j−1] 会减小，而 A[i] 会增大，那么 B[j−1]≤A[i] 就可能被满足。
 * 我们可以减小 i 吗？
 *       不行，因为当 i 被减小的时候，j 就会被增大。
 *       因此 B[j−1] 会增大，而 A[i] 会减小，那么B[j−1]≤A[i] 就可能不满足。
 * 所以我们必须增大 i。也就是说，我们必须将搜索范围调整为 [i+1,imax]。 因此，设 imin=i+1，并转到步骤 2。
 * 3,
 * A[i−1]>B[j]： 这意味着 A[i−1] 太大，我们必须减小 i 以使 A[i−1]≤B[j]。
 * 也就是说，我们必须将搜索范围调整为 [imin,i−1]。
 * 因此，设 imax=i−1，并转到步骤 2。
 * <p>
 * 当找到目标对象 i 时，中位数为：
 * <p>
 * max(A[i−1],B[j−1]), 当 m + nm+n 为奇数时
 * max(A[i−1],B[j−1])+min(A[i],B[j])   /2, 当 m + nm+n 为偶数时
 * 临界值可以自行考虑
 */