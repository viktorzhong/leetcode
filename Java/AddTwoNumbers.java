//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
// Example:
//
//
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.
//
// Related Topics Linked List Math



//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  // Time: O(max(m, n)) Space: O(max(m,n))
  // m,n is the length of l1 and l2
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0), p = dummy;
    int carry = 0;

    while (l1 != null || l2 != null || carry != 0) {
      int sum = carry;
      if(l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }

      if(l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }

      p.next = new ListNode(sum % 10);
      p = p.next;
      carry = sum / 10;
    }

    return dummy.next;
  }
}
