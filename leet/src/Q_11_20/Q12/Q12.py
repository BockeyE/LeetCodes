class Solution(object):
    # 执行用时: 56  ms , 在所有 Python 提交中击败了 43.47% 的用户
    # 内存消耗: 11.7 MB , 在所有 Python 提交中击败了 37.09 % 的用户
    def intToRoman(self, num):
        values = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]
        strs = ["M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"]
        s = ""
        for i in range(len(values)):
            if int(num / values[i]) == 0: continue
            k = int(num / values[i])
            while k != 0:
                s = s + strs[i]
                k = k - 1
            num = int(num % values[i])
            if num == 0:
                break
        return s


if __name__ == '__main__':
    print(Solution().intToRoman(123))
