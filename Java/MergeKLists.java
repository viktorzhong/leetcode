/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), p = dummy;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if(l1 != null) p.next = l1;
        if(l2 != null) p.next = l2;

        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> q = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode n : lists) {
            if(n != null) q.offer(n);
        }
        ListNode dummy = new ListNode(0), p = dummy;
        while(!q.isEmpty()) {
            ListNode min = q.poll();
            p.next = min;
            p = p.next;
            if(min.next != null) q.offer(min.next);
        }
        return dummy.next;
    }

    public ListNode mergeKListsOneByOne(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        ListNode res = null;
        for(ListNode l : lists) {
            res = mergeTwoLists(res, l);
        }
        return res;
    }
}