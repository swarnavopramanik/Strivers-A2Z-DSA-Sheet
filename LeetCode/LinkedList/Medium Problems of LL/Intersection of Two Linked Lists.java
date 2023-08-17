160. Intersection of Two Linked Lists

     public class Solution {
   public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode ptrA = headA, ptrB = headB;
    while (ptrA != ptrB) { // loop until we found the first common node
    ptrA = ptrA == null ? headB : ptrA.next; // once we're done with A, move to B
    ptrB = ptrB == null ? headA : ptrB.next; // once we're done with B, move to A
	}
	return ptrA;
}
} 

 public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while(headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while(headB != null) {
            if(set.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }
} 
