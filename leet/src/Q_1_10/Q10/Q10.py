class Solution(object):
    # 执行用时: 1880 ms , 在所有 Python 提交中击败了 18.51 % 的用户
    # 内存消耗: 11.7 MB , 在所有 Python 提交中击败了 36.00 % 的用户
    def isMatch(self, s, p):
        # 110 ms 在所有 Python 提交中击败了 51.74% 的用户
        # 12.9 MB 在所有 Python 提交中击败了 43.26% 的用户
        if p == "":
            return s == ""
        fm = ((not s == "") and (p[0] == s[0] or p[0] == '.'))
        if len(p) >= 2 and p[1] == '*':
            return (self.isMatch(s, p[2:])) or (fm and self.isMatch(s[1:], p))
        else:
            return fm and self.isMatch(s[1:], p[1:]);


if __name__ == '__main__':
    print(Solution().isMatch([2, 3, 10, 5, 7, 8, 9]))
