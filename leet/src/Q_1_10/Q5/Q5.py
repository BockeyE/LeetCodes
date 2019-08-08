class Solution(object):
    def longestPalindrome(self, s):
        # 执行用时 :1148 ms, 在所有 Python 提交中击败了55.65%的用户
        # 内存消耗 :11.7 MB, 在所有 Python 提交中击败了52.57%的用户

        res = ''
        tem = ''
        if len(s) <= 1:
            return s
        if len(s) == 2:
            if s[1] == s[0]:
                return s
            else:
                return s[0]
        res = s[0]
        for i in range(1, len(s) - 1):
            if s[i - 1] == s[i + 1]:
                tem = self.getSub(s, i - 1, i + 1)
                if len(tem) > len(res):
                    res = tem
            if s[i - 1] == s[i]:
                tem = self.getSub(s, i - 1, i)
                if len(tem) > len(res):
                    res = tem
            if s[i] == s[i + 1]:
                tem = self.getSub(s, i, i + 1)
                if len(tem) > len(res):
                    res = tem
        return res

    def getSub(self, s, i, j):
        while (i >= 0 and j < len(s)):
            if s[i] == s[j]:
                i = i - 1
                j = j + 1
            else:
                break
        i = i + 1
        return s[i: j]


if __name__ == '__main__':
    print(Solution().longestPalindrome('acacaa'))
