class Solution(object):
    # 执行用时: 56  ms , 在所有 Python 提交中击败了 55.99% 的用户
    # 内存消耗: 11.6 MB , 在所有 Python 提交中击败了 33.50 % 的用户
    def romanToInt(self, s):
        values = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]
        strs = ["M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"]
        start = 0

        for i in range(len(values)):
            if s.startswith(strs[i]):
                start = i
                break
        aim = 0
        while start < len(values):
            if s.startswith(strs[start]):
                aim = aim + values[start]
                s = s[len(strs[start]):]
                continue
            else:
                start = start + 1
        return aim


if __name__ == '__main__':
    print(Solution().romanToInt('LVIII'))
