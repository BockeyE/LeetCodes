package main

import "fmt"

//执行用时 :8 ms, 在所有 Go 提交中击败了81.70%的用户
//内存消耗 :2.8 MB, 在所有 Go 提交中击败了70.45%的用户
func lengthOfLongestSubstring(s string) int {

	set := make(map[uint8]int)
	left := 0
	max := 0
	for i := 0; i < len(s); i++ {
		c := s[i]
		_, ok := set[c]
		if ok {
			for {
				if s[left] != c {
					delete(set, s[left])
					left++
				} else {
					left++
					break
				}
			}
		}
		set[c] = i
		leth := (i - left) + 1
		if leth > max {
			max = leth
		}
	}
	return max
}
func main() {
	s := lengthOfLongestSubstring("tmmzuxt")
	//s := lengthOfLongestSubstring("abcabcabc")
	fmt.Println(s)
}
