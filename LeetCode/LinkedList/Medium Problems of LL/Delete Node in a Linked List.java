237. Delete Node in a Linked List

  class Solution {
    public void deleteNode(ListNode node) {
     node.val=node.next.val;
     node.next=node.next.next;
      
    }
}
 

  class Solution {
    public void deleteNode(ListNode node) {
ListNode temp = new ListNode();
        while(node.next !=null)        {
            node.val = node.next.val;
             temp = node;
            node= node.next;
        }

        temp.next = null;
    }
} 
  
