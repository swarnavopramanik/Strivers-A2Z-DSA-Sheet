328. Odd Even Linked List

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode temp = even;

        while(even!=null && even.next!=null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = temp;
        return head;
    }

}


 class Solution {
    public ListNode oddEvenList(ListNode head) {
         if(head==null || head.next == null || head.next.next == null){
            return head;
        }
        ListNode odd = new ListNode(head.val);;
        ListNode even = new ListNode(head.next.val);;
        ListNode oddPtr = odd;
        ListNode evenPtr = even;
        ListNode ptr = head.next.next;
        int count= 2;
        while( ptr!= null){
            count++;
            if(count%2 == 0){
                ListNode n = new ListNode(ptr.val);
                evenPtr.next=n;
                evenPtr=evenPtr.next;
            }
            else{
                ListNode n = new ListNode(ptr.val);
                oddPtr.next=n;
                oddPtr=oddPtr.next;
            }
            if(ptr.next == null){
                oddPtr.next=even;
            }
            ptr=ptr.next;
        }
        return odd;
    }
} 

