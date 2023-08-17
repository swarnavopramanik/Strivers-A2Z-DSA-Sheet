61. Rotate List


  class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        int size = 1;
        ListNode last = head;
        while(last.next != null){
            last = last.next;
            size++;
        }
        last.next = head;

        int index = size - (k % size);
        ListNode newLast = head;
        for(int i = 0; i < index -1; i++){
            newLast = newLast.next;
        }
        head = newLast.next;
        newLast.next = null;
        
        return head;
    }
}
