class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        if numRows == 1:
            return s
        arrList = [[] for i in range(numRows)]

        i = 0
        period = (numRows - 1) * 2
        while i < len(s):

            if i % period == 0:
                for j in range(numRows):
                    if i < len(s):
                        ar = arrList[j]
                        ar.append(s[i])
                        i = i + 1
                    else:
                        break

                for j in range(1, numRows - 1):
                    if i < len(s):
                        ar = arrList[numRows - 1 - j]
                        ar.append(s[i])
                        i = i + 1
                    else:
                        break
        s2 = []
        for i in range(numRows):
            ar = arrList[i]
            for m in range(len(ar)):
                s2.append(ar[m])
        print(s2)
        return "".join(s2)


if __name__ == '__main__':
    print(Solution().convert('LEETCODEISHIRING', 4))
