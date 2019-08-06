class Solution(object):
    def myAtoi(self, s):
        # 24 ms 在所有 Python 提交中击败了 90.99%
        # 11.6 MB 在所有 Python 提交中击败了 40.22%
        s = s.strip()
        if s.startswith("+-"):
            return 0
        if s.startswith("+"):
            s = s[1:]
        if len(s) == 0:
            return 0
        start = 0
        end = len(s)
        aim = ["-", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"]
        aim2 = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"]
        if s[0] not in aim:
            return 0
        k = start + 1
        while k < len(s):
            if not (s[k] in aim2):
                end = k
                break
            k = k + 1
        sub = s[start:end]
        if sub == "-":
            return 0
        ret = int(sub)
        if ret > 2147483647:
            return 2147483647
        if ret < -2147483648:
            return -2147483648
        return ret


if __name__ == '__main__':
    print(Solution().myAtoi("+"))
