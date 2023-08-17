 2. Add Two Numbers


   // Approach 1 

  class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode ptr1 = l1; // pointer to traverse l1
    ListNode ptr2 = l2; // pointer to traverse l2
    ListNode head = l1; // pointer to the head of the result linked list, initially set to the head of l1
        int sum = 0, carry = 0; // initialize sum and carry to 0
        int num1 = 0, num2 = 0; // initialize num1 and num2 to 0
        
// traverse both linked lists simultaneously until at least one of them is not empty
        while (ptr1 != null || ptr2 != null) {
        if (ptr1 != null) { // if ptr1 is not null, set num1 to its value and move ptr1 to the next node
                num1 = ptr1.val;
                ptr1 = ptr1.next;
            }
             
            if (ptr2 != null) { // if ptr2 is not null, set num2 to its value and move ptr2 to the next node
                num2 = ptr2.val;
                ptr2 = ptr2.next;
            }
            sum = num1 + num2 + carry; // calculate sum
            carry = sum / 10; // calculate carry
            sum = sum % 10; // calculate sum
            
            ListNode n = new ListNode(sum); // create a new node with sum as its value
            l1.next = n; // add the new node to the result linked list
            l1 = l1.next; // move l1 to the next node in the result linked list
            num1 = 0;
            num2 = 0;
            sum = 0;
        }
        if (carry != 0) { // if there is a remaining carry, add a new node to the result linked list with the carry as its value
            ListNode n = new ListNode(carry);
            l1.next = n;
            l1 = l1.next;
        }
        return head.next; // return the head of the result linked list (excluding the dummy node)
    }
} 

// Approach 2

 class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(); 
        ListNode temp = dummy; 
        int carry = 0;
        while( l1 != null || l2 != null || carry == 1) {
            int sum = 0; 
            if(l1 != null) {
                sum += l1.val; 
                l1 = l1.next; 
            }
            
            if(l2 != null) {
                sum += l2.val; 
                l2 = l2.next; 
            }
            
            sum += carry; 
            carry = sum / 10; 
            ListNode node = new ListNode(sum % 10); 
            temp.next = node; 
            temp = temp.next; 
        }
        return dummy.next;
}

} 
