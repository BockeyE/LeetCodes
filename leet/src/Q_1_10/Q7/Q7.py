class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        if x >= 2147483647 or x <= (-2147483648):
            return 0
        if x < 0:
            return -self.act(-x)
        else:
            return self.act(x)

    def act(self, x):
        print(x)
        ret = 0
        while x != 0:
            pop = int(x % 10)
            x = int(x / 10)
            # //python3以后的代码，计算时都是精确计算，包括取余和除法
            # 因此需要用到传统舍弃流计算时，需要对结果进行int转换，
            if ret > 214748364 or ((ret == 214748364) and (pop > 7)):
                return 0
            ret = ret * 10
            ret = ret + pop
        return ret


if __name__ == '__main__':
    print(Solution().reverse(32414))
