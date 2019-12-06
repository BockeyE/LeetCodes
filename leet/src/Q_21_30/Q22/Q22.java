package Q_21_30.Q22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bockey
 *
 *
 */
public class Q22 {

    /*
    对于每个闭合数 c，我们知道起始和结束括号必定位于索引 0 和 2*c + 1。然后两者间的 2*c 个元素一定是有效序列，其余元素一定是有效序列。

当我们清楚所有 i<n 时括号的可能生成排列后，对与 i=n 的情况，我们考虑整个括号排列中最左边的括号。
它一定是一个左括号，那么它可以和它对应的右括号组成一组完整的括号 "( )"，我们认为这一组是相比 n-1 增加进来的括号。

那么，剩下 n-1 组括号有可能在哪呢？
    既然知道了 i<n 的情况，那我们就可以对所有情况进行遍历：

"(" + 【i=p时所有括号的排列组合】 + ")" + 【i=q时所有括号的排列组合】
其中 p + q = n-1，且 p q 均为非负整数。
     */

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) ans.add("");
        else {
            for (int c = 0; c < n; ++c) {
                for (String l : generateParenthesis(c)) {
                    for (String r : generateParenthesis(n - 1 - c)) {
                        ans.add("(" + l + ")" + r);
                    }
                }
            }
        }
        return ans;
    }
}
