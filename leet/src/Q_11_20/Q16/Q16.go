package main

import (
	"fmt"
	"math"
	"sort"
)

//执行用时 :4 ms, 在所有 golang 提交中击败了98.14%的用户
//内存消耗 :2.7 MB, 在所有 golang 提交中击败了61.29%的用户
func threeSumClosest(nums []int, target int) int {
	sort.Ints(nums)
	ans := nums[0] + nums[1] + nums[2]
	for i := 0; i < len(nums); i++ {
		start := i + 1
		ends := len(nums) - 1
		for start < ends {
			sum := nums[i] + nums[start] + nums[ends]
			tem := int(math.Abs(float64(sum) - float64(target)))
			current := int(math.Abs(float64(ans) - float64(target)))
			if tem < current {
				ans = sum
			}
			if sum > target {
				ends--
			} else if sum < target {
				start++
			} else {
				return ans
			}
		}
	}
	return ans
}
func main() {
	c := []int{-1, 1, 2, -4}
	fmt.Println(threeSumClosest(c, 1))
}
