package RemoveDuplicatesfromSortedListII;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode before = dummy;
        ListNode begin = head;
        ListNode next = head.next;
        while (next != null){
            while (next.val == begin.val) next = next.next;
            if(next != begin.next){
                before.next = next;
                begin = next;
                next = next.next;
            }else {
                before = begin;
                begin = next;
                next = next.next;
            }
        }
        return dummy.next;
    }


}
