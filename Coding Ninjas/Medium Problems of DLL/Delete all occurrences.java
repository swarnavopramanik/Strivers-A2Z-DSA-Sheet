https://www.codingninjas.com/studio/problems/delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list_8160461?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0



public class Solution {
    public static Node deleteAllOccurrences(Node head, int k) {
        Node curr = head;
        Node dummy = new Node();
        Node temp = dummy;
        while(curr != null){
            if(curr.data != k){
                dummy.next = curr;
                dummy = dummy.next; 
            }
            curr = curr.next;
        }
        dummy.next = null;
        return temp.next;
    }
}
