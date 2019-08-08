class Solution(object):
# 执行用时 :96 ms, 在所有 Python 提交中击败了88.73%的用户
# 内存消耗 :11.9 MB, 在所有 Python 提交中击败了25.79%的用户

    def findMedianSortedArrays(self, nums1, nums2):
        A = nums1
        B = nums2

        if len(nums1) > len(nums2):
            B = nums1
            A = nums2

        m = len(A)
        n = len(B)

        iMin = 0
        iMax = m

        halfLen = (m + n + 1) / 2
        while iMin <= iMax:
            i = (iMin + iMax) / 2
            j = halfLen - i
            if i < iMax and B[int(j - 1)] > A[int(i)]:
                iMin = i + 1
            elif i > iMin and A[int(i - 1)] > B[int(j)]:
                iMax = i - 1
            else:
                maxLeft = 0
                if i == 0:
                    maxLeft = B[int(j - 1)]
                elif j == 0:
                    maxLeft = A[int(i - 1)]
                else:
                    maxLeft = float(max(B[int(j - 1)], A[int(i - 1)]))
                if (m + n) % 2 == 1:
                    return maxLeft

                minRight = 0
                if i == m:
                    minRight = B[int(j)]
                elif j == n:
                    minRight = A[int(i)]
                else:
                    minRight = min(B[int(j)], A[int(i)])
                minRight = float(minRight)
                maxLeft = float(maxLeft)
                return float((maxLeft + minRight) / 2)
