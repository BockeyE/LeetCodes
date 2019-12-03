package main

import (
	"fmt"
	"sort"
)

//执行用时 :32 ms, 在所有 golang 提交中击败了99.26%的用户
//内存消耗 :6.9 MB, 在所有 golang 提交中击败了100.00%的用户
func threeSum(nums []int) [][]int {
	var ans [][]int
	if nums == nil || len(nums) < 3 {
		return ans
	}
	lenth := len(nums)
	sort.Ints(nums)
	for i := 0; i < lenth; i++ {
		if nums[i] > 0 {
			break
		}
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}
		l := i + 1
		r := lenth - 1
		for l < r {
			sums := nums[i] + nums[l] + nums[r]
			if sums == 0 {
				tem := []int{nums[i], nums[l], nums[r]}
				ans = append(ans, tem)
				for l < r && nums[l] == nums[l+1] {
					l = l + 1
				}
				for l < r && nums[r] == nums[r-1] {
					r = r - 1
				}
				l = l + 1
				r = r - 1
			} else if sums > 0 {
				r = r - 1
			} else if sums < 0 {
				l = l + 1
			}
		}
	}
	return ans
}
func main() {
	c := []int{-1, 0, 1, 2, -1, -4}
	fmt.Println(threeSum(c))
}
