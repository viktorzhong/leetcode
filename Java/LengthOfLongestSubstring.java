//Given a string, find the length of the longest substring without repeating characters.
//
//
// Example 1:
//
//
//Input: "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//
//
//
// Example 2:
//
//
//Input: "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//
//
//
// Example 3:
//
//
//Input: "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
//
//
//
//
// Related Topics Hash Table Two Pointers String Sliding Window


import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  // Time: O(n) Space: O(m)
  public int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<>();
    int i = 0, j = 0, maxLen = 0;

    for(; i < s.length(); i++) {
      for(; j < s.length(); j++) {
        if(set.contains(s.charAt(j))) break;
        set.add(s.charAt(j));
      }
      maxLen = Math.max(maxLen, j - i);
      set.remove(s.charAt(i));
    }

    return maxLen;
  }
}
//leetcode submit region end(Prohibit modification and deletion)
