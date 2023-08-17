2095. Delete the Middle Node of a Linked List

  
class Solution {
    public ListNode deleteMiddle(ListNode head) {
             if(head == null ||  head.next == null)  return null;
        
        ListNode fast = head.next;
        ListNode slow = head;

        while(fast != null && fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}
