package Q_1_10.Q4;

import java.util.LinkedList;

/**
 * @author bockey
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class mid {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int left1 = 0;
        int left2 = 0;
        int count = 1;
        int lenSum = nums1.length + nums2.length;

        if (lenSum % 2 == 1) {
            int position = (lenSum + 1) / 2;
            int out_left = 0;
            int[] out = null;
            while (true) {
                if (nums1.length == 0) {
                    out_left = left2;
                    out = nums2;
                    break;
                } else if (nums2.length == 0) {
                    out_left = left1;
                    out = nums1;
                    break;
                }

                count++;
                if (nums1[left1] >= nums2[left2]) {
                    left2++;
                    if (left2 >= nums2.length) {
                        out_left = left1;
                        out = nums1;
                        break;
                    }
                    if (count == position) {
                        return getSmall(nums1[left1], nums2[left2]);
                    }
                } else {
                    left1++;
                    if (left1 >= nums1.length) {
                        out_left = left2;
                        out = nums2;
                        break;
                    }
                    if (count == position) {
                        return getSmall(nums1[left1], nums2[left2]);
                    }
                }
            }
            while (true) {
                if (count == position) {
                    return out[out_left];
                }
                count++;
                out_left++;
            }
        } else {
            LinkedList<Integer> arr = new LinkedList();
            int out_left = 0;
            int[] out = null;
            int position = (lenSum) / 2 + 1;
            double sum = 0;

            while (true) {

                if (nums1.length == 0) {
                    out_left = left2;
                    out = nums2;
                    break;
                } else if (nums2.length == 0) {
                    out_left = left1;
                    out = nums1;
                    break;
                }
                arr.addLast(getSmall(nums1[left1], nums2[left2]));
                if (nums1[left1] >= nums2[left2]) {
                    left2++;
                    if (left2 >= nums2.length) {
                        out_left = left1;
                        out = nums1;
                        break;
                    }
                    if (count == position) {
                        sum = arr.pollLast() + arr.pollLast();
                        return sum / 2;
                    }
                } else {
                    left1++;
                    if (left1 >= nums1.length) {
                        out_left = left2;
                        out = nums2;
                        break;
                    }
                    if (count == position) {
                        sum = arr.pollLast() + arr.pollLast();
                        return sum / 2;
                    }

                }
                arr.addLast(getSmall(nums1[left1], nums2[left2]));
                count = arr.size();
            }
            while (true) {
                if (count == position) {
                    sum = arr.pollLast() + arr.pollLast();
                    return sum / 2;
                }
                arr.addLast((out[out_left]));
                count = arr.size();
            }

        }
    }

    private int getSmall(int a, int b) {
        if (a >= b) {
            return b;
        } else {
            return a;
        }
    }

    public static void main(String[] args) {
        mid m = new mid();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double v = m.findMedianSortedArrays(nums1, nums2);
        System.out.println(v);
    }

    /**
     *
     * 思路解析
     * 先判断数组总长，分成奇偶来处理，
     * 奇数总数，直接找到位置返回即可，
     * 偶数总数，要准备一个链表，接收所有遍历过的目标，比如位置是3，4，则遍历到4号位置，然后返回3，4位置并求结果
     *
     *
     * 然后设置几个标记量，一个是两个数组的位置标记，left1 和2，然后设置一个移动次数标记count。
     * 然后从0位置开始，逐个判断两个数组中，对应left标记位置的大小，每判断一次，就增加一次count，也增加一次较小的那个left标记
     * 直到count总数达到了中位数的 position值。此时就离中位数目标不远了。
     * 在position达到时，对应的left进行几次判断，找到较小的值即可。
     * 对于偶数中位数，要先拿到一个较小的值，然后将它的left++，再找这时较小的值，加总除以2即可。
     *
     * 注意全程提防数组越界问题，如{1，2}{3，4}，如果放任left++，会出现2，0.第一个数组的2位置是越界的，次数需要去另一个数组找。
     *
     * 所以，每一步++后都会判断这组位置指针有没有越界，如果越界了，则直接把尚未越界的数组和指针赋值给之前准备的接收out组，
     * 然后直接遍历这组指针和数组，到达position时直接返回结果即可，
     *
     */
}
