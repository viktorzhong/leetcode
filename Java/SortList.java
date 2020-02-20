/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private void swap(ListNode a, ListNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }

    private void quickSort(ListNode head, ListNode tail) {
        if(head == tail || head.next == tail) return;
        int pivot = head.val;
        ListNode slow = head, fast = head.next;
        
        while(fast != tail) {
            if(fast.val < pivot) {
                slow = slow.next;
                swap(slow, fast);
            }
            fast = fast.next;
        }
        swap(head, slow);
        quickSort(head, slow);
        quickSort(slow.next, tail);
    }

    public ListNode sortList(ListNode head) {
        quickSort(head, null);
        return head;
    }
}