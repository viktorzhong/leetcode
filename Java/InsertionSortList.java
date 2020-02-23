/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0), p = dummy;
        ListNode cur = head, next;
        
        while(cur != null) {
            next = cur.next;
            if (p.next != null && cur.val < p.next.val) p = dummy;
            while(p.next != null && p.next.val <= cur.val) p = p.next;
            cur.next = p.next;
            p.next = cur;
            cur = next;
        }
        return dummy.next;
    }
}