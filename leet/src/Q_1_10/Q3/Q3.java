package Q_1_10.Q3;

import java.util.HashSet;

/**
 * @author bockey
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Q3 {
    public static int lengthOfLongestSubstring(String s) {
        HashSet set = new HashSet();
        int left = 0;
        int max = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            boolean add = set.add(c);//true 时成功添加到空位置，false时已有元素
            if (!add) {
                while (true) {
                    if (chars[left] != c) {
                        set.remove(chars[left]);
                        left++;
                    } else {
                        left++;
                        break;
                    }
                }
                set.add(c);

            }
            int lenth = (i - left) + 1;
            if (lenth > max) {
                max = lenth;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int acdacd = Q3.lengthOfLongestSubstring("tmmzuxt");
        System.out.println(acdacd);
    }


    /**
     *  解题思路。比较直接。
     *  首先准备一个hashset，在python中用set，golang中直接用map。
     *  然后遍历字符串，判断是否存在在set中，如果已经存在，说明当前字符已经出现了
     *  那么这个时候的操作是最关键的。
     *  要从计算长度的起始点开始，即left++，逐个判断left位置的字符，是不是当前出现的，重复过的字符
     *  如果不是，就要从set中删掉，因为left增加，最长长度永远从left开始算，那么left位置之前的字符不能存在在set中
     *  否则会算错。所以必须逐个判断 left位置是否是当前重复元素
     *  直到找到重复的元素位置，这个时候，left++一次即可跳出这个检验循环，此时，left位置是刚刚重复过的元素，第一次出现位置的后一个位置。
     *
     *  然后在计算长度，保留max即可，通过这思路就可以直接找到最长str
     *
     *
     */
}
