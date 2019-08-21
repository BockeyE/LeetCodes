class Solution(object):
    # 执行用时: 16   ms , 在所有 Python 提交中击败了 98.95% 的用户
    # 内存消耗: 11.7 MB , 在所有 Python 提交中击败了 30.32 % 的用户
    def longestCommonPrefix(self, strs):
        if len(strs) == 0:
            return ''
        if len(strs) == 1:
            return strs[0]

        c = strs[0]
        for i in range(len(strs)):
            c = self.getCommonTwo(c, strs[i])
        return c

    def getCommonTwo(self, s1, s2):
        if s1 == s2:
            return s1
        end = 0
        while end < len(s1) and end < len(s2):
            if s1[end] == s2[end]:
                end = end + 1
            else:
                break
        return s1[0:end]


if __name__ == '__main__':
    print(Solution().longestCommonPrefix(["flower", "flow", "flight"]))
