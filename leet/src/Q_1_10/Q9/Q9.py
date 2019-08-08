class Solution(object):
    def isPalindrome(self, x):
    # 执行用时 : 96 ms , 在所有 Python 提交中击败了 26.26% 的用户
    # 内存消耗 : 11.7 MB , 在所有 Python 提交中击败了 32.72% 的用户
        if x < 0 or x > 2147447412:
            return False
        orig = int(x)
        t = int(0)
        ret = int(0)
        while x > 0:
            t = int(x % 10)
            x = int(x / 10)
            ret = int(ret * 10)
            ret = int(ret + t)
        return ret == orig
        # 全程注意使用int函数进行转换，否则取余数操作不会到达终点0


if __name__ == '__main__':
    print(Solution().isPalindrome(2332))
