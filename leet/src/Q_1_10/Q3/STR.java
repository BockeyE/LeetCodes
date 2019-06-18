package Q_1_10.Q3;

import java.util.HashMap;
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
public class STR {
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
        int acdacd = STR.lengthOfLongestSubstring("tmmzuxt");
        System.out.println(acdacd);
    }
}
