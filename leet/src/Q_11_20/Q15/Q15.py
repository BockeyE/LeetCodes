from numpy import sort


# 执行用时 :436 ms, 在所有 python 提交中击败了93.30%的用户
# 内存消耗 :14.9 MB, 在所有 python 提交中击败了71.73%的用户
class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """

        ans = []
        m = 0
        if nums is None or len(nums) < 3:
            return ans
        lenth = len(nums)
        nums = sorted(nums)
        for i in range(lenth):
            if nums[i] > 0:
                break
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            l = i + 1
            r = lenth - 1
            while l < r:
                sums = nums[i] + nums[l] + nums[r]
                if sums == 0:
                    ans.append(0)
                    ans[m] = [nums[i], nums[l], nums[r]]
                    m = m + 1
                    while l < r and nums[l] == nums[l + 1]:
                        l = l + 1
                    while l < r and nums[r] == nums[r - 1]:
                        r = r - 1
                    l = l + 1
                    r = r - 1
                elif sums > 0:
                    r = r - 1
                elif sums < 0:
                    l = l + 1
        return ans


if __name__ == '__main__':
    print(Solution().threeSum([-1, 0, 1, 2, -1, -4]))
