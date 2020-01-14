//Given a non-empty array of integers, every element appears twice except for one. Find that single one.
//
// Note:
//
// Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
//
// Example 1:
//
//
//Input: [2,2,1]
//Output: 1
//
//
// Example 2:
//
//
//Input: [4,1,2,1,2]
//Output: 4
//
// Related Topics Hash Table Bit Manipulation


import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int singleNumber(int[] nums) {
    Set<Integer> set = new HashSet<>();

    int sum = 0, sum1 = 0;
    for(int n : nums) {
      if(!set.contains(n)) {
        sum1 += n;
        set.add(n);
      }
      sum += n;
    }

    return 2 * sum1 - sum;
  }
}
//leetcode submit region end(Prohibit modification and deletion)
