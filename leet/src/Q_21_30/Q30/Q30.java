package Q_21_30.Q30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author bockey
 *
 * 执行用时 : * 200  ms * , 在所有 java 提交中击败了 * 31.44% * 的用户
 * 内存消耗 : * 42.9 MB * , 在所有 java 提交中击败了 * 88.07% * 的用户
 */
public class Q30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        //因为word长度都相同，因此只计算all len
        int one_word = words[0].length();
        int word_num = words.length;
        int all_len = one_word * word_num;
        for (String word : words) {
//            put的是getOrDefault，意思是如果有值则取出来，没有就返回默认，通常用来map计数，如下用法，加一即可
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        //边界是lenth-alllen+1，剩余长度不足一个all len时无需判断
        for (int i = 0; i < s.length() - all_len + 1; i++) {
            //取i开始的一段字符
            String tmp = s.substring(i, i + all_len);

            HashMap<String, Integer> tmp_map = new HashMap<>();
//            将这个字符按照同样的方法拆分成map，如果是一样的word组合，则拆出来的map应该是一样的
            for (int j = 0; j < all_len; j += one_word) {
                String w = tmp.substring(j, j + one_word);
                tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
            }
            if (map.equals(tmp_map)) res.add(i);
        }
        return res;
    }


}
