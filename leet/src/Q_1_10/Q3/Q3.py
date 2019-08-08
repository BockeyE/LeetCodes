class Solution(object):
# 执行用时 :48 ms, 在所有 Python 提交中击败了88.93%的用户
# 内存消耗 :12.6 MB, 在所有 Python 提交中击败了23.52%的用户
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        left = 0
        max = 0
        sets = set()
        for i in range(len(s)):
            c = s[i]
            if c in sets:
                while True:
                    if s[left] == c:
                        left += 1
                        break;
                    else:
                        sets.remove(s[left])
                        left += 1
            sets.add(c)
            leth = (i - left) + 1
            if leth > max:
                max = leth
        return max
