from numpy import sort


# 执行用时 :76   ms, 在所有 python 提交中击败了85.79%的用户
# 内存消耗 :11.7 MB, 在所有 python 提交中击败了37.31%的用户
class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        nums = sorted(nums)
        ans = nums[0] + nums[1] + nums[2]
        for i in range(len(nums)):
            start = i + 1
            end = len(nums) - 1
            while start < end:
                sum = nums[i] + nums[start] + nums[end]
                tem = abs(sum - target)
                current = abs(target - ans)
                if tem < current:
                    ans = sum
                if sum > target:
                    end = end - 1
                elif sum < target:
                    start = start + 1
                else:
                    return ans
        return ans


if __name__ == '__main__':
    print(Solution().threeSumClosest([-1, 1, 2, -4], 1))
