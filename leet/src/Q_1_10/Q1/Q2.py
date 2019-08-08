class Solution(object):
    def twoSum(self, nums, target):
        # 执行用时 :80 ms , 在所有 Python 提交中击败了 60.30% 的用户
        # 内存消耗 :13.4 MB , 在所有 Python 提交中击败了 5.01% 的用户
        dicts = {}
        for i in range(len(nums)):
            a = nums[i]
            if dicts.get(a) != None:
                if target - a == a:
                    return [dicts.get(a), i]
            dicts[a] = i
        print(dicts)
        for i in range(len(nums)):

            a = nums[i]
            print(a)
            if (dicts.get(target - a) != None):
                print(dicts.get(target - a))
                if (target - a == a):
                    continue
                return [i, dicts.get(target - a)]


if __name__ == '__main__':
    s = Solution().twoSum([3, 2, 4], 6)
    print(s)
    # print(0==None)
