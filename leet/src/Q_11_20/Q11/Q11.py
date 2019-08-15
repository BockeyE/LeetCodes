class Solution(object):
    def maxArea(self, height):
        # 140 ms 在所有 Python 提交中击败了 51.74% 的用户
        # 12.9 MB 在所有 Python 提交中击败了 43.26% 的用户
        start = 0
        end = len(height) - 1
        tmax = 0
        while start != end:
            tem = int(min(height[start], height[end]) * (end - start))
            tmax = max(tem, tmax)
            if height[start] <= height[end]:
                start = start + 1
            else:
                end = end - 1
        return tmax


if __name__ == '__main__':
    print(Solution().maxArea([2, 3, 10, 5, 7, 8, 9]))
