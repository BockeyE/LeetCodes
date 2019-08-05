class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        left = 0
        max = 0
        sets = set()
        for i in range(len(s)):
            c = s[i]
            if c in sets:
                while True:
                    if s[left] == c:
                        left += 1
                        break;
                    else:
                        sets.remove(s[left])
                        left += 1
            sets.add(c)
            leth = (i - left) + 1
            if leth > max:
                max = leth
        return max
